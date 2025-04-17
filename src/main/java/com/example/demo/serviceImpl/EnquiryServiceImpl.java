package com.example.demo.serviceImpl;

import java.util.List;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Counsellor;
import com.example.demo.Entity.Enquiry;
import com.example.demo.Repository.CounsellorRepo;
import com.example.demo.Repository.EnquiryRepo;
import com.example.demo.dto.ViewEnqsFilterRequest;
import com.example.demo.service.EnquiryService;
@Service
public class EnquiryServiceImpl implements EnquiryService {
	
	@Autowired
	private CounsellorRepo counsellorRepo;
	@Autowired
	private EnquiryRepo enquiryRepo;

	@Override
    public boolean addEnquiry(Enquiry enquiry, Integer counsellorId) throws Exception {
        Counsellor counsellor = counsellorRepo.findById(counsellorId).orElse(null);
        if (counsellor == null) {
            throw new Exception("No Counsellor Found");
        }

        Enquiry existingEnquiry = null;

        if (enquiry.getEnquiryId() != null) {
            existingEnquiry = enquiryRepo.findById(enquiry.getEnquiryId()).orElse(null);
        }

        if (existingEnquiry != null) {
            // Update existing enquiry
            existingEnquiry.setStuName(enquiry.getStuName());
            existingEnquiry.setStuPhno(enquiry.getStuPhno());
            existingEnquiry.setCourseName(enquiry.getCourseName());
            existingEnquiry.setClassMode(enquiry.getClassMode());
            existingEnquiry.setEnqStatus(enquiry.getEnqStatus());
            existingEnquiry.setCounsellorId(counsellor);
            enquiryRepo.save(existingEnquiry);
        } else {
            // Create new enquiry
            enquiry.setCounsellorId(counsellor);
            enquiryRepo.save(enquiry);
        }

        return true;
    }


	@Override
	public List<Enquiry> getAllEnquiry(Integer counsellorId) {
		List<Enquiry> listEnq= enquiryRepo.findByEnquries(counsellorId);
		return listEnq;
	}


	@Override
	public Enquiry getenquiry(Integer enquiryId) {
		
		return enquiryRepo.findById(enquiryId).orElse(null);
	}
	
	@Override
	public List<Enquiry> getEnquiriesWithFilter(ViewEnqsFilterRequest filterReq, Integer counsellorId) {
		
		//QBE implimentation (Dynamic Query Preparation)
		
		Enquiry enq = new Enquiry();
		
		if(StringUtils.isNotBlank(filterReq.getClassMode())) {
			enq.setClassMode(filterReq.getClassMode());
		}
		
		if(StringUtils.isNotBlank(filterReq.getCourseName())) {
			enq.setCourseName(filterReq.getCourseName());
		}
		
		if(StringUtils.isNotBlank(filterReq.getEnqsStatus())) {
			enq.setEnqStatus(filterReq.getEnqsStatus());
		}
		
		Counsellor counsellor =counsellorRepo.findById(counsellorId).orElse(null);
		enq.setCounsellorId(counsellor);
		
		Example<Enquiry> exOf =  Example.of(enq);  // dynamic query
		
		List<Enquiry> listEnq =enquiryRepo.findAll(exOf);
		
		return listEnq;
	}


	@Override
	public boolean deleteEnquiryById(Integer id) {
        if (enquiryRepo.existsById(id)) {
        	enquiryRepo.deleteById(id);
            return true;
        }
        return false;

	}


}
