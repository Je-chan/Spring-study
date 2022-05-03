package com.example.validation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User {

    @NotBlank
    private String name;
    private int age;
    // Valid 에 Email 이 존재
    @Email
    private String email;

    // Pattern 이라는 어노테이션으로 정규표현식을 사용한 Validation 이 가능하다.
    // message 는 에러메세지
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$", message="핸드폰 번호의 양식과 맞지 않습니다. xxx-xxx(x)-xxxx")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
