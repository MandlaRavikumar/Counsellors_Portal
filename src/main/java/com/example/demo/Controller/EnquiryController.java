package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Enquiry;
import com.example.demo.dto.ViewEnqsFilterRequest;
import com.example.demo.service.EnquiryService;
import com.example.demo.serviceImpl.EnquiryServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/counsellor")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@PostMapping("/enquiry/{counsellorId}")
	public ResponseEntity<String> addEnquiry(@RequestBody Enquiry enquiry, @PathVariable Integer counsellorId) {
		try {
			boolean isSuccess = enquiryService.addEnquiry(enquiry, counsellorId);
			if (isSuccess) {
				String message = (enquiry.getEnquiryId() != null) ? "Enquiry updated successfully"
						: "Enquiry added successfully";
				return ResponseEntity.ok(message);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Something went wrong while saving enquiry");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/counsellor/{counsellorId}")
	public ResponseEntity<List<Enquiry>> getEnquiriesByCounsellor(@PathVariable Integer counsellorId) {
		List<Enquiry> enquiries = enquiryService.getAllEnquiry(counsellorId);
		return ResponseEntity.ok(enquiries);
	}

	@PostMapping("/filter")
	public ResponseEntity<List<Enquiry>> getFilteredEnquiries(@RequestBody ViewEnqsFilterRequest filterRequest,
			@RequestParam("counsellorId") Integer counsellorId) {

		List<Enquiry> filteredEnquiries = enquiryService.getEnquiriesWithFilter(filterRequest, counsellorId);
		return ResponseEntity.ok(filteredEnquiries);
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnquiry(@PathVariable Integer id) {
        boolean deleted = enquiryService.deleteEnquiryById(id);
        if (deleted) {
            return ResponseEntity.ok("Enquiry deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enquiry not found");
        }
    }


}
