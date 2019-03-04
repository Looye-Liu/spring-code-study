package com.study.spring.bean.factory;

import com.study.spring.bean.BeanDefinition;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    public Object initBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
