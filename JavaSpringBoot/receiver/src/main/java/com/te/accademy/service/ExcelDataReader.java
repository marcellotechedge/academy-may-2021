package com.te.accademy.service;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.te.accademy.data.Data;
import com.te.accademy.data.Sheet;
import com.te.accademy.webapi.client.api.CaseDistributionControllerApi;
import com.te.accademy.webapi.client.model.CaseDistribution;

@Service
public class ExcelDataReader {
	static Logger log = LogManager.getLogger();

	@Autowired
	CaseDistributionControllerApi testControllerApi;

	@RabbitListener(queues = "loader")
	public void handeMessage(Data data) {

		ObjectMapper mapper = new ObjectMapper();

		mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() { //
			@Override
			public Class<?> findPOJOBuilder(AnnotatedClass ac) { //
				if (CaseDistribution.class.equals(ac.getRawType())) { //
					return CaseDistributionBuilder.class;
				}
				return super.findPOJOBuilder(ac);
			} //
		});

		for (Sheet sheet : data.getSheets()) {
			for (Map<String, String> row : sheet.getRows()) {

				CaseDistribution toBePublished = mapper.convertValue(row, CaseDistribution.class);

				testControllerApi.insertCaseUsingPOST(toBePublished);
			}
		}

	}
}
