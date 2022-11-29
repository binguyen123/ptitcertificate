package com.ptit.managecertificate.dao;


import com.ptit.managecertificate.entity.Program;

import java.util.List;

public interface ProgramDAO {
    void save(Program program);
    void update(Program program);
    void delete(Program program);
    Program findById(Long id);
    List<Program> findAll();
    Program getProgramByName(String name);
    boolean checkProgramInDB(Program program);
}
