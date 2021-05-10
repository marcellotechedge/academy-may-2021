package com.te.accademy.webapi.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.accademy.webapi.model.CaseDetail;
import com.te.accademy.webapi.model.CaseDistribution;
import com.te.accademy.webapi.model.CaseSummary;
import com.te.accademy.webapi.model.Country;
import com.te.accademy.webapi.model.RestResponse;
import com.te.accademy.webapi.repository.CaseDetailRepository;
import com.te.accademy.webapi.service.CaseDetailService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {

	static Logger log = LogManager.getLogger();

	@Autowired
	private CaseDetailRepository caseDetailRepository;

	@Autowired
	private CaseDetailService caseDetailService;

	@GetMapping("/case")
	public List<CaseDetail> getCaseDetails(@RequestParam(required = false) Date from,
			@RequestParam(required = false) Date to, @RequestParam(required = false) String country) {

		return caseDetailRepository.findCaseCustom(from,to,country);
	}

	@ApiOperation(value = "Get CaseDistribution entry by Id")
	@GetMapping("/case/{case_id}")
	public ResponseEntity<CaseDetail> getCaseById(@PathVariable Integer case_id) {

		CaseDetail optio = caseDetailRepository.findCaseById(case_id);
		if (optio == null) {
			return ResponseEntity.notFound().build();
		} else {
			return new ResponseEntity<CaseDetail>(optio, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "List all countries")
	@GetMapping("/countries")
	public List<Country> getCountries() {
		return caseDetailRepository.findDistinctCountries();
	}

	@ApiOperation(value = "Get CaseDistribution summary")
	@GetMapping("/case-summary")
	public List<CaseSummary> getSummary(//
			@RequestParam(required = false) Date from, //
			@RequestParam(required = false) Date to, //
			@RequestParam(required = false) String country) {

		return caseDetailRepository.findCaseSummaryCustom(from,to, country);
	}

	@ApiOperation(value = "Insert a new CaseDistribution")
	@PostMapping("/case")
	public RestResponse insertCase(@RequestBody CaseDistribution nuovoCaseDistribution) {

		nuovoCaseDistribution.setId(null);
		caseDetailRepository.save(nuovoCaseDistribution);

		return new RestResponse("Success", "Case created successfully");
	}

	@ApiOperation(value = "Delete a CaseDistribution")
	@DeleteMapping("/case")
	public RestResponse deleteCase(@RequestParam Integer caseId) {

		Optional<CaseDistribution> old = caseDetailRepository.findById(caseId);

		if (old.isEmpty()) {
			return new RestResponse("Error", "Case not found");
		}

		caseDetailRepository.delete(old.get());

		return new RestResponse("Success", "Case deleted successfully");
	}

	@ApiOperation(value = "Update a CaseDistribution")
	@PutMapping("/case")
	public RestResponse updateCase(@RequestBody CaseDistribution caseDistribution) {
		log.info("update:" + caseDistribution.getCountriesAndTerritories());

		if (caseDetailService.update(caseDistribution.getId(), caseDistribution)) {
			return new RestResponse("Success", "Case update successfully");

		} else {
			return new RestResponse("Error", "Case not found");

		}
	}
}
