package com.study.spring.bean.factory;

import com.study.spring.bean.BeanDefinition;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
