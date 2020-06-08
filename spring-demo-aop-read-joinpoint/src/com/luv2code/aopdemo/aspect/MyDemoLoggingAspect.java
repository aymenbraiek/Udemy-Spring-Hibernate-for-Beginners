package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MemberSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>>> Executing @Before advice on method()");


        // display the method signature
        MemberSignature memberSig = (MemberSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + memberSig);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArgs : args) {
            System.out.println(tempArgs);
            if (tempArgs instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) tempArgs;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());

            }
        }
    }
}
