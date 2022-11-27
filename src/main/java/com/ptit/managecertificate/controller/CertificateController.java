package com.ptit.managecertificate.controller;

import java.io.IOException;
import java.util.List;

import com.ptit.managecertificate.model.CertificateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.service.CertificateService;

@Controller
public class CertificateController extends BaseController {

    @Autowired
    private CertificateService certificateService;

    // show list certificate
    @RequestMapping(value = {"/certificate/list"}, method = RequestMethod.GET)
    public String listCertificate(Model model) throws IOException {
        setUserLogin(model);
        model.addAttribute("certificate",new CertificateModel());
        model.addAttribute("listCertificate", certificateService.listCertificate());
        return "admin/manageCertificate";
    }

    // add new certificate
    @RequestMapping(value = "/certificate/add", method = RequestMethod.POST)
    public String addCertificate(@ModelAttribute("certificate") CertificateModel certificateModel, Model model) {
        setUserLogin(model);

        Certificate cer = new Certificate();
        cer.setCode(certificateModel.getCode());
        cer.setName(certificateModel.getName());
        cer.setDescription(certificateModel.getDescription());

        if (!certificateService.checkCertificateSInDatabase(cer)) {
            certificateService.saveCertificate(cer);
        } else {
            Certificate c = certificateService.getCertificateByCode(certificateModel.getCode());
            certificateService.updateCertificate(cer);
        }

        model.addAttribute("certificate", new CertificateModel());
        return "redirect:/certificate/list";
    }

    // edit certificate
    @RequestMapping("/certificate/edit/{code}")
    public String editCertificate(@PathVariable("code") String code, Model model) {
        setUserLogin(model);

        CertificateModel cerModel = new CertificateModel();
        Certificate cer = certificateService.getCertificateByCode(code);
        cerModel.setCode(cer.getCode());
        cerModel.setName(cer.getName());
        cerModel.setDescription(cer.getDescription());

        model.addAttribute("certificate", cerModel);
        model.addAttribute("listCertificate", certificateService.listCertificate());
        return "admin/manageCertificate";
    }

    @RequestMapping("/certificate/remove/{code}")
    public String removeCertificate(@PathVariable("code") String code, Model model) {
        setUserLogin(model);
        this.certificateService.deleteCertificate(certificateService.getCertificateByCode(code));
        return "redirect:/certificate/list";
    }
}
