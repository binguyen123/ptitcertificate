package com.ptit.managecertificate.service.Impl;

import com.ptit.managecertificate.dao.CertificateDAO;
import com.ptit.managecertificate.entity.Certificate;
import com.ptit.managecertificate.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    CertificateDAO certificateDAO;

    @Override
    @Transactional
    public void saveCertificate(Certificate certificate) {
        this.certificateDAO.save(certificate);
    }

    @Override
    @Transactional
    public void updateCertificate(Certificate certificate) {
        this.certificateDAO.update(certificate);
    }

    @Override
    @Transactional
    public void deleteCertificate(Certificate certificate) {
        this.certificateDAO.delete(certificate);
    }

    @Override
    @Transactional
    public List<Certificate> listCertificate() {
            return this.certificateDAO.findAll();
    }

    @Override
    public Certificate getCertificateByCode(String code) {
        return certificateDAO.getCertificateByCode(code);
    }

    @Override
    @Transactional
    public Certificate getCertificateByName(String certificate) {
        return this.certificateDAO.getCertificateByCertificateName(certificate);
    }

    @Override
    @Transactional
    public boolean checkCertificateSInDatabase(Certificate certificate) {
        return this.certificateDAO.checkCertificateInDatabase(certificate);
    }
}
