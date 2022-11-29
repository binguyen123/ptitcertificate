package com.ptit.managecertificate.model;

public class CourseModel {
    private Long id;
    private String name;
    private String pointAverage;
    private String dateStart;
    private String dateEnd;

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

    public void setPointAverage(String pointAvg) {
        this.pointAverage = pointAvg;
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

    
}
