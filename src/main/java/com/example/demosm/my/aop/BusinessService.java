package com.example.demosm.my.aop;

import com.example.demosm.my.aop.pojo.Child;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {


    private Logger log = LoggerFactory.getLogger(BusinessService.class);

    public void logic() {
        log.info("service");
    }

    @NeedTest
    public void withAnnotation() {
        log.info("service");
    }

    public void logicWithAnnotatedArgs1(Child c) {
        log.info("service");
    }

    //public void logicWithAnnotatedArgs2(GrandChild g) {
    //    log.info("service");
    //}
    //
    //public void logicWithAnnotatedArgs3(Pa p) {
    //    log.info("service");
    //}

    //public String doSomething(MyClass myClass, int i) {
    //    return "blah";
    //}
}
