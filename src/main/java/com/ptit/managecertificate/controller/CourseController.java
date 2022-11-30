package com.ptit.managecertificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.managecertificate.entity.Course;
import com.ptit.managecertificate.model.CourseModel;
import com.ptit.managecertificate.service.CertificateService;
import com.ptit.managecertificate.service.CourseService;
import com.ptit.managecertificate.service.PersonService;
import com.ptit.managecertificate.service.SubjectService;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;

	@Autowired
	PersonService personService;

	@Autowired
	SubjectService subjectService;

	@Autowired
	CertificateService certificateService;

	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
	public String listCourse(Model model) {
		model.addAttribute("course", new CourseModel());
		model.addAttribute("listCourses", courseService.listCourse());
		model.addAttribute("listCer", certificateService.listCertificate());
		return "authorize/manageCourse";
	}

	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("course") CourseModel courseModel, Model model) {
		// Catch Exeption if point not a number or not between 0-10
		try {
			Long.parseLong(courseModel.getPointAverage());
			while(Long.parseLong(courseModel.getPointAverage()) <0 || Long.parseLong(courseModel.getPointAverage())>10) {
				model.addAttribute("message", "Please Input Point Between 0-10");
				model.addAttribute("course", courseModel);
				model.addAttribute("listCourses", courseService.listCourse());
				model.addAttribute("listCer", certificateService.listCertificate());
				return "authorize/manageCourse";
			}
		} catch (Exception e) {
			model.addAttribute("message", "Please Input Number");
			model.addAttribute("course", courseModel);
			model.addAttribute("listCourses", courseService.listCourse());
			model.addAttribute("listCer", certificateService.listCertificate());
			return "authorize/manageCourse";
		}
		
		while(courseModel.getCertificate_id()==null) {
			model.addAttribute("message", "Please Choose Certificate");
			model.addAttribute("course", courseModel);
			model.addAttribute("listCourses", courseService.listCourse());
			model.addAttribute("listCer", certificateService.listCertificate());
			return "authorize/manageCourse";
		}
		
		Course course = new Course();
		course.setId(courseModel.getId());
		course.setName(courseModel.getName());
		course.setPointAverage(courseModel.getPointAverage());
		course.setDateStart(courseModel.getDateStart());
		course.setDateEnd(courseModel.getDateEnd());
		course.setCertificate(certificateService.getCertificateById(courseModel.getCertificate_id()));

		if (!courseService.checkCourseInDB(course)) {
			courseService.saveCourse(course);
		} else {
			Course c = courseService.getCourseById(courseModel.getId());
			c.setName(courseModel.getName());
			c.setPointAverage(courseModel.getPointAverage());
			c.setDateStart(courseModel.getDateStart());
			c.setDateEnd(courseModel.getDateEnd());
			c.setCertificate(certificateService.getCertificateById(courseModel.getCertificate_id()));

			courseService.updateCourse(c);
		}

		model.addAttribute("course", new CourseModel());
		return "redirect:/course/list";
	}

	@RequestMapping("/course/edit/{id}")
	public String editCourse(@PathVariable("id") Long id, Model model) {
		Course c = courseService.getCourseById(id);
		CourseModel cm = new CourseModel();
		try {
			cm.setId(c.getId());
			cm.setName(c.getName());
			cm.setPointAverage(c.getPointAverage());
			cm.setDateStart(c.getDateStart());
			cm.setDateEnd(c.getDateEnd());
			cm.setCertificate_id(c.getCertificate().getId());
		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("course", cm);
		model.addAttribute("listCourses", courseService.listCourse());
		model.addAttribute("listCer", certificateService.listCertificate());
		return "authorize/manageCourse";
	}

	@RequestMapping("/course/remove/{id}")
	public String removeCourse(@PathVariable("id") Long id, Model model) {
		this.courseService.deleteCourse(courseService.getCourseById(id));
		return "redirect:/course/list";
	}

	@RequestMapping(value = "/course/listStudent/{id}", method = RequestMethod.GET)
	public String viewStudentToCourse(@PathVariable("id") Long id, Model model) {

		model.addAttribute("listStudent", personService.listPersonSameCourse(id));
		return "authorize/studentListCourse";
	}

	@RequestMapping(value = "/course/listSubject/{id}", method = RequestMethod.GET)
	public String viewListSubjectInCourse(@PathVariable("id") Long id, Model model) {

		model.addAttribute("listSubject", subjectService.listSubjectInSameCourse(id));
		return "authorize/subjectListCourse";
	}

}
