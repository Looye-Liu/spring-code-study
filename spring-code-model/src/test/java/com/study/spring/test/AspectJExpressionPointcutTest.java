package com.study.spring.test;

import com.study.spring.bean.aop.AspectJExpressionPointcut;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by looye on 2019/3/21.
 *
 * @author looye
 * @date 2019/3/21
 */
public class AspectJExpressionPointcutTest {
    @Test
    public void test() throws Exception {
        //String expression = "execution(* us.codecraft.tinyioc.*.*(..))";
        String expression = "execution(* com.study.spring..*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matche = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matche);
    }

    @Test
    public void test2() throws Exception {
        String expression = "execution(* com.study.spring..*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
