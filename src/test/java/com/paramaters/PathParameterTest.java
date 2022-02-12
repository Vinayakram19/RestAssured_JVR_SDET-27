package com.paramaters;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class PathParameterTest {
	
	@Test
	
	public void pathparameter() {
		
		given()
		.pathParam("projectID", "TY_PROJ_1003")
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat()
		.log().all();
	}

}
