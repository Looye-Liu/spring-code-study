package com.study.spring.bean.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by looye on 2019/3/6.
 *
 * @author looye
 * @date 2019/3/6
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection connection = url.openConnection();
        connection.connect();
        return connection.getInputStream();
    }
}
