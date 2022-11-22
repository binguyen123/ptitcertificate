package com.ptit.managecertificate.service.Impl;

import com.ptit.managecertificate.dao.CertificateDAO;
import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    CertificateDAO certificateDAO;

    @Override
    public void saveCertificate(Certificate certificate) {
        certificateDAO.save(certificate);
    }

    @Override
    public void updateCertificate(Certificate certificate) {
        certificateDAO.update(certificate);
    }

    @Override
    public Certificate getCertificateByName(String certificate) {
        return certificateDAO.getCertificateByCertificateName(certificate);
    }

    @Override
    public boolean checkCertificateSInDatabase(Certificate certificate) {
        return certificateDAO.checkCertificateInDatabase(certificate);
    }
}
