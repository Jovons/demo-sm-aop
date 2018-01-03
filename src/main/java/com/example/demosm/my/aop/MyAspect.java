package com.example.demosm.my.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {

    private Logger log = LoggerFactory.getLogger(MyAspect.class);

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
        log.info("aspect: after @annotation {}", n.value());
    }

    //@After("@args(com.example.demosm.my.aop.NeedTestClass)")
    //public void afterReturningAtArgs() {
    //    log.info("aspect: after @args");
    //}

}
