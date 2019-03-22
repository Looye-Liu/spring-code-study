package com.study.spring.bean.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by looye on 2019/3/18.
 *
 * @author looye
 * @date 2019/3/18
 */
public class AdvisedSupport {
    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;
    private MethodMatcher methodMatcher;

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public AdvisedSupport setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
        return this;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public AdvisedSupport setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
        return this;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public AdvisedSupport setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
        return this;
    }
}
