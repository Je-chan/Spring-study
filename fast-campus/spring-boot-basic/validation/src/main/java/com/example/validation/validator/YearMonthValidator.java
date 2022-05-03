package com.example.validation.validator;

import com.example.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// YearMonth 어노테이션을 사용할 클래스를 만드는 것
// ConstraintValidator 를 사용하면 Validator 클래스 만들 수 있게 되는 데 첫 번재 Generic 으로는 Annotation, 두 번째는 우리가 받을 값
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    // Alt + Enter 로 기본적으로 받아야 하는 메소드들을 받는다
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {


        // value 에 +"01" 을 붙이는 이유?
        // yyyyMM 을 만들고 싶어도 localDate 가 yyyyMMdd 형식을 만들어내기 때문에 dd 를 "01" 로 만드는 것

        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));
        } catch(Exception e) {
            return false;
        }

        return false;
    }
}
