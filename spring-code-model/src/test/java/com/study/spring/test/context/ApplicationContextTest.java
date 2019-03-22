package com.study.spring.test.context;

import com.study.spring.bean.context.ApplicationContext;
import com.study.spring.bean.context.ClassPathXmlApplicationContext;
import com.study.spring.test.HelloWorldService;
import org.junit.Test;

/**
 * Created by looye on 2019/3/14.
 *
 * @author looye
 * @date 2019/3/14
 */
public class ApplicationContextTest {
    @Test
    public void test1() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("test1.xml");
        HelloWorldService helloWorldService = (HelloWorldService) classPathXmlApplicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPostBeanProcessor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test2.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
