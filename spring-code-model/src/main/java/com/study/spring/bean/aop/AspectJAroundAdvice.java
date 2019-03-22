package com.study.spring.bean.aop;

import com.study.spring.bean.beans.factory.BeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by looye on 2019/3/22.
 *
 * @author looye
 * @date 2019/3/22
 */
public class AspectJAroundAdvice implements Advice, MethodInterceptor {
    private BeanFactory beanFactory;

    private Method aspectJAdviceMethod;

    private String aspectInstanceName;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return aspectJAdviceMethod.invoke(beanFactory.getBean(aspectInstanceName), methodInvocation);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public AspectJAroundAdvice setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        return this;
    }

    public Method getAspectJAdviceMethod() {
        return aspectJAdviceMethod;
    }

    public AspectJAroundAdvice setAspectJAdviceMethod(Method aspectJAdviceMethod) {
        this.aspectJAdviceMethod = aspectJAdviceMethod;
        return this;
    }

    public String getAspectInstanceName() {
        return aspectInstanceName;
    }

    public AspectJAroundAdvice setAspectInstanceName(String aspectInstanceName) {
        this.aspectInstanceName = aspectInstanceName;
        return this;
    }
}
