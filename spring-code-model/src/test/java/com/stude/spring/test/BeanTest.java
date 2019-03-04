package com.stude.spring.test;

import com.study.spring.bean.BeanDefinition;
import com.study.spring.bean.factory.AutowireCapableBeanFactory;
import org.junit.Test;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public class BeanTest {
    @Test
    public void test1() {
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanName("com.stude.spring.test.HelloWorldService");

        AutowireCapableBeanFactory autowireCapableBeanFactory = new AutowireCapableBeanFactory();
        autowireCapableBeanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) autowireCapableBeanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
