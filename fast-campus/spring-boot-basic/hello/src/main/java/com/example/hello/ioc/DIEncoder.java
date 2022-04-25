package com.example.hello.ioc;

import java.util.Base64;

public class DIEncoder {

    private IEncoder iEncoder;

    public DIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;

    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }


}
