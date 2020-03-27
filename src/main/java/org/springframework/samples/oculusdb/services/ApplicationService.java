package org.springframework.samples.oculusdb.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.administrator.ApplicationRepository;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Transactional
	public int applicationCount() {
		return (int) this.applicationRepository.count();
	}

	@Transactional
	public Application saveApplication(Application app) {
		return this.applicationRepository.save(app);
	}

	@Transactional
	public Iterable<Application> findAll() {
		return this.applicationRepository.findAll();
	}

	@Transactional
	public Optional<Application> findApplicationById(int id) {
		return this.applicationRepository.findById(id);
	}

	@Transactional
	public void deleteApplication(Application t) {
		this.applicationRepository.delete(t);
	}

	@Transactional
	public Application getInfoOfOneApplication(String game_id) throws IOException, JSONException {

		Application res = new Application();

		String API_URL = "https://graph.oculus.com/graphql?forced_locale=en_EN";
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
				JSONObject rawJson = new JSONObject(result);
				JSONObject data = rawJson.getJSONObject("data");
				JSONObject node = data.getJSONObject("node");

				// Basic
				String oculusId = node.getString("id");
				String name = node.getString("display_name");
				String description = node.getString("display_long_description");
				String website = node.getString("website_url");
				String company = node.getString("developer_name");

				// Price
				JSONObject currentOffer = node.getJSONObject("current_offer");
				JSONObject priceJson = currentOffer.getJSONObject("price");
				String formatted = priceJson.getString("formatted").substring(1);
				Double price = new Double(formatted);

				// Date
				// TODO esto siempre da 1970
				int releaseDateInteger = node.getInt("release_date");
				Timestamp timestamp = new Timestamp((long) releaseDateInteger);
				LocalDate releaseDate = timestamp.toLocalDateTime().toLocalDate();

				// Picture
				JSONObject hero = node.getJSONObject("hero");
				String picture = hero.getString("uri");

				// Total Reviews
				JSONObject reviewInfo = node.getJSONObject("reviewInfo");
				Integer totalReviews = reviewInfo.getInt("count");

				// Derived Properties
				Integer salesEstimation = salesEstimationCalculator(totalReviews);
				double incomeEstimationDouble = salesEstimation * price;
				Integer incomeEstimation = (int) incomeEstimationDouble;
				Application app2 = new Application(oculusId, name, description, releaseDate, price, website, company,
						picture, incomeEstimation, salesEstimation, totalReviews);
				return this.saveApplication(app2);
			}
		}
		return this.saveApplication(res);
	}

	private static Integer salesEstimationCalculator(Integer reviewCount) {

		int result;

		if (reviewCount == 0) {
			return 0;
		}

		double aux = reviewCount / 0.05;
		result = (int) aux;

		return result;
	}

	private static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
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
