package com.ptit.managecertificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.managecertificate.entity.Person;
import com.ptit.managecertificate.model.PersonModel;
import com.ptit.managecertificate.service.CourseService;
import com.ptit.managecertificate.service.PersonService;


@Controller
public class PersonController {

    @Autowired
    PersonService personService;
    
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/person/list", method = RequestMethod.GET)
    public String listPerson(Model model) {
        model.addAttribute("person", new PersonModel());
        model.addAttribute("listPersons", personService.listPerson());
        model.addAttribute("listCourses", courseService.listCourse());
        return "authorize/managePerson";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") PersonModel personModel, Model model) {
        Person p = new Person();
        p.setId(personModel.getId());
        p.setFirstName(personModel.getFirstName());
        p.setLastName(personModel.getLastName());
        p.setGender(personModel.getGender());
        p.setDateOfBirth(personModel.getDateOfBirth());
        p.setMobileNumber(personModel.getMobileNumber());
        p.setEmail(personModel.getEmail());
        p.setCourse(courseService.getCourseById(personModel.getCourse_id()));
        

        if (!personService.checkPersonInDatabase(p)) {
            personService.savePerson(p);
        } else {
            Person pp = personService.getPersonById(p.getId());
            personService.updatePerson(pp);
        }

        model.addAttribute("person", new PersonModel());
        return "redirect:/person/list";
    }

    @RequestMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") Long id, Model model) {
        Person pp = personService.getPersonById(id);

        PersonModel p = new PersonModel();
        p.setId(pp.getId());
        p.setFirstName(pp.getFirstName());
        p.setLastName(pp.getLastName());
        p.setGender(pp.getGender());
        p.setDateOfBirth(pp.getDateOfBirth());
        p.setMobileNumber(pp.getMobileNumber());
        p.setEmail(pp.getEmail());
        p.setCourse_id(pp.getCourse().getId());

        model.addAttribute("person", p);
        model.addAttribute("listPersons", personService.listPerson());
        model.addAttribute("listCourses", courseService.listCourse());
        return "authorize/managePerson";
    }

    @RequestMapping("/person/remove/{id}")
    public String removePerson(@PathVariable("id")Long id, Model model){
        this.personService.deletePerson(personService.getPersonById(id));
        return "redirect:/person/list";
    }
}
