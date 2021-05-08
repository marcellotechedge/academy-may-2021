package com.te.accademy.webapi.datamodel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.accademy.webapi.datamodel.CaseDetail;
import com.te.accademy.webapi.datamodel.CaseDistribution;

public interface CaseDistributionRepository extends JpaRepository<CaseDistribution, Integer> {

	CaseDetail findCaseById(Integer id);
}
