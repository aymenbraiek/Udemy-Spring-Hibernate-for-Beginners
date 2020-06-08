package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceName;

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
