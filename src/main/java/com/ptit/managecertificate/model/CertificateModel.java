package com.ptit.managecertificate.model;

import java.util.Date;

public class CertificateModel {

    private String name;
    private String description;
    private Date session_start;
    private Date session_stop;

    public CertificateModel() {
    }

    public CertificateModel(String name, String description, Date session_start, Date session_stop) {
        this.name = name;
        this.description = description;
        this.session_start = session_start;
        this.session_stop = session_stop;
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

    public Date getSession_start() {
        return session_start;
    }

    public void setSession_start(Date session_start) {
        this.session_start = session_start;
    }

    public Date getSession_stop() {
        return session_stop;
    }

    public void setSession_stop(Date session_stop) {
        this.session_stop = session_stop;
    }

    //     this.name =name;
//        this.description =description;
//        this.session_start =session_start;
//        this.session_stop =session_stop;
}
