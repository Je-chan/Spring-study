package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoPost {
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String account;
    private String email;
    private String address;
    private String password;

    // 이렇게 하면 JSON 에서 스네이크 케이스로 넘어오더라도 phoneNumber 로 받아들인다
    // 카멜 케이스가 아닌 것들은 다 이렇게 해서 카멜케이스로 사용할 수 있도록 만들어 주면 된다
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "DtoPost{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
