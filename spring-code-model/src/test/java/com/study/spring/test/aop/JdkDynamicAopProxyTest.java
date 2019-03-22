package com.study.spring.test.aop;

import com.study.spring.bean.aop.AdvisedSupport;
import com.study.spring.bean.aop.JdkDynamicAopProxy;
import com.study.spring.bean.aop.TargetSource;
import com.study.spring.bean.context.AbstractApplicationContext;
import com.study.spring.bean.context.ApplicationContext;
import com.study.spring.bean.context.ClassPathXmlApplicationContext;
import com.study.spring.test.HelloWorldService;
import com.study.spring.test.aop.TimerInterceptor;
import org.junit.Test;

/**
 * Created by looye on 2019/3/18.
 *
 * @author looye
 * @date 2019/3/18
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test1.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService proxHelloWorldService = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        proxHelloWorldService.helloWorld();
    }
}
