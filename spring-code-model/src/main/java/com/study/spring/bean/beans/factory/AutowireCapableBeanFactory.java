package com.study.spring.bean.beans.factory;

import com.study.spring.bean.aop.BeanFactoryAware;
import com.study.spring.bean.beans.BeanDefinition;
import com.study.spring.bean.beans.BeanReference;
import com.study.spring.bean.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFatory(this);
        }
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getName());
            }
            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass()
                );
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                field.set(bean, value);
            }
        }
    }

}
