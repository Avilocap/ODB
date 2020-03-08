package org.springframework.samples.oculusdb.administrator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

	public static void main(String[] args) throws IOException {

		// read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/tempFiles/", "apps.json"));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		Application2 parsedApp = objectMapper.readValue(jsonData, Application2.class);

		System.out.println("Application Object\n" + parsedApp);

	}

}