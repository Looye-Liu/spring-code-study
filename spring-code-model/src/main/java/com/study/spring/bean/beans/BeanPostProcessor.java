package com.study.spring.bean.beans;

/**
 * Created by looye on 2019/3/21.
 *
 * @author looye
 * @date 2019/3/21
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}
