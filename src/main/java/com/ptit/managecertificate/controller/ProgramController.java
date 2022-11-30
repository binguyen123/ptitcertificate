package com.ptit.managecertificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.managecertificate.entity.Program;
import com.ptit.managecertificate.model.ProgramModel;
import com.ptit.managecertificate.service.ProgramService;

@Controller
public class ProgramController {
    @Autowired
    ProgramService programService;

    @RequestMapping(value = "/program/list", method = RequestMethod.GET)
    public String listProgram(Model model) {
        model.addAttribute("program", new ProgramModel());
        model.addAttribute("listPrograms", programService.listProgram());
        return "authorize/manageProgram";
    }

    @RequestMapping(value = "/program/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("program") ProgramModel programModel, Model model) {
        Program program = new Program();
        program.setId(programModel.getId());
        program.setName(programModel.getName());
        program.setDescription(programModel.getDescription());

        if (!programService.checkProgramInDatabase(program)) {
            programService.saveProgram(program);
        } else {
            Program p = programService.getProgramById(programModel.getId());
            p.setName(programModel.getName());
            p.setDescription(programModel.getDescription());
            programService.updateProgram(p);
        }

        model.addAttribute("program", new ProgramModel());
        return "redirect:/program/list";
    }

    @RequestMapping("/program/edit/{id}")
    private String editProgram(@PathVariable("id") Long id, Model model){
        Program p = programService.getProgramById(id);

        ProgramModel pm = new ProgramModel();
        pm.setId(p.getId());
        pm.setName(p.getName());
        pm.setDescription(p.getDescription());

        model.addAttribute("program", pm);
        model.addAttribute("listPrograms", programService.listProgram());
        return "authorize/manageProgram";
    }

    @RequestMapping("/program/remove/{id}")
    public String removeProgram(@PathVariable("id") Long id, Model model){
        this.programService.deleteProgram(programService.getProgramById(id));
        return "redirect:/program/list";
    }
}
