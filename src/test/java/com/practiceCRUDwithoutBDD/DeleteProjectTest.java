package com.practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {

	
	@Test
	public void deleteproject(){
		
		
		int expstatus =204;
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_411");
		
		
		//step 2
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		System.out.println(resp.prettyPrint());
		
	}
}
