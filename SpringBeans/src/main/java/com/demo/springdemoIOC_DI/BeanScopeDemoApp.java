package com.demo.springdemoIOC_DI;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class BeanScopeDemoApp {
    public static void main(String[] args) {


        // load the spring configuration file

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        //retrieve bean from container

        Coach theCoach = context.getBean("myCoach" , Coach.class);
        Coach alphaCoach = context.getBean("myCoach" , Coach.class);

        // check the bean scope

        boolean result = (theCoach == alphaCoach);

        //display results
        System.out.println("\nPointing to the same object : "+result);
        System.out.println("\nMemory location of theCoach : "+theCoach);
        System.out.println("\nMemory location of alphaCoach : "+alphaCoach);

        context.close();

    }
}
