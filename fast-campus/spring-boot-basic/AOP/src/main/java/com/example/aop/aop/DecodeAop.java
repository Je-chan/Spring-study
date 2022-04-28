package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut()  {}

    // 패키지 하위에 있는 Timer 에 존재하는 메소드들은 포인트 컷
    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode () {}

    // 전에는 디코딩을 해서 받아오고
    // 후에는 인코딩을 해서 내보낼 것


    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {

        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            // 그 argument 가 내가 원하는 객체, User 여야 한다
            if(arg instanceof User) {
                // argument 를 받아서 클래스를 형변환 시키는 것
                User user = User.class.cast(arg);
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");

                // 디코딩한 값으로 다시 넣는다.
                user.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn (JoinPoint joinPoint, Object returnObj) {
        if(returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());


            // 디코딩한 값으로 다시 넣는다.
            user.setEmail(base64Email);
        }
    }
}
