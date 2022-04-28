package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeAop {

    // 포인트 컷: aop 하위에 컨트롤러 하위에 있는 모든 것
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut()  {}

    // 패키지 하위에 있는 Timer 에 존재하는 메소드들은 포인트 컷
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer () {

    }

    // Before 와 After 모두 사용하고자 할 때 Around 를 사용한다
    // 즉, 메소드 실행 전과 후 모두를 사용하고자 할 때.
    @Around("cut() && enableTimer()")
    public void around (ProceedingJoinPoint joinPoint) throws Throwable {
        // 실제 코드에서 작성하는 것이 아니라 이렇게 굳이 AOP 를 만드는 이유?
        // > 1. 실질적인 비즈니스 코드와 상관이 없는 코드이므로 비즈니스 코드와 분리
        // > 2. 동일하고 반복된 코드이므로 따로 빼주는 것

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // joinPoint.proceed() 를 호출하면 실질적으로 메소드가 실행되는 것
        // 리턴 타입이 있다고 한다면 result 에 담긴다.
        // 우리는 Timer 를 실행 전에는 이 proceed를 기준으로 위, 실행 후는 아래가 된다
        Object result = joinPoint.proceed();

        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());

    }
}


