package com.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTockenTest {

	@Test
	public void bearertoken() {
		
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
