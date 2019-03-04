package com.study.spring.test;

import com.study.spring.bean.BeanDefinition;
import com.study.spring.bean.PropertyValue;
import com.study.spring.bean.PropertyValues;
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
    public void test1() throws Exception {

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanName("com.study.spring.test.HelloWorldService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.getPropertyValueList().add(new PropertyValue("text", "哇哈哈"));
        beanDefinition.setPropertyValues(propertyValues);

        AutowireCapableBeanFactory autowireCapableBeanFactory = new AutowireCapableBeanFactory();
        autowireCapableBeanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) autowireCapableBeanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
        helloWorldService.sayWhat();
    }
}
