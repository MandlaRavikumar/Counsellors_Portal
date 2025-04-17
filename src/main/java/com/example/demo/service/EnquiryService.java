package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Enquiry;
import com.example.demo.dto.ViewEnqsFilterRequest;

public interface EnquiryService {
	
	public boolean addEnquiry(Enquiry enquiry, Integer counsellorId) throws Exception;
	
	public List<Enquiry> getAllEnquiry(Integer counsellorId);
	
	public List<Enquiry> getEnquiriesWithFilter(ViewEnqsFilterRequest filterReq, Integer counsellorId);
	
	public Enquiry getenquiry(Integer enquiryId);

	public boolean deleteEnquiryById(Integer id);

}
