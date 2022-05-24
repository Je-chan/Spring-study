package com.springstudy.springcorepractice;

import com.springstudy.springcorepractice.member.Grade;
import com.springstudy.springcorepractice.member.Member;
import com.springstudy.springcorepractice.member.MemberService;
import com.springstudy.springcorepractice.order.AppConfig;
import com.springstudy.springcorepractice.order.Order;
import com.springstudy.springcorepractice.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("total price = " + order.calculatePrice());
    }
}
