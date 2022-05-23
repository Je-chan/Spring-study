package com.springstudy.springcorepractice.member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
