package com.example.demo.dto;

public class DashboardResponse {
	
	private Integer totalEnqs;
	private Integer openEnqs;
	private Integer enrollEnqs;
	private Integer lostEnqs;
	
	public Integer getTotalEnqs() {
		return totalEnqs;
	}
	public void setTotalEnqs(Integer totalEnqs) {
		this.totalEnqs = totalEnqs;
	}
	public Integer getOpenEnqs() {
		return openEnqs;
	}
	public void setOpenEnqs(Integer openEnqs) {
		this.openEnqs = openEnqs;
	}
	public Integer getEnrollEnqs() {
		return enrollEnqs;
	}
	public void setEnrollEnqs(Integer enrollEnqs) {
		this.enrollEnqs = enrollEnqs;
	}
	public Integer getLostEnqs() {
		return lostEnqs;
	}
	public void setLostEnqs(Integer lostEnqs) {
		this.lostEnqs = lostEnqs;
	}
	
	

	
}
