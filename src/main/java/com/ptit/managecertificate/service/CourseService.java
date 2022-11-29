package com.ptit.managecertificate.service;

import com.ptit.managecertificate.entity.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
    Course getCourseById(Long id);
    Course getCourseByName(String name);
    List<Course> listCourse();
    boolean checkCourseInDB(Course course);
}
