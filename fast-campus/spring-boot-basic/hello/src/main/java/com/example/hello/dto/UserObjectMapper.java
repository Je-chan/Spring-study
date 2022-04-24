package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserObjectMapper {

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;


    // 생성자 오버라이딩
    public UserObjectMapper(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // ObjectMapper에서 text -> object 로 바꿔주기 위해 필요한 기본 생성자
    public UserObjectMapper() {
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    // 이렇게 getter 용도 이외의 method 에 get 을 사용하는 건 지양해야 한다.
    // ObjectMapper 가 get을 키워드로 받아들이기 때문에 에러를 발생시키기 때문
    // Request, Response 에서 ObjectMapper 를 사용하기 때문에 get 을 사용하지 말아야 한다.
//    public UserObjectMapper getDefaultUser() {
//        return new UserObjectMapper("default", 0, "010-000-000");
//    }


    // Objectmapper에서 object -> text 로 바꿔주기 위해 필요한 getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "UserObjectMapper{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
