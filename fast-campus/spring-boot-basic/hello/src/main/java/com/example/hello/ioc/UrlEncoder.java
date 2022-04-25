package com.example.hello.ioc;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Interface 사용하기 전

//public class UrlEncoder {
//
//    public String encode(String message) {
//
//        try {
//            return URLEncoder.encode(message, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}

// 스프링이 실행될 떄 직접 객체를 싱글톤의 형태로 만들어서 관리를 하게 된다
@Component
public class UrlEncoder implements IEncoder{

    public String encode(String message) {

        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
