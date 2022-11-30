package com.ptit.managecertificate.controller;

import com.ptit.managecertificate.entity.Subject;
import com.ptit.managecertificate.model.SubjectModel;
import com.ptit.managecertificate.service.CourseService;
import com.ptit.managecertificate.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/subject/list", method = RequestMethod.GET)
	public String listSubject(Model model) {
		model.addAttribute("subject", new SubjectModel());
		model.addAttribute("listSubjects", subjectService.listSubject());
		model.addAttribute("listCourses", courseService.listCourse());
		return "authorize/manageSubject";
	}

	@RequestMapping(value = "/subject/add", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute("subject") SubjectModel subjectModel, Model model) {
		
		while (subjectModel.getCourse_id()==null) {
			
			model.addAttribute("message", "Please Choose Course");
			model.addAttribute("subject", subjectModel);
			model.addAttribute("listSubjects", subjectService.listSubject());
			model.addAttribute("listCourses", courseService.listCourse());
			return "authorize/manageSubject";
		}
		
		Subject subject = new Subject();
		subject.setId(subjectModel.getId());
		subject.setName(subjectModel.getName());
		subject.setDescription(subjectModel.getDescription());
		subject.setCourse(courseService.getCourseById(subjectModel.getCourse_id()));

		if (!subjectService.checkSubjectInDataBase(subject)) {
			subjectService.saveSubject(subject);
		} else {
			Subject s = subjectService.getSubjectById(subjectModel.getId());
			s.setName(subjectModel.getName());
			s.setDescription(subjectModel.getDescription());
			s.setCourse(courseService.getCourseById(subjectModel.getCourse_id()));
			subjectService.updateSubject(s);
		}

		model.addAttribute("subject", new SubjectModel());
		return "redirect:/subject/list";
	}

	@RequestMapping("/subject/edit/{id}")
	public String editSubject(@PathVariable("id") Long id, Model model) {
		Subject s = subjectService.getSubjectById(id);

		SubjectModel sm = new SubjectModel();
		try {
			sm.setId(s.getId());
			sm.setName(s.getName());
			sm.setDescription(s.getDescription());
			sm.setCourse_id(s.getCourse().getId());
		} catch (Exception e) {
		}

		model.addAttribute("subject", sm);
		model.addAttribute("listSubjects", subjectService.listSubject());
		model.addAttribute("listCourses", courseService.listCourse());
		return "authorize/manageSubject";
	}

	@RequestMapping("/subject/remove/{id}")
	public String removeSubject(@PathVariable("id") Long id, Model model) {
		this.subjectService.deleteSubject(subjectService.getSubjectById(id));
		return "redirect:/subject/list";
	}
}
