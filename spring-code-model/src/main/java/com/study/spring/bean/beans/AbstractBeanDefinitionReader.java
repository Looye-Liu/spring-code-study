package com.study.spring.bean.beans;

import com.study.spring.bean.beans.io.ResourceLoad;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by looye on 2019/3/6.
 *
 * @author looye
 * @date 2019/3/6
 */
public abstract class AbstractBeanDefinitionReader implements BeandefinitionReader {
    private Map<String, BeanDefinition> registry;
    private ResourceLoad resourceLoad;

    public AbstractBeanDefinitionReader(ResourceLoad resourceLoad) {
        this.resourceLoad = resourceLoad;
        this.registry = new HashMap<String, BeanDefinition>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoad getResourceLoad() {
        return resourceLoad;
    }
}
