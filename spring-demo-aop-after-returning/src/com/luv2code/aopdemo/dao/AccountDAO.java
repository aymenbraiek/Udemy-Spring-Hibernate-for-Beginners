package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceName;

    // add a new method: findAccounts()

    public List <Account> findAccounts() {

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Mahdu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our account list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);


        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName ()");
        this.name = name;
    }

    public String getServiceName() {
        System.out.println(getClass() + ": getServiceName()");
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        System.out.println(getClass() + ": setServiceName()");
        this.serviceName = serviceName;
    }
}
