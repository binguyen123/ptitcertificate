package com.ptit.managecertificate.model;

public class UserModel {

    private Long id;
    private String username;
    private String password;
    private String retypePassword;
    private String type;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}