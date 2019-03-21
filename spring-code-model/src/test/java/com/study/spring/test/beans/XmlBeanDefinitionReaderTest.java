package com.study.spring.test.beans;

import com.study.spring.bean.beans.BeanDefinition;
import com.study.spring.bean.beans.io.Resource;
import com.study.spring.bean.beans.io.ResourceLoader;
import com.study.spring.bean.beans.xml.XmlBeanDefinitionReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by looye on 2019/3/21.
 *
 * @author looye
 * @date 2019/3/21
 */
public class XmlBeanDefinitionReaderTest {
    @Test
    public void test1() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("test1.xml");
        Map<String, BeanDefinition> beanDefinitionMap = xmlBeanDefinitionReader.getRegistry();
        System.out.println(beanDefinitionMap.size());
    }

    @Test
    public void test2() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("test1.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
