package com.ptit.managecertificate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "dateOfBirth")
	private String dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "email")
	private String email;

	// ManyToMany with course
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
//
//	// get certificate if finish course
//	// ManyToMany with certificate
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "person_certificate",
//			joinColumns = { @JoinColumn(name = "person_id") },
//			inverseJoinColumns = { @JoinColumn(name = "certificate_id") }
//	)
//	private Set<Certificate> certificates = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Set<Certificate> getCertificates() {
//		return certificates;
//	}
//
//	public void setCertificates(Set<Certificate> certificates) {
//		this.certificates = certificates;
//	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person: [ Id: "+ id +", Name: " + firstName + " " + lastName + " ]";
	}
}
