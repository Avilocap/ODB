package org.springframework.samples.oculusdb.administrator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxRequest {

	private static String API_URL = "https://graph.oculus.com/graphql?forced_locale=en_EN";

	public static void main(String[] args) {
		try {
			getInfoOfOneApplication("1471853306166046");
		}
		catch (IOException e) {
			System.out.println(e);
		}

	}

	private static void getInfoOfOneApplication(String game_id) throws IOException {

		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(API_URL);
		String variableChain = "{\"itemId\":\"" + game_id
				+ "\",\"first\":5,\"last\":null,\"after\":null,\"before\":null,\"forward\":true,\"ordering\":null,\"ratingScores\":null,\"hmdType\":\"RIFT\"}";
		FileWriter file;

		List<NameValuePair> params = new ArrayList<NameValuePair>(3);
		params.add(new BasicNameValuePair("access_token", "OC|1317831034909742|"));
		params.add(new BasicNameValuePair("variables", variableChain));
		params.add(new BasicNameValuePair("doc_id", "2626024984114321"));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		// Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			try (InputStream instream = entity.getContent()) {
				String result = convertStreamToString(instream);
				JSONObject myObject = new JSONObject(result);
				file = new FileWriter("src/main/resources/tempFiles/game.json");
				file.write(result);
				// Constructs a FileWriter given a file name, using the platform's default
				// charset
			}
		}

	}

	private static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
