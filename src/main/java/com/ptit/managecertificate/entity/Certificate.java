package com.ptit.managecertificate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "certificate")
public class Certificate implements Serializable, Comparable<Certificate> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "session_start", nullable = false)
    private Date session_start;

    @Column(name = "session_stop", nullable = false)
    private Date session_stop;

    public Certificate() {
    }

    public Certificate(int id, String name, String description, Date session_start, Date session_stop) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.session_start = session_start;
        this.session_stop = session_stop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(Certificate o) {
        if(this.id!=o.id) return this.id>o.id?1:-1;
        else {
            return this.name.compareTo(o.name);
        }
    }
}
