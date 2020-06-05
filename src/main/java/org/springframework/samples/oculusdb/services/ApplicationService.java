package org.springframework.samples.oculusdb.services;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.administrator.ApplicationRepository;
import org.springframework.samples.oculusdb.application.Reviews;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.Word;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

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
	public Collection<Word> getPositiveWords(Application application) {
		return this.applicationRepository.getApplicationPositiveWord(application.getOculusId());
	}

	public Collection<Word> getNegativeWords(Application application) {
		return this.applicationRepository.getApplicationNegativeWord(application.getOculusId());
	}

	@Transactional
	public boolean applicationExists(String oculusID) {
		boolean res = false;

		if (applicationRepository.applicationByOculusId(oculusID) != null) {
			res = true;
		}

		return res;
	}

	@Transactional
	public boolean favoriteExists(int appId, int userId) {
		boolean res = false;

		if (applicationRepository.applicationOfUserById(appId, userId) != null) {
			res = true;
		}
		return res;
	}

	@Transactional
	public Application getInfoOfOneApplication(String game_id) throws IOException, JSONException {

		Application res = new Application();

		// Build front page query
		String apiUrl = "https://graph.oculus.com/graphql?forced_locale=en_EN";
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(apiUrl);
		String variableChain = "{\"itemId\":\"" + game_id
				+ "\",\"first\":5,\"last\":null,\"after\":null,\"before\":null,\"forward\":true,\"ordering\":null,\"ratingScores\":null,\"hmdType\":\"RIFT\"}";

		List<NameValuePair> params = new ArrayList<>(3);
		params.add(new BasicNameValuePair("access_token", "OC|1317831034909742|"));
		params.add(new BasicNameValuePair("variables", variableChain));
		params.add(new BasicNameValuePair("doc_id", "2626024984114321"));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		// Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		// Get the general info about the game
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
				int releaseDateInteger = node.getInt("release_date");
				Timestamp timestamp = new Timestamp(releaseDateInteger);
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
				app2.setReviewsCollection(new ArrayList<>());
				app2.setPositiveWords(new ArrayList<>());
				app2.setNegativeWords(new ArrayList<>());

				// ****************************** REVIEW EXTRACTION
				// **********************************************

				String[] positiveWords = getPositiveWords();
				Trie trie = Trie.builder().onlyWholeWords().addKeywords(positiveWords).build();

				String[] negativeWords = getNegativeWords();
				Trie trien = Trie.builder().onlyWholeWords().addKeywords(negativeWords).build();

				// Comment Data
				JSONObject firstQualityRatings = node.getJSONObject("firstQualityRatings");
				JSONObject pageInfo = firstQualityRatings.getJSONObject("page_info");

				// Cursors to get the second page:
				String endCursor = pageInfo.getString("end_cursor");

				JSONArray edges = firstQualityRatings.getJSONArray("edges");

				Map<String, Integer> positiveWordsCount = new HashMap<>();
				Map<String, Integer> negativeWordsCount = new HashMap<>();

				// First page reviews
				int i;
				for (i = 0; i < edges.length(); i++) {
					JSONObject review = edges.getJSONObject(i);
					JSONObject review_node = review.getJSONObject("node");

					String reviewTitle = review_node.getString("reviewTitle");
					String reviewDesc = review_node.getString("reviewDescription");

					int reviewDate = review_node.getInt("date");
					Timestamp reviewTimestamp = new Timestamp((long) reviewDate);
					LocalDate reviewReleaseDate = reviewTimestamp.toLocalDateTime().toLocalDate();

					String reviewOculusID = review_node.getString("id");

					// Word search Algorithm

					// For positive words
					Collection<Emit> emits = trie.parseText(reviewTitle + reviewDesc);

					for (Emit em : emits) {
						String[] emsplited = em.toString().split("=");
						String ourWord = emsplited[1];
						if (positiveWordsCount.containsKey(ourWord)) {
							positiveWordsCount.put(ourWord, positiveWordsCount.get(ourWord) + 1);
						}
						else {
							positiveWordsCount.put(ourWord, 1);
						}

					}

					for (String word : positiveWords) {
						boolean containsPositive = Arrays.toString(emits.toArray()).contains(word);
						if (!containsPositive) {
							break;
						}
					}

					// For negative words
					Collection<Emit> emitsn = trien.parseText(reviewTitle + reviewDesc);

					for (Emit em : emitsn) {
						String[] emsplited = em.toString().split("=");
						String ourWord = emsplited[1];
						if (negativeWordsCount.containsKey(ourWord)) {
							negativeWordsCount.put(ourWord, negativeWordsCount.get(ourWord) + 1);
						}
						else {
							negativeWordsCount.put(ourWord, 1);
						}

					}

					for (String word : negativeWords) {
						boolean containsNegative = Arrays.toString(emitsn.toArray()).contains(word);
						if (!containsNegative) {
							break;
						}
					}

					Reviews currentReviewObject = new Reviews();
					currentReviewObject.setContent(reviewDesc);
					currentReviewObject.setTitle(reviewTitle);
					currentReviewObject.setPublishDate(reviewReleaseDate);
					currentReviewObject.setOculusId(reviewOculusID);

					currentReviewObject.setApplication(app2);
					app2.getReviewsCollection().add(currentReviewObject);

				}

				// Check if there is more comment pages
				boolean moreComments = false;
				if (!endCursor.equals("")) {
					moreComments = true;
				}

				while (moreComments) {

					// Build query for next comment page. using previous end cursor
					HttpPost reviewHttppost = new HttpPost(apiUrl);
					String reviewVariableChain = "{\"id\":\"" + game_id + "\",\"first\":5,\"last\":null,\"after\":\""
							+ endCursor
							+ "\",\"before\":null,\"forward\":true,\"ordering\":\"top\",\"ratingScores\":[1,2,3,4,5]}";

					List<NameValuePair> reviewParams = new ArrayList<>(3);
					reviewParams.add(new BasicNameValuePair("access_token", "OC|1317831034909742|"));
					reviewParams.add(new BasicNameValuePair("variables", reviewVariableChain));
					reviewParams.add(new BasicNameValuePair("doc_id", "1494813307288657"));
					reviewHttppost.setEntity(new UrlEncodedFormEntity(reviewParams, "UTF-8"));

					// Execute and get the response.
					HttpResponse reviewResponse = httpclient.execute(reviewHttppost);
					HttpEntity reviewEntity = reviewResponse.getEntity();

					if (reviewEntity != null) {
						try (InputStream reviewInstream = reviewEntity.getContent()) {
							String reviewResult = convertStreamToString(reviewInstream);
							JSONObject reviewRawJson = new JSONObject(reviewResult);
							JSONObject reviewData = reviewRawJson.getJSONObject("data");
							JSONObject reviewNode = reviewData.getJSONObject("node");

							// Comment Data
							JSONObject reviewFirstQualityRatings = reviewNode.getJSONObject("firstQualityRatings");
							JSONObject reviewPageInfo = reviewFirstQualityRatings.getJSONObject("page_info");

							// Cursors to get the second page:
							String reviewEndCursor = reviewPageInfo.getString("end_cursor");
							if (reviewEndCursor.equals("null")) {
								break;
							}

							JSONArray reviewEdges = firstQualityRatings.getJSONArray("edges");

							// Get page reviews
							int ri;
							for (ri = 0; ri < reviewEdges.length(); ri++) {
								JSONObject Rreview = reviewEdges.getJSONObject(ri);
								JSONObject Rreview_node = Rreview.getJSONObject("node");

								String RreviewTitle = Rreview_node.getString("reviewTitle");
								String RreviewDesc = Rreview_node.getString("reviewDescription");

								int RreviewDate = Rreview_node.getInt("date");
								Timestamp RreviewTimestamp = new Timestamp(RreviewDate);
								LocalDate RreviewReleaseDate = RreviewTimestamp.toLocalDateTime().toLocalDate();

								String RreviewOculusID = Rreview_node.getString("id");

								// Word search Algorithm

								// For positive words
								Collection<Emit> emitsP = trie.parseText(RreviewTitle + RreviewDesc);

								for (Emit em : emitsP) {
									String[] emsplited = em.toString().split("=");
									String ourWord = emsplited[1];
									if (positiveWordsCount.containsKey(ourWord)) {
										positiveWordsCount.put(ourWord, positiveWordsCount.get(ourWord) + 1);
									}
									else {
										positiveWordsCount.put(ourWord, 1);
									}

								}

								for (String word : positiveWords) {
									boolean containsPositive = Arrays.toString(emitsP.toArray()).contains(word);
									if (!containsPositive) {
										break;
									}
								}

								// For negative words
								Collection<Emit> emitsN = trien.parseText(RreviewTitle + RreviewDesc);

								for (Emit em : emitsN) {
									String[] emsplited = em.toString().split("=");
									String ourWord = emsplited[1];
									if (negativeWordsCount.containsKey(ourWord)) {
										negativeWordsCount.put(ourWord, negativeWordsCount.get(ourWord) + 1);
									}
									else {
										negativeWordsCount.put(ourWord, 1);
									}

								}

								for (String word : negativeWords) {
									boolean containsNegative = Arrays.toString(emitsN.toArray()).contains(word);
									if (!containsNegative) {
										break;
									}
								}

								Reviews currentReviewObject = new Reviews();
								currentReviewObject.setContent(RreviewTitle);
								currentReviewObject.setTitle(RreviewDesc);
								currentReviewObject.setPublishDate(RreviewReleaseDate);
								currentReviewObject.setOculusId(RreviewOculusID);

								currentReviewObject.setApplication(app2);
								app2.getReviewsCollection().add(currentReviewObject);
							}

							endCursor = reviewEndCursor;

						}
					}
				}

				for (String positiveKeyword : positiveWordsCount.keySet()) {
					Word positiveWord = new Word();
					positiveWord.setLetters(positiveKeyword);
					positiveWord.setRepeats(positiveWordsCount.get(positiveKeyword));
					app2.getPositiveWords().add(positiveWord);
				}

				for (String negativeKeyword : negativeWordsCount.keySet()) {
					Word negativeWord = new Word();
					negativeWord.setLetters(negativeKeyword);
					negativeWord.setRepeats(negativeWordsCount.get(negativeKeyword));
					app2.getNegativeWords().add(negativeWord);
				}

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

		String line;
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

	private static String[] getPositiveWords() throws IOException {
		List<String> items = new ArrayList<>();

		FileInputStream fstream_school = new FileInputStream(
				"src\\main\\java\\org\\springframework\\samples\\oculusdb\\positiveWords.txt");
		DataInputStream data_input = new DataInputStream(fstream_school);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
		String strLine;

		while ((strLine = buffer.readLine()) != null) {
			strLine = strLine.trim();
			if ((strLine.length() != 0)) {
				items.add(strLine);
			}

		}
		buffer.close();
		return items.toArray(new String[items.size()]);
	}

	private static String[] getNegativeWords() throws IOException {
		List<String> items = new ArrayList<>();

		FileInputStream fileInputStream = new FileInputStream(
				"src\\main\\java\\org\\springframework\\samples\\oculusdb\\negativeWords.txt");
		DataInputStream data_input = new DataInputStream(fileInputStream);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
		String strLine;

		while ((strLine = buffer.readLine()) != null) {
			strLine = strLine.trim();
			if ((strLine.length() != 0)) {
				items.add(strLine);
			}
		}
		buffer.close();
		return items.toArray(new String[items.size()]);
	}

}
