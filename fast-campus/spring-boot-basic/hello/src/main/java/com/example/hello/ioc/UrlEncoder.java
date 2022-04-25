package com.example.hello.ioc;

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
