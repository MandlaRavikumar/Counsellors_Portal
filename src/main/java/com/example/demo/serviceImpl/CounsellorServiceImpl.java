package com.example.demo.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Counsellor;
import com.example.demo.Entity.Enquiry;
import com.example.demo.Repository.CounsellorRepo;
import com.example.demo.Repository.EnquiryRepo;
import com.example.demo.dto.DashboardResponse;
import com.example.demo.service.CounsellorService;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepo counsellorRepo;
	@Autowired
	private EnquiryRepo enquiryRepo;

	@Override
	public boolean counsellorRegister(Counsellor counsellor) {

		if (counsellorRepo.existsByEmail(counsellor.getEmail())) {
			return false;
		}

		Counsellor counsellorSaved = counsellorRepo.save(counsellor);
		return counsellorSaved.getCounsellorId() != null;
	}

	@Override
	public Counsellor login(String email, String pwd) {
		Counsellor counsellor = counsellorRepo.findByEmailAndPwd(email, pwd);
		return counsellor;
	}

	@Override
	public DashboardResponse getDashboardInformation(Integer counsellorId) {
		DashboardResponse dashboardResponse = new DashboardResponse();
		List<Enquiry> enqList = enquiryRepo.findByEnquries(counsellorId);
		int totalEnq = enqList.size();
		int enrollEnqs = enqList.stream().filter(e -> e.getEnqStatus().equalsIgnoreCase("Enrolled"))
				.collect(Collectors.toList()).size();
		int openEnqs = enqList.stream().filter(e -> e.getEnqStatus().equalsIgnoreCase("Open"))
				.collect(Collectors.toList()).size();
		int lostEnqs = enqList.stream().filter(e -> e.getEnqStatus().equalsIgnoreCase("Lost"))
				.collect(Collectors.toList()).size();
		dashboardResponse.setTotalEnqs(totalEnq);
		dashboardResponse.setEnrollEnqs(enrollEnqs);
		dashboardResponse.setOpenEnqs(openEnqs);
		dashboardResponse.setLostEnqs(lostEnqs);
		return dashboardResponse;
	}

}
