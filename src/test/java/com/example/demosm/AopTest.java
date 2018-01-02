package com.example.demosm;

import com.example.demosm.my.aop.BusinessService;
import com.example.demosm.my.aop.pojo.Child;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class AopTest {

    @Autowired
    private BusinessService myBusinessService;


    @Test
    public void testThisPCD() {
        myBusinessService.logic();
    }

    @Test
    public void testAtAnnotationPCD() {
        myBusinessService.withAnnotation();
    }

	// this does not work when MyAspect has @Component
    @Test
    public void testAtArgsPCD() {
        myBusinessService.logicWithAnnotatedArgs1(new Child());
    }

	// works if MyAspect does not have @Component
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "classpath:conf-atargs.xml");
        BusinessService businessService = ctx.getBean("businessService", BusinessService.class);
        businessService.logicWithAnnotatedArgs1(new Child());
    }
}
