package com.arcane;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day03_C7_JavaFaker {
    //cogunlukla teslerimiz icin fake date kullanır
    //JavaFaker de fake data kullanmak için oluşturulmuştur
    // Java fake dependency pox.xml e eklemiştik
    @Test

    public void fakerTest(){
        //faker data type de obje oluştur
        Faker faker = new Faker();
        //2.ardından fake date kullananbiliriz : firstname , lastname , adres,cty, state , countery
      String fName =  faker.name().firstName();
        System.out.println(fName);

        String lName =  faker.name().lastName();
        System.out.println(lName);

        String fullName =  faker.name().fullName();
        System.out.println(fullName);

        //title
        System.out.println(faker.name().title());
        //city
        System.out.println(faker.address().city());
        //state
        System.out.println(faker.address().state());
        System.out.println(faker.harryPotter().character());

        //phone number

        System.out.println(faker.phoneNumber().cellPhone());

        //zipcode
        System.out.println(faker.address().zipCode());

        //rasgele email adresi

        System.out.println(faker.internet().emailAddress());

        //raskele rakam
        System.out.println(faker.number().digits(6));
        System.out.println(faker.avatar().image());
    }
}
