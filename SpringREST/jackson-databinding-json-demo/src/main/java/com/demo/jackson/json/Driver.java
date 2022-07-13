package com.demo.jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Driver {

    public static void main(String[]args) {

        try {
            // create object mapper
            Object mapper = new ObjectMapper();

            // read JASON file and map/convert to Java POJO:
            // data/sample-lite.json

            Student theStudent = ((ObjectMapper) mapper).readValue(
                    new File("data/sample-full.json"), Student.class);


            // print first name and last name
            System.out.println("First name =" + theStudent.getFirstName());
            System.out.println("Last name =" + theStudent.getLastName());

            // print out address: street and city
            //    Address tempAddress = theStudent.getAddress();

            System.out.println("Street = " + theStudent.getAddress().toString());

            //System.out.println("City = " + tempAddress.getCity());

            // print out languages
            for (String tempLang : theStudent.getLanguages()) {
                System.out.println(tempLang);
            }
        } catch (Exception exc) {
            exc.printStackTrace();

        }
    }
}
