package com.productapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String uname;
	private String upassword;
	private String ucpassword;
	
	public AdminUser() {
		super();
	}
	
	public AdminUser(String uname, String upassword, String ucpassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.ucpassword = ucpassword;
	}
	public AdminUser(int id, String uname, String upassword, String ucpassword) {
		super();
		this.id = id;
		this.uname = uname;
		this.upassword = upassword;
		this.ucpassword = ucpassword;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcpassword() {
		return ucpassword;
	}
	public void setUcpassword(String ucpassword) {
		this.ucpassword = ucpassword;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", uname=" + uname + ", upassword=" + upassword + ", ucpassword=" + ucpassword
				+ "]";
	}
}
