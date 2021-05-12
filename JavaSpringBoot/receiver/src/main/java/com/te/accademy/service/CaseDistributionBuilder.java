package com.te.accademy.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.te.accademy.webapi.client.model.CaseDistribution;

public class CaseDistributionBuilder {
		String country;
		Date date;
		BigDecimal notificationRate;
		Integer casesWeekly;
		Integer deathsWeekly;

		public CaseDistributionBuilder withCountry(String country) {
			this.country = country;

			return this;
		}

		public CaseDistributionBuilder withDate(String date) throws Exception {
			SimpleDateFormat df = new SimpleDateFormat("d/M/yy");
			this.date = df.parse(date);

			return this;
		}

		public CaseDistributionBuilder withNotificationRate(String notificationRate) throws Exception {
			this.notificationRate = new BigDecimal(notificationRate.replaceAll(",", "."));

			return this;
		}

		public CaseDistributionBuilder withCasesWeekly(String casesWeekly) throws Exception {
			this.casesWeekly = Integer.parseInt(casesWeekly);

			return this;
		}

		public CaseDistributionBuilder withDeathsWeekly(String deathsWeekly) throws Exception {
			this.deathsWeekly = Integer.parseInt(deathsWeekly);

			return this;
		}

		public CaseDistribution build() {
			CaseDistribution n = new CaseDistribution();

			n.setCasesWeekly(this.casesWeekly);
			n.setYearWeek(date);
			n.setCountriesAndTerritories(country);
			n.setNotificationRate(notificationRate);
			n.setDeathsWeekly(deathsWeekly);

			return n;
		}
	}