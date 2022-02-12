package com.paramaters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {

	@Test
	public void queryperameter() {
		given()
		.queryParam("page", "2")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.assertThat()
		.log().all();
	}
	
}
