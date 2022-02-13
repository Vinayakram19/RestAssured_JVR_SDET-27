package com.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2Test {

	
	@Test
	public void oauth() {
		
		Response response = given()
		.formParams("client_id", "SDET_27_TESTING")
		.formParams("client_secret","4cc63a4db601992695023cc1cebb2692")
		.formParams("grant_type", "client_credentials ")
		.formParams("redirect_uri", "https://example.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		String token = response.jsonPath().get("access_token");
				
				given()
				.auth().oauth2(token)
		        .pathParam("USER_ID", "2792")
		        
		        .when()
		        .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		        .then()
		        .log().all();
	}
}
