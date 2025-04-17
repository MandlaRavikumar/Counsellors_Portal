package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Counsellor;

@Repository
public interface CounsellorRepo extends JpaRepository<Counsellor, Integer>{

	Counsellor findByEmailAndPwd(String email, String pwd);
	
    boolean existsByEmail(String email);


}
