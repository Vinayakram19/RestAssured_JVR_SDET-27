package waysToPostRequest;
import static  io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import pojoLibrary.pojoclass;
import io.restassured.http.ContentType;

public class CreateAResourseUsingPojoTest {
	
	@Test
	public void create() {
		pojoclass pojo = new pojoclass("Vignesh", "SDET-19", "completed", 300);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		     .post("http://localhost:8084/addProject")
		.then()
		     .assertThat().statusCode(201)
		     .contentType(ContentType.JSON)
		     .log().all();
		
		
	}

}
