package com.example.hello;

import com.example.hello.dto.UserObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class  HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("------------------");

        // Object Mapper
        // Text 형태의 Json 을 Object 로 바꿔주고 Object 를 Text Json 의 형태로 바꿔준다.
        // controller 에서 req Json 이 오면 object 로 바꿔주고, response object 를 json 으로 바꿔주는 역할

        var objectMapper = new ObjectMapper();

        // 1. object 를 text 로 바꾸는 작업
        // 이 때, Object mapper 는 get Method 를 참조한다.

        var user = new UserObjectMapper("Je", 13, "010-0000-0000");

        // 에러가 날 수 있기 때문에 throws JsonProcessingException 을 해줘야 한다.
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // 2. text 를 Object 로 바꾸는 작업
        // readValue 라는 메소드를 사용하는데 첫 번째 인자로는 Text, 두 번째 인자는 이 Text 를 어떤 클래스로 읽을 것인지
        // ObjectMapper 는 기본 생성자가 있어야만 작동을 한다.
        // 그렇기 떄문에 생성자 Overriding 을 한다 하더라로 기본 생성자는 그대로 만들어 둬야 한다.
        var objectUser = objectMapper.readValue(text, UserObjectMapper.class);
        System.out.println(objectUser);
    }

}
