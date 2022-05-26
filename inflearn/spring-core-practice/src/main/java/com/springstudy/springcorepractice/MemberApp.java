package com.springstudy.springcorepractice;

import com.springstudy.springcorepractice.member.Grade;
import com.springstudy.springcorepractice.member.Member;
import com.springstudy.springcorepractice.member.MemberService;
import com.springstudy.springcorepractice.member.MemberServiceImpl;
import com.springstudy.springcorepractice.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    // 자바 코드
//    public static void main(String[] args) {
////        MemberService memberService = new MemberServiceImpl();
////        Member member = new Member(1L, "memberA", Grade.VIP);
////        memberService.join(member);
////
//        // 자바 코드로 DI 를 한 후에는 다음과 같이 리팩터링할 수 있다
//        AppConfig appConfig = new AppConfig();
//        // 아래 memberService 안에는 memberServiceImpl 이 들어가 있을 것
//        MemberService memberService = appConfig.memberService();
//        Member member = new Member(1L, "memeberA", Grade.VIP);
//        memberService.join(member);
//
//        Member findMember = memberService.findMember(1L);
//        System.out.println("new Member = " + member.getName());
//        System.out.println("find Member = " + member.getName());
//    }

    // 스프링 코드
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // ApplicationContext 는 스프링 컨테이너. 객체를 등록할 곳
        // AppConfig 에 있는 환경설정 정보를 갖고 스프링 Bean 에 다 집어 넣어서 관리를 한다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // getBean(메소드명, 타입)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memeberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + member.getName());
    }
}
