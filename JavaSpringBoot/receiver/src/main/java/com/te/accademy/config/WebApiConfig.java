package com.te.accademy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.te.accademy.webapi.client.api.CaseDistributionControllerApi;
import com.te.accademy.webapi.client.invoker.ApiClient;

@Configuration
public class WebApiConfig {

	@Value("${webApiUrl}")
	private String webApiUrl;

	@Bean
	public CaseDistributionControllerApi testControllerApi() {
		return new CaseDistributionControllerApi(webApiClient());
	}

	@Bean
	public ApiClient webApiClient() {
		return new ApiClient().setBasePath(webApiUrl);
	}

}


