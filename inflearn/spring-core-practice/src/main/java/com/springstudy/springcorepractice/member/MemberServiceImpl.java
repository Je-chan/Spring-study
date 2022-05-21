package com.springstudy.springcorepractice.member;

// 구현체가 하나만 있을 때는 관례상 뒤에 Impl 이라고 쓴다
public class MemberServiceImpl implements MemberService{

    // 가입을 하고 회원을 찾기 위해선 Repository 인터페이스가 필요하다.
    // 그런데, 인터페이스만 가지고 이ㅣㅆ으면 아무것도 할 수가 없다. 구현체가 있어야 할 것
    // 그래서 구현 객체를 선택해줘야 한다
    /**
     * 그러니 여기에서 발생하는 문제가 바로, 의존 관계까 MemberRepository Interface 뿐만 아니라 구현체도 의존한다
     * 변경이 있다면 문제가 생기므로 DIP 를 위반하고 있다
     */

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId)
    }
}
