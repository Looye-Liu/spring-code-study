package com.study.spring.test;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public class HelloWorldService {

    private HelloRefrenceService refrenceService;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void helloWorld() {
        System.out.println("hello world");
    }

    public void sayWhat() {
        System.out.println(this.text);
    }

    public HelloRefrenceService getRefrenceService() {
        return refrenceService;
    }

    public HelloWorldService setRefrenceService(HelloRefrenceService refrenceService) {
        this.refrenceService = refrenceService;
        return this;
    }
}
