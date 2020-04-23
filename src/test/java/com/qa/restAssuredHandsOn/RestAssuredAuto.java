package com.qa.restAssuredHandsOn;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javaparser.utils.Log;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record.ForDefinedMethod.WithAnnotationDefaultValue;

import static org.hamcrest.Matchers.*;

public class RestAssuredAuto {
	
	static Response response = null;
	static JsonPath jsonpath = null;
	String token ;
	
	final static Logger Log = Logger.getLogger(RestAssuredAuto.class.getName());
	
	@Test(priority = 2)
	public void GET_RestAssuredAutoTest() throws IOException{
		
		try {
			
			String baseURIGet = "http://avtmgw.iot1.shared.eu-west-1.qa.aws.vgthosting.net:42680/avtmgw/dashboarddata/status";
			
			/*
			 * RestAssured.baseURI =
			 * "http://avtmgw.iot1.shared.eu-west-1.qa.aws.vgthosting.net:42680/avtmgw/dashboarddata/status?status=NON_COMM";
			 * 
			 * RequestSpecification httprequest = RestAssured.given();
			 * httprequest.header("content-type","application/json");
			 * httprequest.header("Authorization",
			 * "Bearer 8f0e62e6-b391-4416-90a7-88574ff64582"); Response httpresponse =
			 * httprequest.request(Method.GET);
			 * 
			 * String responsebody = httpresponse.getBody().asString();
			 * 
			 * System.out.println("Body --> " + responsebody);
			 * 
			 * int statuscode = httpresponse.getStatusCode();
			 * Assert.assertEquals(statuscode, 200);
			 */
			
			response = with().log().all().given()
			.header("content-type","application/json")
			.header("Authorization","Bearer "+token)
			.queryParam("status", "NON_COMM")
			.when()
			.get(baseURIGet)
			.then()
			.assertThat()
					/* .statusCode(200) */
			.extract()
			.response();
			
			int responsecode = response.getStatusCode();
			Assert.assertEquals(responsecode, 200);
			
			String body = response.getBody().asString();
			Log.info("Dashboard Response Body --> "+body);
			
			  String custname = response.path("customerName").toString();
			/* System.out.println("Customer Name --> "+custname); */
			  Log.info("Customer name -->" + custname);
			  
			  String activeVehicles = response.path("activeVehicles").toString();
			/* System.out.println("Active vehicles --> "+activeVehicles); */
			  Log.info("Active Vehicles -->" + activeVehicles);
			 
			String featurelist = response.path("featureList").toString();
			Log.info("Feature List --> " + featurelist);
			
		}catch(Exception e) {
			
		}
	}
	
	@Test(priority = 1)
	public void POST_RestAssuredAutoTest() throws IOException{
		try {
			String baseURIPost = "http://avtmgw.iot1.shared.eu-west-1.qa.aws.vgthosting.net:42680/avtmgw/Eicher";
			response = with().log().all().given()
					.header("Accept","application/json")
					.contentType("multipart/form-data")
					.multiPart("loginData","{\"userId\":\"koushic.kannan@consultant.volvo.com\",\"password\":\"suptool@123\"}")
					.when()
					.post(baseURIPost)
					.then()
					.assertThat()
					/* .statusCode(200) */
					.extract()
					.response();
			
			int responsecode = response.getStatusCode();
			Assert.assertEquals(responsecode, 200);
			
			String body = response.getBody().asString();
			Log.info("Login Response --> "+body);
			
			/*
			 * jsonpath = response.jsonPath(); token = jsonpath.getString("token");
			 * System.out.println("Token --> "+ token);
			 */
		    token = response.path("token").toString();
			Log.info("Mobile token --> "+ token);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
