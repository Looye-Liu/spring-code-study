package com.study.spring.bean.aop;

/**
 * Created by looye on 2019/3/18.
 *
 * @author looye
 * @date 2019/3/18
 */
public class TargetSource {
    private Object target;
    private Class<?> targetClass;
    private Class<?>[] interfaces;

    public TargetSource(Object target, Class targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Object getTarget() {
        return target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
