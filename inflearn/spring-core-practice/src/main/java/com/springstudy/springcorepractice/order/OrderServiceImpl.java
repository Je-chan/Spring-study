package com.springstudy.springcorepractice.order;

import com.springstudy.springcorepractice.discount.DiscountPolicy;
import com.springstudy.springcorepractice.discount.FixDiscountPolicy;
import com.springstudy.springcorepractice.discount.RateDiscountPolicy;
import com.springstudy.springcorepractice.member.Member;
import com.springstudy.springcorepractice.member.MemberRepository;
import com.springstudy.springcorepractice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 여기에서 문제가 발생한다.
    // 정책을 변경하니까 클라이언트의 로직을 손봐야 한다
    /**
     * 역할과 구현을 충실하게 분리했고, 다형성도 활용하고 인터페이스와 구현 객체를 분리했다
     * 하지만, OCP, DOP 같은 객체 지향 설계 원칙을 충실하게 준수하지 않았다
     *
     * DIP의 문제
     * => 클래스 의존관계를 분석해보자. 인터페이스 뿐만 아니라 구체 클래스에도 의존한다
     * => 즉 DiscountPolicy 만 의존하면 되는 데 FixDiscountPolicy, RateDiscountPolicy 에 의존
     *
     * OCP 의 문제
     * => 지금 코드는 기능을 확장해서 변경하면 클라이언트 코드에 영향을 주고 있다. (아래의 주석처럼)
     */
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 그래서 이렇게 고친다
    // 얘는 인터페이스에만 의존한다. 그래서 구체화에는 의존하지 않는다.
    // 그러나 이것만 가지고는 역할만 존재하고 배우가 없는 것.
    // 그래서 누군가 OrderServiceImpl에 DiscountPolicy 구현 객체를 대신 생성하고 주입해줘야 한다.
//    private DiscountPolicy discountPolicy;
//
//    @Override
//    public Order createOrder(Long memberId, String itemName, int itemPrice) {
//        Member member = memberRepository.findById(memberId);
//
//        // Order Service 의 입장에서는 Discount 에 대한 내용을 모른다.
//        // 즉, 할인에 문제가 있다면 Order Service 에는 영향 없이 Discount 만 고치면 되는 것
//        int discountPrice = discountPolicy.discount(member, itemPrice);
//
//        return new Order(memberId, itemName, itemPrice, discountPrice);
//    }


    // 아래부터 리팩터링 코드
    // 여기서부터는 discountPolicy 가 정확히 어떤 구현체로 들어올지 모르고, 그냥 단순히 interface 만 바라본다
    // 대본 보고 이 로직만 실행하는 느낌
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // Order Service 의 입장에서는 Discount 에 대한 내용을 모른다.
        // 즉, 할인에 문제가 있다면 Order Service 에는 영향 없이 Discount 만 고치면 되는 것
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
