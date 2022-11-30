package com.ptit.managecertificate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "certificate")
public class Certificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	// One To Many With Course
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "certificate")
	private Set<Course> courses = new HashSet<>();

	// OneToOne with Program
	@OneToOne
	@JoinColumn(name = "program_id", nullable = false)
	private Program program;

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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
