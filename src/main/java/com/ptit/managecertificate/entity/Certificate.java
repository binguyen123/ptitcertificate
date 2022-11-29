package com.ptit.managecertificate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "certificate")
public class Certificate implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "grantedBy")
    private String grantedBy;

    // OneToOne with course

    // ManyToMany with certificate
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "person_certificate",
//            joinColumns = { @JoinColumn(name = "certificate_id") },
//            inverseJoinColumns = { @JoinColumn(name = "person_id") }
//    )
//    private Set<Person> personSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getGrantedBy() {
        return grantedBy;
    }

    public void setGrantedBy(String grantedBy) {
        this.grantedBy = grantedBy;
    }

//    public Set<Person> getPersonSet() {
//        return personSet;
//    }
//
//    public void setPersonSet(Set<Person> personSet) {
//        this.personSet = personSet;
//    }
}
