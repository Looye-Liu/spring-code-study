package com.study.spring.bean.io;

import java.io.InputStream;

/**
 * Created by looye on 2019/3/6.
 *
 * @author looye
 * @date 2019/3/6
 */
public interface Resource {

    InputStream getInputStream() throws Exception;
}
