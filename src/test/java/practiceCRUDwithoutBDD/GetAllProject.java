package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject {

	
	@Test
	
	public void getAllprojects() {
		
		
		//Step 1
		int expstatus =200;
		Response rep = RestAssured.get("http://localhost:8084/projects");
		
		
		//Step 2
		System.out.println(rep.prettyPeek());
		int actstatus = rep.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		
	}
}
