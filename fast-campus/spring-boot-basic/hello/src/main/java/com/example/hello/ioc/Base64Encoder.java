package com.example.hello.ioc;


import org.springframework.stereotype.Component;

import java.util.Base64;

// Interface 도입하기 전

//public class Base64Encoder {
//
//  public String encode(String message) {
//      return Base64.getEncoder().encodeToString(message.getBytes());
//  }
//}

// Interface 도입 후, DI 도입 전

// Component 어노테이션을 사용하면 이 객체를 Bean 으로 등록한다는 의미가 된다.
@Component
public class Base64Encoder implements IEncoder{

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
