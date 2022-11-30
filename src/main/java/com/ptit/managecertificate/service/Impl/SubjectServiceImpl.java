package com.ptit.managecertificate.service.Impl;

import com.ptit.managecertificate.dao.SubjectDAO;
import com.ptit.managecertificate.entity.Subject;
import com.ptit.managecertificate.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectDAO subjectDAO;

    @Override
    public void saveSubject(Subject subject) {
        subjectDAO.save(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDAO.update(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectDAO.delete(subject);
    }

    @Override
    public List<Subject> listSubject() {
        return subjectDAO.findAll();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectDAO.findById(id);
    }

    @Override
    public Subject getSubjectByName(String name) {
        return subjectDAO.getSubjectByName(name);
    }

    @Override
    public boolean checkSubjectInDataBase(Subject subject) {
        return subjectDAO.checkSubjectInDatabase(subject);
    }

	@Override
	public List<Subject> listSubjectInSameCourse(Long id) {
		return subjectDAO.findSameCourse(id);
	}
}
