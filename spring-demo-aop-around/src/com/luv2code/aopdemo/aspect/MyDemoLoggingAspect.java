package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MemberSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n======>>>> Executing @Around on method " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, lets' execute method
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            myLogger.warning(e.getMessage());

            // give user a custom message
            // result = "Major accident! But no worries, your private AOP helicopter is on the way!";

            // rethrow exception
            throw e;


        }

        // get enf timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;

        myLogger.info("\n====>Duration: " + duration / 1000.0 + " seconds");

        return result;
    }


    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccountAdvice(JoinPoint theJoinPoint) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n======>>>> Executing @After (finally) on method " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n======>>>> Executing @AfterThrowing on method " + method);

        // log the exception
        myLogger.info("\n======>>>> The exception is: " + theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n======>>>> Executing @AfterReturning on method " + method);

        // print out the result of the method call
        myLogger.info("\n======>>>> result is: " + result);

        // let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n======>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount : result) {
            // get uppercase version of name

            String theUpperName = tempAccount.getName().toUpperCase();
            // update the name on the account
            tempAccount.setName(theUpperName);

        }


    }

    @Before("LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n=====>>>> Executing @Before advice on method()");


        // display the method signature
        MemberSignature memberSig = (MemberSignature) theJoinPoint.getSignature();

        myLogger.info("Method: " + memberSig);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArgs : args) {
            myLogger.info(tempArgs.toString());
            if (tempArgs instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) tempArgs;
                myLogger.info("account name: " + account.getName());
                myLogger.info("account level: " + account.getLevel());

            }
        }
    }
}
