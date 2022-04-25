package com.example.hello;

import com.example.hello.ioc.Base64Encoder;
import com.example.hello.ioc.DIEncoder;
import com.example.hello.ioc.IEncoder;
import com.example.hello.ioc.UrlEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
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
        DIEncoder diEncoder = new DIEncoder(new UrlEncoder());
        String result = diEncoder.encode(url);


        SpringApplication.run(HelloApplication.class, args);
    }

}
