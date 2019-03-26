package com.Repositories;

import com.Entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT p from Person p where firstname=:firstname")
    List<Person> findByFirstname(@Param("firstname") String firstname);

    @Query("SELECT p from Person p where lastname=:lastname")
    List<Person> findByLastname(@Param("lastname") String lastname);

    @Query("SELECT p from Person p where id=:id")
    List<Person> findById(@Param("id") Integer id);

    @Query("select count(p) from Person p where firstname=:firstname")
    int countByFirstname(@Param("firstname") String firstname);

    @Query("select firstname from Person p where age=25")
    List<String> findbyId();

    List<Person> findAll();
    Person findOne(Integer id);
    long count();
    boolean exists(Integer id);


    @Query("select firstname,lastname from Person p where age=25")
    List<Object[]> findbyAge();

    @Query("select p from Person p where age=:age")
    List<Person> findAllByAgeEquals(@Param("age") Integer age);

    @Query("select p from Person p where age>25")
    List<Person> findByAgeGreaterThan25OrderByIdDesc();


    List<Person> findAll(Sort sort);
//
    List<Person> findDistinctByFirstname(String firstname);

    List<Person> findByFirstnameOrId(String firstname, Integer id);

    List<Person> findByFirstnameAndId(String firstname, Integer id);

    List<Person> findByAgeBetween(Integer min,Integer max);
//
    List<Person> findByAgeLessThan(Integer age);
//
    List<Person> findByAgeGreaterThan(Integer age);
//
    List<Person> findByAgeIn(List<Integer> ageList);

    List<String> findByLastnameLike(String lastnameLike);

    List<String> findByLastnameNot(String lastname);

    List<String> findByLastnameIgnoreCase(String lastname);

//
    Page<Person> findAll(Pageable pageable);



}