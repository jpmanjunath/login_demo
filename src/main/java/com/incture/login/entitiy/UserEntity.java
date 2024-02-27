package com.incture.login.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "DEMO_SESSION_USER")
@Data
@Entity
public class UserEntity {

	@Id
	@Column(name = "ID")
	protected String id;
	
	@Column(name = "NAME")
	protected String name;
	
	@Column(name = "EMAIL")
	protected String email;
	
	@Column(name = "PASSWORD")
	protected String password;
	
}
