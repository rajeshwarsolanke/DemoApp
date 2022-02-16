package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.SsaService;

@RestController
public class SsnValidationRestController {

	@Autowired
	private SsaService service;

	@GetMapping(value = "/getStateName/{ssn}")
	public ResponseEntity<String> validate(@PathVariable("ssn") String ssn) {
		ResponseEntity<String> response = null;

		String status = service.checkEnrollment(Long.parseLong(ssn));

		response = new ResponseEntity<>(status, HttpStatus.OK);

		return response;
	}

}
