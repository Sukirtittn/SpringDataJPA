package com;

import com.Config.PersistenceContext;
import com.Service.JpaService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceContext.class);
        JpaService service = ctx.getBean(JpaService.class);
//        question 3
        service.savePerson();
        service.findOne(3);
        service.countOfEntities();
        service.findAll();
//        service.deleteAll();
//        service.deletePerson(service.getPerson());
        service.entityExistenceCheck(5);
//        service.deletePersonWithId(7);
        System.out.println("--------------------------------------------------------------------------------");
//        question-5
        service.findByFirstName("Peter");
        service.findById(5);
        service.findByLastName("Kaushik");
        System.out.println("--------------------------------------------------------------------------------");
//        question 6
        service.getFirstNameOfPersonWithAge25();
        System.out.println("--------------------------------------------------------------------------------");
//        question 7
        service.getFirstNameAndLastNameOfPersonWithAge25();
        System.out.println("--------------------------------------------------------------------------------");
//        question 8
        service.getPersonWithAge25();
        System.out.println("--------------------------------------------------------------------------------");
//        question 9
        service.countByFname("Peter");
        System.out.println("--------------------------------------------------------------------------------");
//        question 11
        service.getPersonWithageGreaterThan25();
        System.out.println("--------------------------------------------------------------------------------");
//        question 12
        service.getSortedPerson();
        System.out.println("--------------------------------------------------------------------------------");
//        question 13
        service.pagination();
        System.out.println("--------------------------------------------------------------------------------");
////        question 10
////          10.1 count
        service.countOfEntities();
////        10.2 distinct
        service.distinctNames();
//        10.3 or
        service.findByNameOrId("Sukirti",6);
//        10.4 and
        service.findByNameAndId("Sukirti",1);
//        10.5 between
        service.findByAgeBetween(17,27);
////        10.6 lessThan
        service.findByAgeLessThan(22);
////        10.7 greaterThan
        service.findByAgeGreaterThan(22);
////        10.8 like
        service.findLastnameLikeGivenString("Kaushik");
//        10.9 not
        service.findLastnameNotLike("Kaushik");
//        10.10 in
        service.findByAgeIn();
//        10.11 ignorecase
        service.findLastnameIgnoringCase("kaushik");

        System.out.println("--------------------------------------------------------------------------------");


    }

}
