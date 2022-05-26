package com.springstudy.springcorepractice.beanFind;

import com.springstudy.springcorepractice.member.MemberService;
import com.springstudy.springcorepractice.member.MemberServiceImpl;
import com.springstudy.springcorepractice.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    // 웬만함녀 구체적으로 적는 것은 좋지 않다.
    // 이 코드는 구현에 의존했기에 좋은 코드는 아니지만, 그럼에도 필요할 때는 있다
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 안 됐을 때")
    void findBeanByNameX() {
        // 만들지 않은 Bean 을 사용하고자 하면 NoSuchBeanDefinitionException 이라는 에러를 발생시킴
//        ac.getBean("xxx", MemberService.class);

        // assertThrows 를 통해서 에러를 내야지만 통과하는 케이스로 만들 수 있다
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxx", MemberService.class));

    }


}
