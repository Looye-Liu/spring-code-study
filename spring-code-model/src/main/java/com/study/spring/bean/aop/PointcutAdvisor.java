package com.study.spring.bean.aop;

/**
 * Created by looye on 2019/3/22.
 *
 * @author looye
 * @date 2019/3/22
 */
public interface PointcutAdvisor extends Advisor {

    PointCut getPointcut();
}
