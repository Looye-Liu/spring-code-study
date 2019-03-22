package com.study.spring.bean.aop;

import org.aopalliance.aop.Advice;

/**
 * Created by looye on 2019/3/22.
 *
 * @author looye
 * @date 2019/3/22
 */
public interface Advisor {

    Advice getAdvice();
}
