package com.RMGYantraTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIclass;
import GenericUtility.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import pojoLibrary.pojoclass;

public class CreateResourceAndVerifyInDatabase extends BaseAPIclass {
	
	@Test
	public void createResourceAndVerifyInDb() throws Throwable  {
		
		//Step 1: create test data
		pojoclass plib = new pojoclass("vinayak1919", "NyKa"+jlib.getRandomNumber(), "completed",45);
	  
		//step 2: execute post request
		Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		.when()
		.post(Endpoints.createProject);
		
		//step 3: capture the project id from response
		
		String expData = rlib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		//step 4: verify the database
		
		String query ="select* from project;";
		String actData= dlib.executequeryAndgetData(query, 1, expData);
		Reporter.log(actData,true);
		
		//step 5: validate
		
		Assert.assertEquals(expData, actData);
	  Reporter.log("data verification successful", true);
	
	
	}
	

}
