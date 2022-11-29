package com.ptit.managecertificate.dao;

import com.ptit.managecertificate.entity.Subject;

import java.util.List;

public interface SubjectDAO {
    void save(Subject subject);
    void update(Subject subject);
    void delete(Subject subject);
    Subject findById(Long id);
    List<Subject> findAll();
    Subject getSubjectByName(String subjectName);
    boolean checkSubjectInDatabase(Subject subject);

//     long getTotalSubject();
//     List<Subject> findByPageable(Pageable pageable);
}