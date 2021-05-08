package com.te.accademy.webapi.restcontroller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.accademy.webapi.datamodel.CaseDetail;
import com.te.accademy.webapi.datamodel.CaseDistribution;
import com.te.accademy.webapi.datamodel.CaseSummary;
import com.te.accademy.webapi.datamodel.Country;

@RestController
public class CaseDistroController {

	public static class RestResponse {
		public String state;
		public String message;

		RestResponse(String state, String message) {
			this.state = state;
			this.message = message;
		}
	}

	@GetMapping("/countries")
	public List<Country> getAll() {
		Country c=new Country();
		c.setCode("ITA");
		c.setContinent("Europe");
		c.setCountry("Italy");
		
		return Collections.singletonList(c);
	}

	@GetMapping("/case/{case_id}")
	public CaseDetail getCaseById(@PathVariable Integer case_id) {
		return null;
	}

	@GetMapping("/case")
	public List<CaseDetail> getDetail(//
			@RequestParam(required = false) Date from, //
			@RequestParam(required = false) Date to, //
			@RequestParam(required = false) String country) {

		return Collections.<CaseDetail>emptyList();
	}

	@PostMapping("/case")
	public RestResponse insertCase(@RequestBody CaseDistribution newCaseDistribution) {

		return new RestResponse("Success", "Case created successfully");
	}

	@PutMapping("/case")
	public RestResponse updateCase(@RequestBody CaseDistribution updateCaseDistribution) {

		return new RestResponse("Success", "Case updated successfully");
	}

	@DeleteMapping("/case")
	public RestResponse deleteCase(@RequestParam Integer caseId) {

		return new RestResponse("Success", "Case deleted successfully");
	}

	@GetMapping("/case-summary")
	public List<CaseSummary> getSummary(//
			@RequestParam(required = false) Date from, //
			@RequestParam(required = false) Date to, //
			@RequestParam(required = false) String country) {

		return Collections.<CaseSummary>emptyList();
	}
}
