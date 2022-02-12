package com.requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTest {

	
	@Test
	
		public void requestChaining() {
          Response response = when()
           .get("http://localhost:8084/projects");
          String proId = response.jsonPath().get("[6].projectId");
          
          
          given()
          .pathParam("projectId", proId)
          .when()
          .delete("http://localhost:8084/projects/{projectId}")
          .then()
          .assertThat()
          .contentType(ContentType.JSON)
          .log().all();
          
			
		}
	}

