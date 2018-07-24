package com.dhht.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "sys_user")
public class User implements Serializable{
    @Id
    @Column(nullable = false,length = 32, unique = true)
	private String id;
    
    @Column(columnDefinition = "varchar(100) Comment  '姓名'" )
	private String name;
    
    @Column(columnDefinition = "INT(10) Comment  '年龄'" )
	private Integer age;
    
    @Column(columnDefinition = "varchar(100) Comment  '密码'")
    private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
