package com.example.demo.service;

import com.example.demo.Entity.Counsellor;
import com.example.demo.dto.DashboardResponse;

public interface CounsellorService {
	
	public boolean counsellorRegister(Counsellor counsellor);
	
	public Counsellor login(String email, String pwd);
	
	public DashboardResponse getDashboardInformation(Integer counsellorId);

}
