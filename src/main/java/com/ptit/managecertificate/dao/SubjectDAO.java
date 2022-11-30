package com.ptit.managecertificate.dao;

import java.util.List;

import com.ptit.managecertificate.entity.Subject;

public interface SubjectDAO {
    void save(Subject subject);
    void update(Subject subject);
    void delete(Subject subject);
    Subject findById(Long id);
    List<Subject> findAll();
    List<Subject> findSameCourse(Long id);
    Subject getSubjectByName(String subjectName);
    boolean checkSubjectInDatabase(Subject subject);

//     long getTotalSubject();
//     List<Subject> findByPageable(Pageable pageable);
}