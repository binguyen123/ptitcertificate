package com.ptit.managecertificate.controller;

import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.model.CertificateModel;
import com.ptit.managecertificate.service.CertificateService;
import com.ptit.managecertificate.service.CourseService;
import com.ptit.managecertificate.service.ProgramService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class CertificateController extends BaseController {

	@Autowired
	CertificateService certificateService;
	@Autowired
	ProgramService programService;
	@Autowired
	CourseService courseService;

	// show list certificate
	@RequestMapping(value = { "/certificate/list" }, method = RequestMethod.GET)
	public String listCertificate(Model model) throws IOException {
		model.addAttribute("certificate", new CertificateModel());
		model.addAttribute("listCertificates", certificateService.listCertificate());
		model.addAttribute("listProgram", programService.listProgram());
		return "authorize/manageCertificate";
	}

	// add new certificate
	@RequestMapping(value = "/certificate/add", method = RequestMethod.POST)
	public String addCertificate(@ModelAttribute("certificate") CertificateModel certificateModel, Model model) {
		
		while(certificateModel.getGrantedBy()==null) {
			model.addAttribute("message", "Please Choose Program");
			model.addAttribute("certificate", certificateModel);
			model.addAttribute("listCertificates", certificateService.listCertificate());
			model.addAttribute("listProgram", programService.listProgram());
			return "authorize/manageCertificate";
		}
		
		Certificate c = new Certificate();

		c.setId(certificateModel.getId());
		c.setName(certificateModel.getName());
		c.setDescription(certificateModel.getDescription());
		c.setProgram(programService.getProgramById(certificateModel.getGrantedBy()));

		if (!certificateService.checkCertificateSInDatabase(c)) {
			certificateService.saveCertificate(c);
		} else {
			Certificate cerUpdate = certificateService.getCertificateById(certificateModel.getId());
			cerUpdate.setName(certificateModel.getName());
			cerUpdate.setDescription(certificateModel.getDescription());
			cerUpdate.setProgram(programService.getProgramById(certificateModel.getGrantedBy()));
			certificateService.updateCertificate(cerUpdate);
		}

		model.addAttribute("certificate", new CertificateModel());
		return "redirect:/certificate/list";
	}

	// edit certificate
	@RequestMapping("/certificate/edit/{id}")
	public String editCertificate(@PathVariable("id") Long id, Model model) {
		Certificate c = certificateService.getCertificateById(id);

		CertificateModel cm = new CertificateModel();
		try {
			cm.setId(c.getId());
			cm.setName(c.getName());
			cm.setDescription(c.getDescription());
			cm.setGrantedBy(c.getProgram().getId());
		} catch (Exception e) {
		}

		model.addAttribute("certificate", cm);
		model.addAttribute("listCertificates", certificateService.listCertificate());
		model.addAttribute("listProgram", programService.listProgram());
		return "authorize/manageCertificate";
	}

	@RequestMapping("/certificate/remove/{code}")
	public String removeCertificate(@PathVariable("code") Long id, Model model) {
		this.certificateService.deleteCertificate(certificateService.getCertificateById(id));
		return "redirect:/certificate/list";
	}

    @RequestMapping("/certificate/listCourse/{id}")
    public String viewCourseSameCertificate(@PathVariable("id")Long id, Model model) {
    	
    	model.addAttribute("listCourses", courseService.listCourseSameCertificate(id));
		return "authorize/courseListCertificate";
    	
    }

}
