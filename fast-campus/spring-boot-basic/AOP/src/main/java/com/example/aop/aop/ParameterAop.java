package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// Aspect 로 AOP 로 관리
@Aspect
// Component 로 Spring 에서 관리
@Component
public class ParameterAop {

    // AOP 로 볼 것들을 Pointcut 으로
    // controller 안에 있는 모든 것을 AOP 로 본다
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut()  {}

    // cut() 메소드가 실행되는 지점, 그 이전에(Before) before 메소드를 실행
    @Before("cut()")
    // JoinPoint 를 이용해서 들어가는 지점을 확인할 수 있다
    public void before(JoinPoint joinPoint) {
        // MethodSignature : 메소드 이름을 가져올 수 있다

        // joinPoint 에서 메소드를 확인할 수 있으므로 타입이 다른 건 형변환 시킨다/
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        // 메소드의 매개변수들의 배열값
        Object[] args = joinPoint.getArgs();

        // 메소드의 이름은 JoinPoint 에서 가져올 수 있다
        for(Object obj: args) {
             System.out.println("Value : " + obj);
        }

    }

    // cut() 메소드가 실행되는 지점, 그 리턴 값이 나올 때 afterReturn 메소드를 실행
    // 리턴하는 값은 returning 할당된 값에 들어간다
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("Return Obj");
        System.out.println(returnObj);
    }
}
