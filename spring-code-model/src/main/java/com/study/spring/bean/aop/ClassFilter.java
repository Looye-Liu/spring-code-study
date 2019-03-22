package com.study.spring.bean.aop;

/**
 * Created by looye on 2019/3/21.
 *
 * @author looye
 * @date 2019/3/21
 */
public interface ClassFilter {

    boolean matches(Class targetClass) throws Exception;
}
