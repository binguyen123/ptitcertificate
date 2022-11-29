package com.ptit.managecertificate.dao;

import java.util.List;

import com.ptit.managecertificate.entity.Person;

public interface PersonDAO{
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    Person findById(Long id);
    List<Person> findAll();
    List<Person> findSameCourse(Long id);
    Person getPersonByFirstName(String firstName);
    Person getPersonByLastName(String lastName);
    boolean checkPersonInDB(Person person);
}
