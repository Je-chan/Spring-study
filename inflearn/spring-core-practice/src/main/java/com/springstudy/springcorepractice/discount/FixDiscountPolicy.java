package com.springstudy.springcorepractice.discount;

import com.springstudy.springcorepractice.member.Grade;
import com.springstudy.springcorepractice.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    // 무조건 1000원 할인해주는 것으로 정책
    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // 이넘 타입은 == 을 쓰는 것이 맞다
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
