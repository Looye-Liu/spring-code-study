package com.study.spring.bean.aop;

/**
 * Created by looye on 2019/3/18.
 *
 * @author looye
 * @date 2019/3/18
 */
public class TargetSource {
    public Object target;
    public Class targetClass;

    public TargetSource(Object target, Class targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

}
