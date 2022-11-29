package com.ptit.managecertificate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.managecertificate.entity.Course;
import com.ptit.managecertificate.entity.Person;
import com.ptit.managecertificate.model.CourseModel;
import com.ptit.managecertificate.service.CourseService;
import com.ptit.managecertificate.service.PersonService;

@Controller
public class CourseController {
    private static final Logger logger = Logger.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;
    
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/course/list", method = RequestMethod.GET)
    public String listCourse(Model model){
        model.addAttribute("course", new CourseModel());
        model.addAttribute("listCourses", courseService.listCourse());
        return "authorize/manageCourse";
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("course") CourseModel courseModel, Model model){
        Course course = new Course();
        course.setId(courseModel.getId());
        course.setName(courseModel.getName());
        course.setPointAverage(courseModel.getPointAverage());
        course.setDateStart(courseModel.getDateStart());
        course.setDateEnd(courseModel.getDateEnd());

        if(!courseService.checkCourseInDB(course)){
            courseService.saveCourse(course);
        } else {
            Course c = courseService.getCourseByName(courseModel.getName());
            c.setPointAverage(courseModel.getPointAverage());
            c.setDateStart(courseModel.getDateStart());
            c.setDateEnd(courseModel.getDateEnd());
            
            courseService.updateCourse(c);
        }

        model.addAttribute("course", new CourseModel());
        return "redirect:/course/list";
    }

    @RequestMapping("/course/edit/{id}")
    public String editCourse(@PathVariable("id") Long id, Model model){
        Course c = courseService.getCourseById(id);

        CourseModel cm = new CourseModel();
        cm.setName(c.getName());
        cm.setPointAverage(c.getPointAverage());
        cm.setDateStart(c.getDateStart());
        cm.setDateEnd(c.getDateEnd());

        model.addAttribute("course", cm);
        model.addAttribute("listCourses", courseService.listCourse());
        return "authorize/manageCourse";
    }

    @RequestMapping("/course/remove/{id}")
    public String removeCourse(@PathVariable("id") Long id, Model model){
        this.courseService.deleteCourse(courseService.getCourseById(id));
        return "redirect:/course/list";
    }
    
    @RequestMapping(value = "/course/listStudent/{id}", method = RequestMethod.GET)
    public String viewStudentToCourse(@PathVariable("id")Long id, Model model) {

    	model.addAttribute("listStudent", personService.listPersonSameCourse(id));
		return "authorize/studentListCourse";
    }
    
}
