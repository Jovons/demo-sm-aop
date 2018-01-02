package com.example.demosm.my.aop;

import com.example.demosm.my.aop.pojo.Child;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BusinessService {


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
