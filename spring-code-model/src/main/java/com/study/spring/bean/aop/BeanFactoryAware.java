package com.study.spring.bean.aop;

import com.study.spring.bean.beans.factory.BeanFactory;

/**
 * Created by looye on 2019/3/22.
 *
 * @author looye
 * @date 2019/3/22
 */
public interface BeanFactoryAware {

    void setBeanFatory(BeanFactory beanFatory) throws Exception;
}
