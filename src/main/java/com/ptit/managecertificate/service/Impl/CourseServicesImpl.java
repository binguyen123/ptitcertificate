package com.ptit.managecertificate.service.Impl;

import com.ptit.managecertificate.dao.CourseDAO;
import com.ptit.managecertificate.dao.PersonDAO;
import com.ptit.managecertificate.entity.Course;
import com.ptit.managecertificate.entity.Person;
import com.ptit.managecertificate.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class CourseServicesImpl implements CourseService {
    @Autowired
    CourseDAO courseDAO;
    @Override
    public void saveCourse(Course course) {
        courseDAO.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    @Override
    public void deleteCourse(Course course) {
        courseDAO.delete(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDAO.findById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDAO.getCourseByName(name);
    }

    @Override
    public List<Course> listCourse() {
        return courseDAO.findAll();
    }

    @Override
    public boolean checkCourseInDB(Course course) {
        return courseDAO.checkCourseInDB(course);
    }

	@Override
	public List<Course> listCourseSameCertificate(Long id) {
		return courseDAO.findSameCertificate(id);
	}
}
