package com.ptit.managecertificate.model;

import java.util.Date;

public class CertificateModel {

    private String name;
    private String description;
    private String grantedBy;

    public CertificateModel() {
    }

    public CertificateModel(String name, String description, String grantedBy) {
        this.name = name;
        this.description = description;
        this.grantedBy = grantedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrantedBy() {
        return grantedBy;
    }

    public void setGrantedBy(String grantedBy) {
        this.grantedBy = grantedBy;
    }

    //        this.description =description;
//        this.session_start =session_start;
//        this.session_stop =session_stop;
}
