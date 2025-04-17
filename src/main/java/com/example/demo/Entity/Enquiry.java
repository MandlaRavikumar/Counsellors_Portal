package com.example.demo.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enquiry_tbl")
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="enquiry_id")
	private Integer enquiryId;
	
	@Column(name="stu_name")
	private String stuName;
	
	@Column(name="stu_phno")
	private String stuPhno;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="class_mode")
	private String classMode;
	
	@Column(name="enq_status")
	private String enqStatus;
	
	@Column(name="created_by")
	@CreationTimestamp
	private LocalDate createdBy;
	
	@Column(name="updated_by")
	@UpdateTimestamp
	private LocalDate updatedBy;
	
	@ManyToOne
	@JoinColumn(name="counsellor_id")
	private Counsellor counsellorId;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPhno() {
		return stuPhno;
	}

	public void setStuPhno(String stuPhno) {
		this.stuPhno = stuPhno;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
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

	public Counsellor getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(Counsellor counsellorId) {
		this.counsellorId = counsellorId;
	}
	
	

}
