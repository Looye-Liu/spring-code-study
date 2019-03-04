package com.study.spring.bean.factory;

import com.study.spring.bean.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = initBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    public abstract Object initBean(BeanDefinition beanDefinition);
}
