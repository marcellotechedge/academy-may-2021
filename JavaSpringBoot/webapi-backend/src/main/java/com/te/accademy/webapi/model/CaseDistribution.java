package com.te.accademy.webapi.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CaseDistribution {
	
	@Id
	@GeneratedValue
	private Integer id;

	private int casesWeekly;

	private String continentExp;

	private String countriesAndTerritories;

	private String countryTerritoryCode;

	private int deathsWeekly;

	private String geoId;

	private BigDecimal notificationRate;

	private BigInteger popData2019;

	private Date yearWeek;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCasesWeekly() {
		return casesWeekly;
	}

	public void setCasesWeekly(int casesWeekly) {
		this.casesWeekly = casesWeekly;
	}

	public String getContinentExp() {
		return continentExp;
	}

	public void setContinentExp(String continentExp) {
		this.continentExp = continentExp;
	}

	public String getCountriesAndTerritories() {
		return countriesAndTerritories;
	}

	public void setCountriesAndTerritories(String countriesAndTerritories) {
		this.countriesAndTerritories = countriesAndTerritories;
	}

	public String getCountryTerritoryCode() {
		return countryTerritoryCode;
	}

	public void setCountryTerritoryCode(String countryTerritoryCode) {
		this.countryTerritoryCode = countryTerritoryCode;
	}

	public int getDeathsWeekly() {
		return deathsWeekly;
	}

	public void setDeathsWeekly(int deathsWeekly) {
		this.deathsWeekly = deathsWeekly;
	}

	public String getGeoId() {
		return geoId;
	}

	public void setGeoId(String geoId) {
		this.geoId = geoId;
	}

	public BigDecimal getNotificationRate() {
		return notificationRate;
	}

	public void setNotificationRate(BigDecimal notificationRate) {
		this.notificationRate = notificationRate;
	}

	public BigInteger getPopData2019() {
		return popData2019;
	}

	public void setPopData2019(BigInteger popData2019) {
		this.popData2019 = popData2019;
	}

	public Date getYearWeek() {
		return yearWeek;
	}

	public void setYearWeek(Date yearWeek) {
		this.yearWeek = yearWeek;
	}
	
	
}