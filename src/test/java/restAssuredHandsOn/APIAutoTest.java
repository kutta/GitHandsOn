package restAssuredHandsOn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.json.JSONObject;

public class APIAutoTest {

	static CloseableHttpResponse httpResponse;

	@Test
	public void testGetAPI() throws IOException {

		String baseURI = "http://avtmgw.iot1.shared.eu-west-1.qa.aws.vgthosting.net:42680/avtmgw/dashboarddata/status?status=NON_COMM";
		try {

			
			/*
			 * Response req = (Response) with().log().all() .given().header("Content-Type",
			 * "application/json") .header("Accept", "application/json")
			 * .header("Authorization",
			 * "Bearer 87dd28f0-cc7e-4044-91ad-3af16606c0fc").when() .get(baseURI +
			 * "/dashboarddata/status?status=NON_COMM") .then() .header("Content-Type",
			 * "application/json") .assertThat() .statusCode(200) .extract();
			 * 
			 * String body = req.getBody().toString(); System.out.println("Body : "+body);
			 */
			 

			/*
			 * Response resp = null; String respBody = null; CloseableHttpResponse
			 * closeableHttpResponse = null; RestAssured.baseURI = baseURI;
			 * RequestSpecification request = RestAssured.given();
			 * request.header("content-type", "application/json");
			 * request.header("Authorization",
			 * "Bearer 87dd28f0-cc7e-4044-91ad-3af16606c0fc"); resp = get(baseURI +
			 * "/dashboarddata/status?status=NON_COMM");
			 */

			HashMap<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");
			headerMap.put("Authorization", "Bearer 8f0e62e6-b391-4416-90a7-88574ff64582");

			APIAutoTest.get(baseURI, headerMap);

			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status code is :" + statusCode);

			String responseBody = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			JSONObject jsonbody = new JSONObject(responseBody);
			System.out.println("Response is : " + jsonbody);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 1. GET Method without Headers:
	public static CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		httpResponse = httpClient.execute(httpget); // hit the GET URL

		return httpResponse;

	}

	// 2. GET Method with Headers:
	public static CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request

		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		httpResponse = httpClient.execute(httpget); // hit the GET URL
		return httpResponse;

	}

	// 3. POST Method:
	public static CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url); // http post request
		httppost.setEntity(new StringEntity(entityString)); // for payload

		// for headers:
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}

		httpResponse = httpClient.execute(httppost);
		return httpResponse;

	}

}
