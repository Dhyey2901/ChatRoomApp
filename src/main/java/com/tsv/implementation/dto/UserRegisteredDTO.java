package com.tsv.implementation.dto;


public class UserRegisteredDTO {

	
    private String name;
	
	
	
	private String email_id;
	
	private String password;
	
	String role;


	private int sem;

	private String branch;

	private  String collage_id;

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCollage_id() {
		return collage_id;
	}

	public void setCollage_id(String collage_id) {
		this.collage_id = collage_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
