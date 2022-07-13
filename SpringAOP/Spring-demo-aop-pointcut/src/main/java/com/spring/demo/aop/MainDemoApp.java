package com.spring.demo.aop;


import com.spring.demo.aop.DAO.AccountDAO;
import com.spring.demo.aop.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainDemoApp {

    public static void main(String[] args) {
        //read the spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from container

        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        // call the business method
        Account myAccount = new Account();
        theAccountDAO.addAccount();

      //  theAccountDAO.doWork();

        // do it again!
      //  System.out.println("\nLet's call it again!\n");

        // call the membership business method
        theMembershipDAO.addAccount();

        theMembershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
