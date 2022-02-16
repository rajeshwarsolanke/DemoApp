package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.model.SsnEnrollmentRequest;
import com.ashokit.service.SsaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = { "Access-Control-Allow-Origin" })
public class SsnEnrollmentRestController {

	@Autowired
	private SsaService service;

	@PostMapping(value = "/enroll", consumes = "application/json")
	public ResponseEntity<String> enroll(@RequestBody SsnEnrollmentRequest request) {
		
		ResponseEntity<String> response = null;

		Long ssn = service.ssnEnrollment(request);

		String body = "Your SSN Enrollment Completed Successfuly. Your SSN :: " + ssn;

		response = new ResponseEntity<>(body, HttpStatus.CREATED);

		return response;
	}

}
