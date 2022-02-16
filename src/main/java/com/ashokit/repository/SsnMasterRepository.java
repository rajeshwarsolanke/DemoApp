package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entities.SsnMasterEntity;

public interface SsnMasterRepository extends JpaRepository<SsnMasterEntity, Serializable> {

}
