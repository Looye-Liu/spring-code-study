package com.study.spring.test;

import com.study.spring.bean.BeanDefinition;
import com.study.spring.bean.io.ResourceLoad;
import com.study.spring.bean.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by looye on 2019/3/7.
 *
 * @author looye
 * @date 2019/3/7
 */
public class XmlTest {
    @Test
    public void test1() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinition("test1.xml");
        Map<String, BeanDefinition> beanDefinitionMap = xmlBeanDefinitionReader.getRegistry();
        System.out.println(beanDefinitionMap.size());
    }
}
