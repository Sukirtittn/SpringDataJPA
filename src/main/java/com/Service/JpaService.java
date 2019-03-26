package com.Service;

import com.Entities.Person;
import com.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JpaService {

    @Autowired
    PersonRepository personRepository;

    public void savePerson() {
        Person person = new Person();
        person.setId(1);
        person.setFirstname("Sukirti");
        person.setLastname("Kaushik");
        person.setAge(25);
        person.setSalary(15000);

        Person person2 = new Person();
        person2.setId(5);
        person2.setFirstname("Peter");
        person2.setLastname("Sharma");
        person2.setAge(26);
        person2.setSalary(15000);

        Person person5 = new Person();
        person5.setId(6);
        person5.setFirstname("Peter");
        person5.setLastname("Parker");
        person5.setAge(27);
        person5.setSalary(25000);

        Person person6 = new Person();
        person6.setId(7);
        person6.setFirstname("Peter");
        person6.setLastname("Petricrew");
        person6.setAge(25);
        person6.setSalary(25000);

        Person person1 = new Person();
        person1.setId(2);
        person1.setFirstname("kushik");
        person1.setLastname("Kaushik");
        person1.setAge(20);
        person1.setSalary(12000);

        Person person3 = new Person();
        person3.setId(3);
        person3.setFirstname("Vidhi");
        person3.setLastname("Kaushik");
        person3.setAge(15);
        person3.setSalary(5000);

        Person person4 = new Person();
        person4.setId(4);
        person4.setFirstname("Abhi");
        person4.setLastname("Sharma");
        person4.setAge(18);
        person4.setSalary(10000);

        List<Person> personList = new ArrayList<Person>();
        personList.add(person);
        personList.add(person1);
        personList.add(person3);
        personList.add(person4);
        personList.add(person2);
        personList.add(person5);
        personList.add(person6);
//      we can use save of crud repo which requires iterable entity object!
        personRepository.save(personList);

//        or we can use save method !
//        personRepository.save(person);
//        personRepository.save(person1);
//        personRepository.save(person3);
//        personRepository.save(person4);
//        personRepository.save(person2);
//        personRepository.save(person5);
//        personRepository.save(person6);

    }

    //    Question no-4
    public void findByFirstName(String name) {
        List<Person> personList=personRepository.findByFirstname(name);
        System.out.println(personList);
    }

    public void findByLastName(String name) {
        List<Person> personList=personRepository.findByLastname(name);
        System.out.println(personList);
    }

    public void findById(Integer id) {
        List<Person> personList= personRepository.findById(id);
        System.out.println(personList);
    }

    // question-9
    public void countByFname(String name) {

        int n = personRepository.countByFirstname(name);
        System.out.println("Count of person with first name as " + name + " is " + n);
    }

    //    Question-3
    public void findOne(int id) {
        System.out.println("-------------CRUD REPO findOne() method-----");
        Person person = personRepository.findOne(id);
        System.out.println(person);
    }


    public void findAll() {
        System.out.println("-------------CRUD REPO findAll() method-----");

        Iterable<Person> people = personRepository.findAll();
        System.out.println(people);
    }

////    public void deletePerson(Person person) {
////        System.out.println("-------------CRUD REPO delete(Entity) method-----");
////
////        personRepository.delete(person);
////    }
////
////    public void deletePersonWithId(Integer id) {
////        System.out.println("-------------CRUD REPO delete(ID) method-----");
////
////        personRepository.delete(id);
////    }
////
////    public void deleteAll() {
////        System.out.println("-------------CRUD REPO deleteAll() method-----");
////        personRepository.deleteAll();
////    }
//
    public void countOfEntities() {
        System.out.println("-------------CRUD REPO count() method-----");
        long entity_count = personRepository.count();
        System.out.println("Total entity count is " + entity_count);
    }

    public void entityExistenceCheck(Integer id) {
        System.out.println("-------------CRUD REPO exists(id) method-----");
        boolean existence = personRepository.exists(id);
        System.out.println("Entity with id: " + id + "exists? \n" + existence);
    }

//    public Person getPerson(){
//        Person person=personRepository.findById(7);
//        return person;
//    }

    public void getFirstNameOfPersonWithAge25(){
        System.out.println("person firstname with age 25()");

        List person=personRepository.findbyId();
        System.out.println(person);
    }


    public void getFirstNameAndLastNameOfPersonWithAge25(){
        System.out.println("person firstname and lastname with age 25()");

        List person=personRepository.findbyAge();
        System.out.println(person);
    }

    public void getPersonWithAge25(){
        System.out.println("person with age 25()");

        List person=personRepository.findAllByAgeEquals(25);
        System.out.println(person);
    }

    public void getPersonWithageGreaterThan25(){
        System.out.println("person greaterThan25()");

        List person=personRepository.findByAgeGreaterThan25OrderByIdDesc();
        System.out.println(person);
    }

    public void getSortedPerson(){
        System.out.println("sort");
        List<Person> sortedList = personRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
        System.out.println(sortedList);
        System.out.println("sort");
    }

    public void pagination(){
        System.out.println("pagable ");
        Page<Person> personPage= personRepository.findAll(new PageRequest(0,2,new Sort(Sort.Direction.DESC,"id")));
        List<Person> personList=personPage.getContent();
        System.out.println(personList);
        System.out.println("pagable ");
    }


    public void distinctNames(){
        System.out.println("distinct()");

        List<Person> distinctNameList = personRepository.findDistinctByFirstname("Peter");
        System.out.println(distinctNameList);
    }

    public void findByNameOrId(String firstname, Integer id){
        System.out.println("Or()");

        List<Person> personList=personRepository.findByFirstnameOrId(firstname,id);
        System.out.println(personList);
    }

    public void findByNameAndId(String firstname, Integer id){
        System.out.println("And()");

        List<Person> personList=personRepository.findByFirstnameAndId(firstname,id);
        System.out.println(personList);
    }

    public void findByAgeBetween(int min, int max){
        System.out.println("between()");

        List<Person> personList=personRepository.findByAgeBetween(min,max);
        System.out.println(personList);
    }
    public void findByAgeLessThan(Integer age){
        System.out.println("lesserThan()");

        List<Person> personList=personRepository.findByAgeLessThan(age);
        System.out.println(personList);
    }

    public void findByAgeGreaterThan(Integer age){
        System.out.println("greaterThan()");

        List<Person> personList=personRepository.findByAgeGreaterThan(age);
        System.out.println(personList);
    }

    public void findByAgeIn(){
        System.out.println("In()");

        List<Person> personList=personRepository.findByAgeIn(Arrays.asList(25,27));
        System.out.println(personList);
    }

    public void findLastnameLikeGivenString(String lastnamelike){
        System.out.println("like()");
        List<String> lastNameListMatchingGivenSubstring=personRepository.findByLastnameLike(lastnamelike);
        System.out.println(lastNameListMatchingGivenSubstring);
    }
    public void findLastnameNotLike(String lastname){
        System.out.println("not()");
        List<String> lastNameListNotMatching=personRepository.findByLastnameNot(lastname);
        System.out.println(lastNameListNotMatching);
    }

    public void findLastnameIgnoringCase(String lastname){
        System.out.println("ignoreCase()");
        List<String> lastNameListIgnoringCase=personRepository.findByLastnameIgnoreCase(lastname);
        System.out.println(lastNameListIgnoringCase);
    }


}
