package com.study.spring.test;

import com.study.spring.bean.aop.AdvisedSupport;
import com.study.spring.bean.aop.JdkDynamicAopProxy;
import com.study.spring.bean.aop.TargetSource;
import com.study.spring.bean.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by looye on 2019/3/18.
 *
 * @author looye
 * @date 2019/3/18
 */
public class AopTest {

    @Test
    public void test1() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("test1.xml");
        HelloWorldService helloWorldService = (HelloWorldService) classPathXmlApplicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        TestInterceptor testInterceptor = new TestInterceptor();
        advisedSupport.setMethodInterceptor(testInterceptor);

        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService proxHelloWorldService = (HelloWorldService) jdkDynamicAopProxy.getProxy();
        proxHelloWorldService.helloWorld();
    }
}
