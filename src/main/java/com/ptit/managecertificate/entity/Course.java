package com.ptit.managecertificate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pointAverage")
    private String pointAverage;

    @Column(name = "dateStart")
    private String dateStart;

    @Column(name = "dateEnd")
    private String dateEnd;

    @Override
    public String toString() {
        return "Course [ Id:" + id + ", Name: " + name + ", Point Avg: " + pointAverage +", ListP: "+ persons.toString() + ", Started Date: " + dateStart + ", End Date: " + dateEnd + " ]";
    }

    // Many Subject in Course
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Subject> subjects = new HashSet<>();

    // OneToMany with student
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Person> persons = new HashSet<>();

    // ManyToOne with certificate
    @ManyToOne
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;
    
    
//    // Provide 1 certificate when finish 1 course
//    // OneToOne with certificate
//    @OneToOne
//    @JoinColumn(name = "certificate_id")
//    private Certificate certificate;

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

    public String getPointAverage() {
        return pointAverage;
    }

    public void setPointAverage(String pointAverage) {
        this.pointAverage = pointAverage;
    }

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	
	
	
}
