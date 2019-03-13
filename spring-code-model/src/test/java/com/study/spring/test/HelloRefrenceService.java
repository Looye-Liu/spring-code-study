package com.study.spring.test;

/**
 * Created by looye on 2019/3/13.
 *
 * @author looye
 * @date 2019/3/13
 */
public class HelloRefrenceService {
    private String refrence;
    private HelloWorldService helloWorldService;

    public void printHello() {
        System.out.println("ref:wahaha");
        helloWorldService.helloWorld();
    }

    public String getRefrence() {
        return refrence;
    }

    public HelloRefrenceService setRefrence(String refrence) {
        this.refrence = refrence;
        return this;
    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    public HelloRefrenceService setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
        return this;
    }
}
