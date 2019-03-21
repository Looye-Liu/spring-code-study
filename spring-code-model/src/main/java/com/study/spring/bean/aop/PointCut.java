package com.study.spring.bean.aop;

/**
 * Created by looye on 2019/3/21.
 *
 * @author looye
 * @date 2019/3/21
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
