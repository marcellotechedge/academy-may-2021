package com.te.accademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.te.accademy.data.parse.DataParser;
import com.te.accademy.data.parse.ExcelDataParser;

@Configuration
public class ExcelLoaderConfig {

	@Bean
	DataParser getDataParser() {
		return new ExcelDataParser();
	}
}
