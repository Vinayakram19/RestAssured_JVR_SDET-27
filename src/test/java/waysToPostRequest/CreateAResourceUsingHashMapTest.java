package waysToPostRequest;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateAResourceUsingHashMapTest {
	
	@Test
	public void create() {
		
		HashMap map =new HashMap();
		map.put("createdBy","Judo191009");
		map.put("projectName", "APTY190019");
		map.put("status", "Completed");
		map.put("teamSize", 399);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}
}
