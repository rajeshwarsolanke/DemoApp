package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entities.SsnMasterEntity;
import com.ashokit.model.SsnEnrollmentRequest;
import com.ashokit.repository.SsnMasterRepository;
import com.ashokit.repository.StatesMasterRepository;

@Service
public class SsaServiceImpl implements SsaService {

	@Autowired
	private StatesMasterRepository statesRepo;

	@Autowired
	private SsnMasterRepository ssnRepo;

	@Override
	public List<String> getAllStateNames() {
		return statesRepo.findStateNames();
	}

	@Override
	public Long ssnEnrollment(SsnEnrollmentRequest req) {
		SsnMasterEntity entity = new SsnMasterEntity();

		BeanUtils.copyProperties(req, entity);

		SsnMasterEntity savedEntity = ssnRepo.save(entity);

		if (savedEntity != null) {
			return savedEntity.getSsn();
		}
		return null;
	}

	@Override
	public String checkEnrollment(Long ssn) {
		Optional<SsnMasterEntity> entity = ssnRepo.findById(ssn);
		if (entity.isPresent()) {
			return entity.get().getState();
		}
		return null;
	}

}
