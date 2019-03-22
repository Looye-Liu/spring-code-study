package com.study.spring.bean.aop;

/**
 * Created by looye on 2019/3/22.
 *
 * @author looye
 * @date 2019/3/22
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    protected final AopProxy createApoProxy() {
        return new Cglib2AopProxy(this);
    }

    @Override
    public Object getProxy() {
        return createApoProxy().getProxy();
    }
}
