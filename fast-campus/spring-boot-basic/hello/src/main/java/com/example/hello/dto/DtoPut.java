package com.example.hello.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

// 클래스 전체에 네이밍 룰을 넣는다
// 해당 클래스 오브젝트 맵퍼라는 모듈이 동장학 때 스네이크 케이스로 인식한다. 일관적으로 모든 룰을 적용
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DtoPut {

    private String name;
    private int age;
    private List<Car> carList;

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

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "DtoPut{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
