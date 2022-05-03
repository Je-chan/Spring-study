package com.example.validation.annotation;

import com.example.validation.validator.YearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// 아래의 세 어노테이션은 @Email 에 타고 들어가서 베낀 것에 불과함
// validatedBy 안에 어떤 클래스를 검사할 것인지 클래스를 넣는다
@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)

public @interface YearMonth {

    // 에러 메세지를 만들어 내는 것
    String message() default "yyyyMM 의 형식에 맞지 않습니다";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // Annotation 을 작성하면 어떤 패턴을 받을 것인지 결정하는 것
    // default 를 통해서 @YearMonth(pattern = "yyyyMMdd") 이 기본 형식이 된다.
    // 사용자는 yyyyMM 만 작성하지만, 백엔드에서는 +"01" 을 해서 yyyyMMdd 형식을 만들어낸다
    // 즉 Pattern Validation 파악을 위해서 yyyyMMdd 가 맞다고 하면 사용자는 yyyyMM 형식으로 잘 보낸 것
    String pattern() default "yyyyMMdd";
}
