package com.study.spring.bean.beans.io;

import java.net.URL;

/**
 * Created by looye on 2019/3/6.
 *
 * @author looye
 * @date 2019/3/6
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
