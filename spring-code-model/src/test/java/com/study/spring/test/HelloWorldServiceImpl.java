package com.study.spring.test;

/**
 * Created by looye on 2019/3/4.
 *
 * @author looye
 * @date 2019/3/4
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    private OutputService outputService;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void helloWorld() {
        System.out.println("hello world");
    }

    @Override
    public void sayWhat() {
        System.out.println(this.text);
    }

    public OutputService getOutputService() {
        return outputService;
    }

    public HelloWorldServiceImpl setOutputService(OutputService outputService) {
        this.outputService = outputService;
        return this;
    }
}
