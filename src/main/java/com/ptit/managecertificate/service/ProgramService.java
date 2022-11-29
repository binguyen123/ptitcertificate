package com.ptit.managecertificate.service;

import com.ptit.managecertificate.entity.Program;

import java.util.List;

public interface ProgramService {
    void saveProgram(Program program);
    void updateProgram(Program program);
    void deleteProgram(Program program);
    Program getProgramById(Long id);
    Program getProgramByName(String name);
    boolean checkProgramInDatabase(Program program);
    List<Program> listProgram();
}
