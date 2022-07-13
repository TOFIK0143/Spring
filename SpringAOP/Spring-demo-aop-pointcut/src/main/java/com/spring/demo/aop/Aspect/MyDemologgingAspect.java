package com.spring.demo.aop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemologgingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
    @Pointcut("execution(* com.spring.demo.aop.DAO.*.*(..))")
    private void forDAOPackage() {}

// let's start with an @Before advice
    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice()
    {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDAOPackage()")
    public void performApiAnalytics() {
        System.out.println("\n======>>> Performing API analytics");
    }
}
