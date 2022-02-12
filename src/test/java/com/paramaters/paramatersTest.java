package com.paramaters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class paramatersTest {

	@Test
	public void paramaterstest() {
		
		given()
		.pathParam( "username", "raja")
		.queryParam("sort", "updated")
		.queryParam("per_page", "100")
		
		.when()
		.get("https://github.com/users/{username}/repos")
		
		.then()
		.assertThat()
		.log().all();
		
		
		
	}
	
}


