package com.ptit.managecertificate.dao;

import java.util.List;

import com.ptit.managecertificate.entity.Course;

public interface CourseDAO {
    void save(Course course);
    void update(Course course);
    void delete(Course course);
    Course findById(Long id);
    List<Course> findAll();
    List<Course> findSameCertificate(Long id);
    Course getCourseByName(String name);
    boolean checkCourseInDB(Course course);
}
