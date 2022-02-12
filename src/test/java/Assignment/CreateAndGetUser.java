package Assignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateAndGetUser {
	
	@Test
	public void createandgetuser() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("designation","SDET-27");
		jobj.put("dob","25/05/1995");
		jobj.put("email","nith@gmail.com");
		jobj.put("empName","nithe");
		jobj.put("experience","19");
		jobj.put("mobileNo","9888777658");
		jobj.put("project","Jio");
		jobj.put("role","ROLE_ADMIN");
		jobj.put("username","Ram19");

		
		//Step 2: provide Request Specification
		Response resp = given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/employees");
		
		resp.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		String empid=resp.jsonPath().get("employeeId");
		System.out.println(empid);
		
		given()
		.pathParam("emplid", empid)
		.when()
		.get("http://localhost:8084/employees/{emplid}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}

}
