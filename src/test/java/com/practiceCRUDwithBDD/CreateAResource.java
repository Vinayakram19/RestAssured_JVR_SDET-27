package com.practiceCRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateAResource {
	
	@Test
	
	public void create() {
		
		//create of random number
		Random ran =new Random();
		int randomnumber = ran.nextInt(500);
		
		JSONObject jobj=new JSONObject();//json simple dependency
		jobj.put("createdBy","Judo1");
		jobj.put("projectName", "APTY133");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 30);
		
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
		
}
