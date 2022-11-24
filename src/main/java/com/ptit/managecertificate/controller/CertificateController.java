package com.ptit.managecertificate.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.service.CertificateService;

@Controller
public class CertificateController extends BaseController{

    @Autowired
    private CertificateService certificateService;

    @RequestMapping(value = {"/certificate"}, method = RequestMethod.GET)
    public String listCertificate(Model model) throws IOException{
        List<Certificate> list = certificateService.listCertificate();
        model.addAttribute("listCertificate", list);
        return "admin/editCertificate";
    }

    

}
