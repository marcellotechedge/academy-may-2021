package com.te.accademy.controller;

import java.io.InputStream;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.accademy.config.MessagioRabbit;
import com.te.accademy.data.Data;
import com.te.accademy.service.DataParserService;
import com.te.accademy.service.RabbitService;

@RestController
public class LoaderController {

	static Logger log = LogManager.getLogger();

	@Autowired
	private DataParserService dataParserService;

	@Autowired
	private RabbitService rabbitService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadExcel(@RequestPart MultipartFile file) {
		try {
			InputStream is = file.getInputStream();
			
			Data data = dataParserService.parseData(is, "test", file.getOriginalFilename());
			
			data.setRequestId(UUID.randomUUID().toString());
			data.setUser("");

			rabbitService.sendExcelMessage(data);
			
			return ResponseEntity.ok("Sent");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//	@PostMapping("/test")
//	public String sendTestMessage(@RequestBody MessagioRabbit message) {
//		rabbitService.sendTestMessage(message);
//
//		return "sent";
//	}
}
