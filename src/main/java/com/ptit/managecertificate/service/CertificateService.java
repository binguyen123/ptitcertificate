package com.ptit.managecertificate.service;

import com.ptit.managecertificate.entity.Certificate;

public interface CertificateService {

    void saveCertificate(Certificate certificate);
    void updateCertificate(Certificate certificate);
    Certificate getCertificateByName(String certificate);
    boolean checkCertificateSInDatabase(Certificate certificate);

}
