package com.study.spring.bean;

/**
 * Created by looye on 2019/3/13.
 *
 * @author looye
 * @date 2019/3/13
 */
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BeanReference setName(String name) {
        this.name = name;
        return this;
    }

    public Object getBean() {
        return bean;
    }

    public BeanReference setBean(Object bean) {
        this.bean = bean;
        return this;
    }
}
