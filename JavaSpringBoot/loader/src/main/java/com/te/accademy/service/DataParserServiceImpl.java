package com.te.accademy.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.te.accademy.data.Data;
import com.te.accademy.data.parse.DataParser;
import com.te.accademy.data.parse.configuration.ParserConfiguration;

@Service
public class DataParserServiceImpl implements DataParserService {

	static Logger log = LogManager.getLogger();

	@Value("${default.parser.path:/}")
	String defaultParserPath;

	@Value("${default.parser.configuration:default.json}")
	String defaultParser;

	@Autowired
	DataParser parser;

	@Override
	public Data parseData(InputStream is, String user, String fileName, String parserConfigurationFileJson) {
		try {
//			DataParser parser= (DataParser)applicationContext.getBean(DataParser.class);
//			DataParser parser2= (DataParser)applicationContext.getBean(DataParser.class);
			ParserConfiguration parserConf = new ParserConfiguration(getFileConf(parserConfigurationFileJson));
			parser.setUser(user);
			parser.setParserConfiguration(parserConf);
			return parser.parse(fileName, is);

		} catch (Exception e) {
			log.error("Error in parseData", e);
		}

		return null;
	}

	@Override
	public Data parseData(InputStream is, String user, String fileName) {
		return parseData(is, user, fileName, defaultParserPath + defaultParser);
	}

	private String getFileConf(String fullPath) throws IOException {
		return Files.readString(Path.of(fullPath));
	}
}
