package com.example.demosm.my.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect {

    @Pointcut("this(a)")
    public void businessServiceObject(BusinessService a) {};

    @Before(value = "businessServiceObject(b)")
    public void beforeBusinessServiceObject(JoinPoint point, BusinessService b) {
        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Arrays.asList(args).stream().map(a -> a.getClass().getName()).forEach(System.out::println);
        }
        log.info("aspect: before businessServiceObject");
    }

    @AfterReturning("@annotation(n)")
    public void afterReturningFromAnnotated(NeedTest n) {
        log.info("aspect: after annotated {}", n.value());
    }

    @After("@args(NeedTestClass)")
    public void afterReturningAtArgs() {
        log.info("aspect: after @args");
    }

}
