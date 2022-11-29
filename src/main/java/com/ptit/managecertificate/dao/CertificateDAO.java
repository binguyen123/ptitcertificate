package com.ptit.managecertificate.dao;

import com.ptit.managecertificate.entity.Certificate;

import java.util.List;

public interface CertificateDAO {
    public void save(Certificate certificate);
    public void update(Certificate certificate);
    public void delete(Certificate certificate);
    public List<Certificate> findAll();
    public Certificate getCertificateByCode(Long id);
    public Certificate getCertificateByCertificateName(String certificateName);
    public boolean checkCertificateInDatabase(Certificate certificate);
}
