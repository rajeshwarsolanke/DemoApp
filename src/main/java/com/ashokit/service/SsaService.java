package com.ashokit.service;

import java.util.List;

import com.ashokit.model.SsnEnrollmentRequest;

public interface SsaService {

	public List<String> getAllStateNames();

	public Long ssnEnrollment(SsnEnrollmentRequest req);

	public String checkEnrollment(Long ssn);
}
