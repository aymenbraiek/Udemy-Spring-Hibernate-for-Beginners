package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    //@Before("execution(1.returnType-* 2.package-com.luv2code.aopdemo.dao.3.ClassName*.4.MethodNAme-*(5.All Params - ..))")
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>>> Executing @Before advice on method()");
    }
}
