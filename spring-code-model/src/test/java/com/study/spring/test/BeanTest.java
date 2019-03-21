package com.study.spring.test;

import com.study.spring.bean.beans.BeanDefinition;
import com.study.spring.bean.beans.PropertyValue;
import com.study.spring.bean.beans.PropertyValues;

import com.study.spring.bean.beans.factory.AbstractBeanFactory;
import com.study.spring.bean.beans.factory.AutowireCapableBeanFactory;
import com.study.spring.bean.beans.io.ResourceLoad;
import com.study.spring.bean.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

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
        beanDefinition.setBeanName("com.study.spring.test.HelloWorldServiceImpl");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.getPropertyValueList().add(new PropertyValue("text", "哇哈哈"));
        beanDefinition.setPropertyValues(propertyValues);

        com.study.spring.bean.beans.factory.AutowireCapableBeanFactory autowireCapableBeanFactory = new AutowireCapableBeanFactory();
        autowireCapableBeanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        autowireCapableBeanFactory.preInstantiateSingletons();

        HelloWorldService helloWorldService = (HelloWorldService) autowireCapableBeanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
        helloWorldService.sayWhat();
    }

    @Test
    public void test2() throws Exception {
        // 1.获取配置信息
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinition("test1.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

        HelloRefrenceService refrenceService = (HelloRefrenceService)beanFactory.getBean("refHelloWorldService");
        refrenceService.printHello();
    }
}
