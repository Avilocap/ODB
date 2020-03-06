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
		byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/tempFiles/", "applications.json"));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		Application2 emp = objectMapper.readValue(jsonData, Application2.class);

		System.out.println("Application Object\n" + emp);

		// convert Object to json string
		Application2 application1 = createApplication();
		// configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// writing to console, can write to any output stream such as file
		StringWriter stringApp = new StringWriter();
		objectMapper.writeValue(stringApp, application1);
		System.out.println("App JSON is\n" + stringApp);
	}

	public static Application2 createApplication() {

		Application2 application = new Application2();
		application.setName("David");

		return application;
	}

}
