package com.study.spring.bean.context;

import com.study.spring.bean.beans.BeanDefinition;
import com.study.spring.bean.beans.factory.AbstractBeanFactory;
import com.study.spring.bean.beans.factory.AutowireCapableBeanFactory;
import com.study.spring.bean.beans.io.ResourceLoader;
import com.study.spring.bean.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by looye on 2019/3/14.
 *
 * @author looye
 * @date 2019/3/14
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory factory, String configLocation) throws Exception{
        super(factory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
