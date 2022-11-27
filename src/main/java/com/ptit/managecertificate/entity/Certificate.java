package com.ptit.managecertificate.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "certificate")
public class Certificate implements Serializable, Comparable<Certificate> {
    private static final long serialVersionUcode = 1L;

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    public Certificate() {
    }

    public Certificate(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public int compareTo(Certificate o) {
        return this.code.compareTo(o.getCode());
    }
}
