package com.example.hello.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
// Spring Apcplication 이 실행될 때, ApplicationContextProvider 를 만든다
// set 메소드에다 applicationContext 를 주입한다
// 우리는 그것을 받아 static 변수에 받아 둔다.
// 그리고 get 을 사용해서 가져다 쓰면 된다.
public class ApplicationContextProvider implements ApplicationContextAware {


    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
