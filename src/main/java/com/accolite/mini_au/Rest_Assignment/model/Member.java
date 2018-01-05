package com.accolite.mini_au.Rest_Assignment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
	String name;
	String email;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Member(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Member()
	{
		
	}
}
