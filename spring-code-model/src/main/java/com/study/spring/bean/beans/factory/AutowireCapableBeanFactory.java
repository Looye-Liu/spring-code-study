package com.study.spring.bean.beans.factory;

import com.study.spring.bean.beans.BeanDefinition;
import com.study.spring.bean.beans.BeanReference;
import com.study.spring.bean.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 设置配置信息
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    @Override
    protected void applyProperty(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getName());
            }
            field.set(bean, value);
        }
    }

}
