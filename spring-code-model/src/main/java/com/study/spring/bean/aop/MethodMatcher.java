package com.study.spring.bean.aop;

import java.lang.reflect.Method;

/**
 * Created by looye on 2019/3/21.
 *
 * @author looye
 * @date 2019/3/21
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass) throws Exception;
}
