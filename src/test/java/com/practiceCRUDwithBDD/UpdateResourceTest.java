package com.practiceCRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateResourceTest {

	@Test
	public void update() {
		

		
		//create of random number
		Random ran =new Random();
		int randomnumber = ran.nextInt(500);
		
		JSONObject jobj=new JSONObject();//json simple dependency
		jobj.put("createdBy","SENTHIL");
		jobj.put("projectName", "APTY143");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 3077);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_804")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();		
	}
}
