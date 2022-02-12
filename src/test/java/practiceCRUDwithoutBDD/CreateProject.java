package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	
	@Test
	public void createproject() {
		//Step 1:  create data
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","Judo1");
		jobj.put("projectName", "APTY1");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 30);
		
		//Step 2: provide Request Specification
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);

		
		//Step3;perform the action
		Response resp = req.post("http://localhost:8084/addProject");
		
		
		//step 4: print in console and verify
		System.out.println(resp.asString());// Prints entire mgs in one line  as String 
		System.out.println(resp.prettyPrint());//prints output in the form of json
		System.out.println(resp.prettyPeek());//Indetailed Print with date,connection
		System.out.println(resp.getContentType());//print type of content (app/json)
		System.out.println(resp.getStatusCode());//print current statuscode 
		
		
	}

}
