import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("k5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");


        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);

        user.setCars(carList);

        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);

        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        // asText, asInt 를 활용해서 JSON의 키값을 형변환한다.
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("name : " + _name);
        System.out.println("name : " + _age);

        // Car 의 경우 배열이라는 또 다른 Node
        // 위에서 처럼 String, int 등의 우리가 알기 쉬운 타입으로 지정할 수 없다.
        // 심지어 asText, asInt 도 불가능한 형태
        // 이런 경우, ArrayNode 를 사용해서 받은 후, 다시 우리가 원하는 형태의 Node Type 으로 지정해줘야 한다

        JsonNode cars = jsonNode.get("cars");
        // cars 가 어찌됐든 큰 범위 내에서 ArrayNode 기 때문에 ArrayNode 로 형변환이 가능한 것
        ArrayNode arrayNode = (ArrayNode)cars;

        // convertValue 는 map을 객체로 바꾼다든지, 여러 Object 를 우리가 원하는 Class 로 매핑할 수 있다
        // TypeReference 에는 우리가 받고자 하는 Generic Type 을 넣어주면 된다.
        // 이렇게 하면 arrayNode 를 List<Car> 의 타입으로 다시 형변환을 해서 객체로 가져온다
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_cars);

        // JsonNode 타입에서는 받은 json 값을 변경할 수 없다
        // 하지만 ObjectNode 에서는 가능하다
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "liebe");
        objectNode.put("age", 20);

        // JSON 을 예쁘게 출력한다는 의미에서 to Pretty String 임
        System.out.println(objectNode.toPrettyString());
    }



}