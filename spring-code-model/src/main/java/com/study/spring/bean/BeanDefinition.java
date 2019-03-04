package com.study.spring.bean;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public class BeanDefinition {
    private Object bean;
    private String beanName;
    private Class beanClass;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
        try {
            this.beanClass = Class.forName(beanName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
