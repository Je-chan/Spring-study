package com.example.hello;

import com.example.hello.ioc.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        // DI의 개념

        // 아래의 url 을 Base64 로 인코딩 하는 것이 목적이라고 한다면 다음과 같이 코드를 생성할 수 있을 것
        String url = "www.naver.com/books/it?page=10&size=2&name=spring-boot";

        // Base 64 Encoding
//    Encoder encoder = new Encoder();
//    String result = encoder.encode(url);
//    System.out.println(result);

        // url Encoding 이 필요하다는 요구사항이 추가 된다면?
//        UrlEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);

        // 조금 더 추상화를 한다고 하면 Interface 로 빼낼 수 있음
//        IEncoder encoder = new Base64Encoder();
//        String result = encoder.encode(url);
//
//        IEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);

        // 여기서 DI 를 도입하면 다음의 코드가 된다
        // 아래와 같이 DIEncoder 를 건드릴 필요가 없이 인자만 내가 원하는 객체로 주입시키면 그에 맞춰서 변화가 일어난다
        // Base64Encoder 나 UrlEncoder 를 만들어서 상속 받아 주입시키기만 하면 내가 넣은 객체에 따라서 동작하게 된다.
        // 이게 DI 의 개념
//        DIEncoder diEncoder = new DIEncoder(new Base64Encoder());
//        DIEncoder diEncoder = new DIEncoder(new UrlEncoder());
//        String result = diEncoder.encode(url);





        SpringApplication.run(HelloApplication.class, args);
        // 이후 부터는 IOC 의 개념
        // Base64 와 Url Encoder 에 @Component 어노테이션을 사용해 Bean 에 객체를 맡긴 경우

//        ApplicationContext context = ApplicationContextProvider.getContext();
//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
//        DIEncoder diEncoder = new DIEncoder(base64Encoder);
//
//        String result = diEncoder.encode(url);
//
//        diEncoder.setIEncoder(urlEncoder);
//        result = diEncoder.encode(url);

        // 더 나아가 DIEnocder 마저도 @Component 를 사용한 경우
        // 이 때, 타입으로 base64 를 지정
        // 이후 더이상 new 키워드를 사용한 것을 확인할 수 없다.
        // 모든 객체를 Spring 에서 관리하고 있기 때문. 그런 객체들을 Bean 이라고 한다.
//        ApplicationContext context = ApplicationContextProvider.getContext();
//        DIEncoder diEncoder = context.getBean(DIEncoder.class);
//        String result = diEncoder.encode(url);

        // 더 나아가서 base64 뿐만 아니라 url 까지 모두 사용하고 싶을 경우에는?
        ApplicationContext context = ApplicationContextProvider.getContext();
        DIEncoder diEncoder = context.getBean("newBase64Encoder", DIEncoder.class);
        String result = diEncoder.encode(url);
        System.out.println(result);

        DIEncoder diEncoder1 = context.getBean("newUrlEncoder", DIEncoder.class);
        String result1 = diEncoder1.encode(url);
        System.out.println(result1);

    }

}

//
@Configuration
class AppConfig {


    @Bean("newBase64Encoder")
    public DIEncoder encoder(Base64Encoder base64Encoder) {
        return new DIEncoder(base64Encoder);
    }

    @Bean("newUrlEncoder")
    public DIEncoder encoder(UrlEncoder urlEncoder) {
        return new DIEncoder(urlEncoder);
    }
}