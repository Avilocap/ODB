package org.springframework.samples.oculusdb;

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
import org.springframework.samples.oculusdb.model.Application;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetInfoOfAppTests {

    public static void main(String[] args) throws IOException, JSONException {

        getInfoOfOneApplication("1961361990541898");

    }

    public static void getInfoOfOneApplication(String game_id) throws IOException, JSONException {

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

                //Comment Data
                JSONObject firstQualityRatings = node.getJSONObject("firstQualityRatings");
                JSONObject pageInfo = firstQualityRatings.getJSONObject("page_info");


                //Cursors to get the second page:
                String end_cursor = pageInfo.getString("end_cursor");
                String start_cursor = pageInfo.getString("start_cursor");

                JSONArray edges = firstQualityRatings.getJSONArray("edges");

                //First page reviews
                int i;
                for(i=0; i < edges.length(); i++){
                    JSONObject review = edges.getJSONObject(i);
                    JSONObject review_node = review.getJSONObject("node");

                    String reviewTitle = review_node.getString("reviewTitle");
                    String reviewDesc = review_node.getString("reviewDescription");

                }


                Boolean more_comments = false;
                if(!end_cursor.equals("")){
                 more_comments = true;
                }

                while (more_comments){

                    HttpPost reviewHttppost = new HttpPost(API_URL);
                    String reviewVariableChain = "{\"id\":\""+game_id+"\",\"first\":5,\"last\":null,\"after\":\""+end_cursor+"\",\"before\":null,\"forward\":true,\"ordering\":\"top\",\"ratingScores\":[1,2,3,4,5]}";

                    List<NameValuePair> reviewParams = new ArrayList<NameValuePair>(3);
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

                            //Comment Data
                            JSONObject reviewFirstQualityRatings = reviewNode.getJSONObject("firstQualityRatings");
                            JSONObject reviewPageInfo = reviewFirstQualityRatings.getJSONObject("page_info");


                            //Cursors to get the second page:
                            String reviewEndCursor = reviewPageInfo.getString("end_cursor");
                            String reviewStartCursor = reviewPageInfo.getString("start_cursor");

                            if(reviewEndCursor.equals("null")){
                                more_comments = false;
                                break;
                            }

                            JSONArray reviewEdges = firstQualityRatings.getJSONArray("edges");

                            //First page reviews
                            int ri;
                            for(ri=0; ri < reviewEdges.length(); ri++){
                                JSONObject Rreview = reviewEdges.getJSONObject(ri);
                                JSONObject Rreview_node = Rreview.getJSONObject("node");

                                String reviewTitle = Rreview_node.getString("reviewTitle");
                                String reviewDesc = Rreview_node.getString("reviewDescription");

                                System.out.println("Title: " + reviewTitle);
                                System.out.println("Description: " + reviewDesc);

                            }

                            end_cursor = reviewEndCursor;

                        }
                    }
                }

            }
        }
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
