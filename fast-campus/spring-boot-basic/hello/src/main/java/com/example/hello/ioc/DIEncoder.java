package com.example.hello.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class DIEncoder {

    private IEncoder iEncoder;

    // Bean 은 Spring 에서 관리하고 있는 IEncoder 가 두 개의 타입(클래스)이 있기 때문에 에러를 발생시킨다.
    // 이런 경우, Qualifier 어노테이션을 사용해서 어떤 타입(클래스)를 사용해줄 것인지 명시해야 한다
    // 이름은 카멜케이스로 작성하게 되고, @Component(사용자가지정한이름) 이렇게 어노테이션 작성을 했으면 지정한 이름을 적어야 한다

    public DIEncoder(@Qualifier("base64Encoder") IEncoder iEncoder) {
        this.iEncoder = iEncoder;

    }

    public void setIEncoder (IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }


}
