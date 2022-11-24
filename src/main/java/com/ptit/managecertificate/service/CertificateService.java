package com.ptit.managecertificate.service;

import com.ptit.managecertificate.entity.Certificate;

import java.util.List;

public interface CertificateService {

    void saveCertificate(Certificate certificate);
    void updateCertificate(Certificate certificate);
    void deleteCertificate(Certificate certificate);
    List<Certificate> listCertificate();
    Certificate getCertificateByName(String certificate);
    boolean checkCertificateSInDatabase(Certificate certificate);

}
