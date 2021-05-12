package com.te.accademy.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.te.accademy.webapi.model.CaseDetail;
import com.te.accademy.webapi.model.CaseDistribution;
import com.te.accademy.webapi.model.CaseSummary;
import com.te.accademy.webapi.model.Country;

public interface CaseDetailRepository extends CrudRepository<CaseDistribution, Integer> {

	CaseDetail findCaseById(Integer id);

	@Query("select " //
			+ "new com.te.accademy.webapi.model.CaseDetail(" //
			+ "c.id, " //
			+ "c.casesWeekly, " //
			+ "c.continentExp, " //
			+ "c.countriesAndTerritories," //
			+ "c.countryTerritoryCode," //
			+ "c.deathsWeekly," //
			+ "c.popData2019," //
			+ "c.yearWeek " //
			+ ")" //
			+ " from CaseDistribution as c " //
			+ "where " //
			+ "(:fromdate is null or c.yearWeek >= :fromdate) " //
			+ " and " //
			+ " (:todate is null or c.yearWeek <= :todate) " //
			+ " and " //
			+ " (:country is null or c.countryTerritoryCode = :country) ")
	List<CaseDetail> findCaseCustom(@Param("fromdate") Date from, @Param("todate") Date to,
			@Param("country") String country);

	@Query("select distinct new com.te.accademy.webapi.model.Country(" //
			+ "c.countryTerritoryCode, " //
			+ "c.countriesAndTerritories," //
			+ "c.continentExp" //
			+ ") from CaseDistribution as c  ")
	List<Country> findDistinctCountries();

	@Query("select " //
			+ " new com.te.accademy.webapi.model.CaseSummary(" //
			+ "c.countryTerritoryCode," //
			+ "c.continentExp," //
			+ "c.countriesAndTerritories," //
			+ "sum(c.casesWeekly), " //
			+ "sum(c.deathsWeekly) " //
			+ ") " //
			+ " from CaseDistribution as c " //
			+ "where " //
			+ "(:fromdate is null or c.yearWeek >= :fromdate) " //
			+ " and " //
			+ " (:todate is null or c.yearWeek <= :todate) " //
			+ " and " //
			+ " (:country is null or c.countryTerritoryCode = :country) " //
			+ " group by " //
			+ " c.countryTerritoryCode , c.countriesAndTerritories, c.continentExp ")

	List<CaseSummary> findCaseSummaryCustom(@Param("fromdate") Date from, @Param("todate") Date to,
			@Param("country") String country);
}
