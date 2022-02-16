package com.ashokit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entities.StatesMasterEntity;

public interface StatesMasterRepository extends JpaRepository<StatesMasterEntity, Serializable> {

	@Query(value = "select state from StatesMasterEntity")
	public List<String> findStateNames();

}
