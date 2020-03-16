package org.springframework.samples.oculusdb.administrator;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.samples.oculusdb.model.Application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

	@Test
	void jsonReaderWithValidJSON() throws IOException {

		// read json String
		String jsonData = "{ \"oculusId\": \"4623553\", \"name\": \"miguelito en busca del arca perdida\", \"description\": \"dafoasdifh,asdjfhlsdhfdlashfkds\", \"company\": \"java\",\"releaseDate\": \"\",\"website\": \"https://miguelito.com\",\"language\": \"en\",\"picture\": \"http://www.pics.com/pic1.png\",\"typeOfGameplay\": \"MULTIPLAYER\",\"salesEstimation\": 200000,\"platform\": \"\",\"category\": \"\" }";
		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

		// convert json string to object
		Application parsedApp = objectMapper.readValue(jsonData, Application.class);

		System.out.println("Application Object\n" + parsedApp);
	}

	@Test
	void jsonReaderWithInvalidCategoryAtJSON() {

		// read json String
		String jsonData = "{ \"oculusId\": \"4623553\", \"name\": \"miguelito en busca del arca perdida\", \"description\": \"dafoasdifh,asdjfhlsdhfdlashfkds\", \"company\": \"java\",\"releaseDate\": \"\",\"website\": \"https://miguelito.com\",\"language\": \"en\",\"picture\": \"http://www.pics.com/pic1.png\",\"typeOfGameplay\": \"MULTIPLAYER\",\"salesEstimation\": 200000,\"platform\": \"\",\"category\": \"ACCION\" }";
		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

		// convert json string to object
		Assertions.assertThrows(MismatchedInputException.class, () -> {
			Application parsedApp = objectMapper.readValue(jsonData, Application.class);
			System.out.println("Application Object\n" + parsedApp);
		});

	}

	@Test
	void jsonReaderWithInvalidJSON() {

		// read json String
		String jsonData = "{ \"oculusId\": \"4623553\", \"name\": \"miguelito en busca del arca perdida\", \"description\": \"dafoasdifh,asdjfhlsdhfdlashfkds\", \"company\": \"java\",\"releaseDate\": \"\",\"website\": \"https://miguelito.com\",\"language\": \"en\",\"picture\": \"http://www.pics.com/pic1.png\",\"typeOfGameplay\": \"MULTIPLAYER\",\"salesEstimation\": 200000,\"platform\": \"PSP\",\"category\": \"\" }";
		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

		// convert json string to object
		Assertions.assertThrows(MismatchedInputException.class, () -> {
			Application parsedApp = objectMapper.readValue(jsonData, Application.class);
			System.out.println("Application Object\n" + parsedApp);
		});

	}

	@Test
	void jsonReaderWithEmptyJSON() throws IOException {

		// read json String
		String jsonData = "{}";
		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

		// convert json string to object
		Application parsedApp = objectMapper.readValue(jsonData, Application.class);

		System.out.println("Application Object\n" + parsedApp);

	}

}