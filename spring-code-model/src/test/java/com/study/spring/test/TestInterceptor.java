package com.study.spring.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by looye on 2019/3/18.
 *
 * @author looye
 * @date 2019/3/18
 */
public class TestInterceptor implements MethodInterceptor {
    public static Integer count = 0;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("----before----" + count++);
        Object result = methodInvocation.proceed();
        System.out.println("----after----" + count++);
        return result;
    }
}
