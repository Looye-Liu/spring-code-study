package com.study.spring.test;

import com.study.spring.bean.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by looye on 2019/3/14.
 *
 * @author looye
 * @date 2019/3/14
 */
public class ApplicationTest {
    @Test
    public void test1() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("test1.xml");
        HelloWorldService helloWorldService = (HelloWorldService) classPathXmlApplicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
