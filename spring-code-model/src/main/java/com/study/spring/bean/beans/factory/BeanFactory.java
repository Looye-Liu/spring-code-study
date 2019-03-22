package com.study.spring.bean.beans.factory;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
