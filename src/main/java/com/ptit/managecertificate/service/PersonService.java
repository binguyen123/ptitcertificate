package com.ptit.managecertificate.service;

import java.util.List;

import com.ptit.managecertificate.entity.Person;

public interface PersonService {
    void savePerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(Long id);
    List<Person> listPerson();
    List<Person> listPersonSameCourse(Long id);
    Person getPersonByFirstName(String firstName);
    Person getPersonByLastName(String lastName);
    boolean checkPersonInDatabase(Person person);
}
