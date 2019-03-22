package com.study.spring.bean.aop;

/**
 * Created by looye on 2019/3/22.
 *
 * @author looye
 * @date 2019/3/22
 */
public abstract class AbstractAopProxy implements AopProxy{
    protected AdvisedSupport advisedSupport;

    public AbstractAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
}
