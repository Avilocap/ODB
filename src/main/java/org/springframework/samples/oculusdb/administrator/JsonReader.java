package org.springframework.samples.oculusdb.administrator;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.samples.oculusdb.model.Application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

	private static ApplicationRepository applications;

	public static void main(String[] args) throws IOException {

		// read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/tempFiles/", "apps.json"));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

		// convert json string to object
		Application parsedApp = objectMapper.readValue(jsonData, Application.class);

		System.out.println("Application Object\n" + parsedApp);

		// applications.save(parsedApp);

	}

}
