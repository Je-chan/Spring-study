package com.springstudy.springcorepractice.discount;

import com.springstudy.springcorepractice.member.Grade;
import com.springstudy.springcorepractice.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
