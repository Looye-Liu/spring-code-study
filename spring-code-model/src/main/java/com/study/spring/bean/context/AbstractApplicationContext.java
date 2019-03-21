package com.study.spring.bean.context;

import com.study.spring.bean.beans.factory.AbstractBeanFactory;

/**
 * Created by looye on 2019/3/14.
 *
 * @author looye
 * @date 2019/3/14
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory factory) {
        this.beanFactory = factory;
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    public void refresh() throws Exception {
    }
}
