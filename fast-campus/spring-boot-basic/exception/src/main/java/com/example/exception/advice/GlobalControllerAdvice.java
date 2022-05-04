package com.example.exception.advice;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    // Exception 이 일어나는, 전체적인 예외, 스프링 웹 어플리케이션에서 발생하는 에러 모두 잡겠다는 것을 의미함
    @ExceptionHandler(value = Exception.class)
    // 인자로 받아들이는 e 는 위의 Exception.class 를 값으로 받아온다.
    public ResponseEntity exception(Exception e) {
        // 아래의 코드로 어디에서 에러가 발생한 것인지를 알려준다.
        System.out.println(e.getClass().getName());
        System.out.println("======================================");
        System.out.println(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    // 아래의 클래스는 17번째 줄을 통해서 얻은 에러가 발생한 클래스를 가져온 것
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException (HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
