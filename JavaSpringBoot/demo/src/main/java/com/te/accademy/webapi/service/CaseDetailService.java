package com.te.accademy.webapi.service;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.accademy.webapi.model.CaseDistribution;
import com.te.accademy.webapi.repository.CaseDetailRepository;

@Service
public class CaseDetailService {

	static Logger log = LogManager.getLogger();
	
	@Autowired
	private CaseDetailRepository caseDetailRepository;

	@PostConstruct
	public void init() {
		log.info("init callsed");
	}
	
	@Transactional
	public boolean update(Integer id, CaseDistribution newValue) {
		Optional<CaseDistribution> old = caseDetailRepository.findById(id);

		if (old.isEmpty()) {
			return false;
		}

		CaseDistribution c = old.get();

		BeanUtils.copyProperties(newValue, c, "id");

		return true;
	}
}
