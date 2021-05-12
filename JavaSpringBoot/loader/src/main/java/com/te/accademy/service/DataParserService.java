package com.te.accademy.service;

import java.io.InputStream;

import com.te.accademy.data.Data;

public interface DataParserService {

	Data parseData(InputStream is, String user, String fileName, String parserConfigurationFileJson);

	Data parseData(InputStream is, String user, String fileName);

}