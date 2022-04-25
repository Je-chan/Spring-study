package com.example.hello.ioc;


import java.util.Base64;

// Interface 도입하기 전

//public class Base64Encoder {
//
//  public String encode(String message) {
//      return Base64.getEncoder().encodeToString(message.getBytes());
//  }
//}

// Interface 도입 후, DI 도입 전

public class Base64Encoder implements IEncoder{

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
