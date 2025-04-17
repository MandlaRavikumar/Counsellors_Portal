package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Counsellor;
import com.example.demo.dto.DashboardResponse;
import com.example.demo.service.CounsellorService;

@CrossOrigin(origins = "*") // or specify your frontend origin
@RestController
@RequestMapping("/api/counsellor")
public class CounsellorController {
	
	@Autowired
	private CounsellorService counsellorService;
	
	@PostMapping("/register")
	public ResponseEntity<String> counsellorRegister(@RequestBody Counsellor counsellor) {
	    boolean isRegistered = counsellorService.counsellorRegister(counsellor);
	    if (isRegistered) {
	        return ResponseEntity.ok("Counsellor registered successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists. Please use a different email.");
	    }
	}

    
    @PostMapping("/login")
    public ResponseEntity<Counsellor> login(@RequestParam String email, @RequestParam String pwd){
    	Counsellor counsellor = counsellorService.login(email, pwd);
    	if(counsellor != null) {
    		return ResponseEntity.ok(counsellor);
    	}else {
    		return ResponseEntity.status(401).body(null);
    	}		    	
    }
    
    @GetMapping("/dashboard/{counsellorId}")
    public ResponseEntity<DashboardResponse> getDashboard(@PathVariable Integer counsellorId){
    	DashboardResponse response= counsellorService.getDashboardInformation(counsellorId);
    	if(response != null) {
    		return ResponseEntity.ok(response);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
		
    	
    }
}
