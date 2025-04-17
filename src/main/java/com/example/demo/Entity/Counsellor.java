package com.example.demo.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="counsellor_tbl")
public class Counsellor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="counsellor_id")
	private Integer counsellorId;
	
	@Column(name="name")
	private String name;
	@Column(unique = true)
	private String email;
	private String pwd;
	private Long phno;
	
	@Column(name="created_by")
	@CreationTimestamp
	private LocalDate createdBy;
	
	@Column(name="updated_by")
	@UpdateTimestamp
	private LocalDate updatedBy;

	public Integer getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(Integer counsellorId) {
		this.counsellorId = counsellorId;
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDate getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(LocalDate createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(LocalDate updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	

}
