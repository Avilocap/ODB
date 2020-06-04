package org.springframework.samples.oculusdb;

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

import java.io.*;
import java.util.*;

public class GetInfoOfAppTests {

	public static void main(String[] args) throws IOException, JSONException {

		getInfoOfOneApplication("2683538418374043");

	}

	public static void getInfoOfOneApplication(String gameId) throws IOException, JSONException {

		String[] positiveWords = getPositiveWords();
		Trie trie = Trie.builder().onlyWholeWords().addKeywords(positiveWords).build();

		String apiUrl = "https://graph.oculus.com/graphql?forced_locale=en_EN";
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(apiUrl);
		String variableChain = "{\"itemId\":\"" + gameId
				+ "\",\"first\":5,\"last\":null,\"after\":null,\"before\":null,\"forward\":true,\"ordering\":null,\"ratingScores\":null,\"hmdType\":\"RIFT\"}";

		List<NameValuePair> params = new ArrayList<>(3);
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

				// Comment Data
				JSONObject firstQualityRatings = node.getJSONObject("firstQualityRatings");

				JSONArray edges = firstQualityRatings.getJSONArray("edges");
				Map<String, Integer> positiveWordsCount = new HashMap<>();

				// First page reviews
				int i;
				for (i = 0; i < edges.length(); i++) {
					JSONObject review = edges.getJSONObject(i);
					JSONObject reviewNode = review.getJSONObject("node");

					String reviewTitle = reviewNode.getString("reviewTitle");
					String reviewDesc = reviewNode.getString("reviewDescription");

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
						boolean contains = Arrays.toString(emits.toArray()).contains(word);
						if (!contains) {
							break;
						}
					}
				}
			}
		}
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
		}
		finally {
			try {
				is.close();
			}
			catch (IOException e) {
			}
		}
		return sb.toString();
	}

	private static String[] getPositiveWords() throws IOException {
		List<String> items = new ArrayList<>();

		FileInputStream fileInputStream = new FileInputStream(
				"src\\main\\java\\org\\springframework\\samples\\oculusdb\\positiveWords.txt");
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(dataInputStream));
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
