package com.ptit.managecertificate.service;

import com.ptit.managecertificate.entity.Subject;

import java.util.List;

public interface SubjectService {
    void saveSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
    List<Subject> listSubject();
    Subject getSubjectById(Long id);
    Subject getSubjectByName(String name);
    boolean checkSubjectInDataBase(Subject subject);
}
