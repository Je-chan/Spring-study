package com.springstudy.springcorepractice;

import com.springstudy.springcorepractice.member.Grade;
import com.springstudy.springcorepractice.member.Member;
import com.springstudy.springcorepractice.member.MemberService;
import com.springstudy.springcorepractice.member.MemberServiceImpl;
import com.springstudy.springcorepractice.order.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//
        // 자바 코드로 DI 를 한 후에는 다음과 같이 리팩터링할 수 있다
        AppConfig appConfig = new AppConfig();
        // 아래 memberService 안에는 memberServiceImpl 이 들어가 있을 것
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memeberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + member.getName());
    }
}
