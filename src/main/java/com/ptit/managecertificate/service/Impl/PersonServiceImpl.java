package com.ptit.managecertificate.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.managecertificate.dao.PersonDAO;
import com.ptit.managecertificate.entity.Person;
import com.ptit.managecertificate.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    public void savePerson(Person person) {
        personDAO.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        personDAO.update(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDAO.delete(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personDAO.findById(id);
    }

    @Override
    public List<Person> listPerson() {
        return personDAO.findAll();
    }

    @Override
    public List<Person> listPersonSameCourse(Long id) {
        return personDAO.findSameCourse(id);
    }

    @Override
    public Person getPersonByFirstName(String firstName) {
        return personDAO.getPersonByFirstName(firstName);
    }

    @Override
    public Person getPersonByLastName(String lastName) {
        return personDAO.getPersonByLastName(lastName);
    }

    @Override
    public boolean checkPersonInDatabase(Person person) {
        return personDAO.checkPersonInDB(person);
    }
}
