package com.ptit.managecertificate.dao;

import com.ptit.managecertificate.entity.Course;

import java.util.List;

public interface CourseDAO {
    void save(Course course);
    void update(Course course);
    void delete(Course course);
    Course findById(Long id);
    List<Course> findAll();
    Course getCourseByName(String name);
    boolean checkCourseInDB(Course course);
}
