package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    
    @NotBlank
    private String name;
    private int age;
    // Valid 에 Email 이 존재
    @Email
    private String email;
    // Pattern 이라는 어노테이션으로 정규표현식을 사용한 Validation 이 가능하다.
    // message 는 에러메세지
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message="핸드폰 번호의 양식과 맞지 않습니다. xxx-xxx(x)-xxxx")
    private String phoneNumber;

//    @Size(min = 6, max=6) // 원하는 형태는 YYYYMM. Size 만으로는 우리가 원하는 형태만을 얻을 수 없다. (111101 이면 안 된다)
    // 우리가 원하는 형태가 맞는지를 확인하기 위해서 따로 메소드를 만들어 낸다.
    // 다른 방법으로 새로운 어노테이션을 만드는 것

    @YearMonth
    private String reqYearMonth;


    // Getter And Setter
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

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }


//    YearMonthVAlidator 를 만들어서 더 이상 사용할 필요가 없어짐
//    AssrtTrue 를 사용하면 User 에서만 사용하기 때문에 범용성이 낮은 것
//    @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다")
//    // boolean 이 리턴 타입일 때는 메소드명 앞에 is 가 있어야 한다.
//    public boolean isReqYearMonthValidation () {
//        try {
//            LocalDate localDate = LocalDate.parse(getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        } catch(Exception e) {
//            return false;
//        }
//
//        return true;
//    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}
