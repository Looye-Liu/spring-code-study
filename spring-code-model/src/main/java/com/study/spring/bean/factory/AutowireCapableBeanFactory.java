package com.study.spring.bean.factory;

import com.study.spring.bean.BeanDefinition;
import com.study.spring.bean.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = initBean(beanDefinition);
        applyProperty(bean, beanDefinition);
        return bean;
    }

    protected Object initBean(BeanDefinition beanDefinition) throws Exception {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置配置信息
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyProperty(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            field.set(bean, propertyValue.getValue());
        }
    }

}
