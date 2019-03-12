package com.study.spring.test;

import com.study.spring.bean.BeanDefinition;
import com.study.spring.bean.PropertyValue;
import com.study.spring.bean.PropertyValues;
import com.study.spring.bean.factory.AutowireCapableBeanFactory;
import com.study.spring.bean.factory.BeanFactory;
import com.study.spring.bean.io.ResourceLoad;
import com.study.spring.bean.xml.XmlBeanDefinitionReader;
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

    @Test
    public void test2() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinition("test1.xml");

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
