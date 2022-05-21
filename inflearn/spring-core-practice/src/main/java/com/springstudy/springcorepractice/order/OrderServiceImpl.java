package com.springstudy.springcorepractice.order;

import com.springstudy.springcorepractice.discount.DiscountPolicy;
import com.springstudy.springcorepractice.discount.FixDiscountPolicy;
import com.springstudy.springcorepractice.member.Member;
import com.springstudy.springcorepractice.member.MemberRepository;
import com.springstudy.springcorepractice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // Order Service 의 입장에서는 Discount 에 대한 내용을 모른다.
        // 즉, 할인에 문제가 있다면 Order Service 에는 영향 없이 Discount 만 고치면 되는 것
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
