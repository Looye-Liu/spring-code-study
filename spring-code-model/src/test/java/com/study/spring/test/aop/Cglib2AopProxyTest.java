package com.study.spring.test.aop;

import com.study.spring.bean.aop.AdvisedSupport;
import com.study.spring.bean.aop.Cglib2AopProxy;
import com.study.spring.bean.aop.TargetSource;
import com.study.spring.bean.context.ApplicationContext;
import com.study.spring.bean.context.ClassPathXmlApplicationContext;
import com.study.spring.test.HelloWorldService;
import com.study.spring.test.HelloWorldServiceImpl;
import org.junit.Test;

/**
 * Created by looye on 2019/3/22.
 *
 * @author looye
 * @date 2019/3/22
 */
public class Cglib2AopProxyTest {

    @Test
    public void test() throws Exception {
        // --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test1.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

        // --------- helloWorldService with AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldServiceImpl.class, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) cglib2AopProxy.getProxy();
        helloWorldServiceProxy.helloWorld();
    }
}
