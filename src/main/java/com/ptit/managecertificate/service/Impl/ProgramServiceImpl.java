package com.ptit.managecertificate.service.Impl;

import com.ptit.managecertificate.dao.ProgramDAO;
import com.ptit.managecertificate.entity.Program;
import com.ptit.managecertificate.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("programService")
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    ProgramDAO programDAO;
    @Override
    public void saveProgram(Program program) {
        programDAO.save(program);
    }

    @Override
    public void updateProgram(Program program) {
        programDAO.update(program);
    }

    @Override
    public void deleteProgram(Program program) {
        programDAO.delete(program);
    }

    @Override
    public Program getProgramById(Long id) {
        return programDAO.findById(id);
    }

    @Override
    public Program getProgramByName(String name) {
        return programDAO.getProgramByName(name);
    }

    @Override
    public boolean checkProgramInDatabase(Program program) {
        return programDAO.checkProgramInDB(program);
    }

    @Override
    public List<Program> listProgram() {
        return programDAO.findAll();
    }
}
