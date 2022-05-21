package com.springstudy.springcorepractice.discount;

import com.springstudy.springcorepractice.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
