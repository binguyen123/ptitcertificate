package com.ptit.managecertificate.controller;

import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.model.CertificateModel;
import com.ptit.managecertificate.service.CertificateService;
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
    private CertificateService certificateService;

    // show list certificate
    @RequestMapping(value = {"/certificate/list"}, method = RequestMethod.GET)
    public String listCertificate(Model model) throws IOException {
        model.addAttribute("certificate",new CertificateModel());
        model.addAttribute("listCertificates", certificateService.listCertificate());
        return "authorize/manageCertificate";
    }

    // add new certificate
    @RequestMapping(value = "/certificate/add", method = RequestMethod.POST)
    public String addCertificate(@ModelAttribute("certificate") CertificateModel certificateModel, Model model) {
        Certificate c1 = new Certificate();
        
        c1.setId(certificateModel.getId());
        c1.setName(certificateModel.getName());
        c1.setDescription(certificateModel.getDescription());
        c1.setGrantedBy(certificateModel.getGrantedBy());

        if (!certificateService.checkCertificateSInDatabase(c1)) {
            certificateService.saveCertificate(c1);
        } else {
            Certificate c2 = certificateService.getCertificateByName(certificateModel.getName());
            c2.setDescription(certificateModel.getDescription());
            c2.setGrantedBy(certificateModel.getGrantedBy());
            certificateService.updateCertificate(c2);
        }

        model.addAttribute("certificate", new CertificateModel());
        return "redirect:/certificate/list";
    }

    // edit certificate
    @RequestMapping("/certificate/edit/{id}")
    public String editCertificate(@PathVariable("id") Long code, Model model) {
    	Certificate c = certificateService.getCertificateByCode(code);
    	
    	CertificateModel cm = new CertificateModel();
    	cm.setId(c.getId());
    	cm.setName(c.getName());
    	cm.setDescription(c.getDescription());
    	cm.setGrantedBy(c.getGrantedBy());
    	
    	model.addAttribute("certificate", cm);
    	model.addAttribute("listCertificates", certificateService.listCertificate());
        return "authorize/manageCertificate";
    }

    @RequestMapping("/certificate/remove/{code}")
    public String removeCertificate(@PathVariable("code") Long code, Model model) {
        this.certificateService.deleteCertificate(certificateService.getCertificateByCode(code));
        return "redirect:/certificate/list";
    }
}
