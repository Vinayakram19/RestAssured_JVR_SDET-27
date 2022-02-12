package Responseverification;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.pojoclass;

import static io.restassured.RestAssured.*;

public class DataproviderTest {

	@Test(dataProvider="getData")
	public void create(String createdBy,String projectName,String status,int teamSize) {
		
	 pojoclass pojo = new pojoclass(createdBy, projectName, status, teamSize);
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
	
	@DataProvider
	public Object[][] getData(){
		
		
		Object[][] objArray=new Object[2][4];
		
		objArray[0][0]="aswathy sis";
		objArray[0][1]="aswathy project tyss";
		objArray[0][2]="completed";
		objArray[0][3]=234;
		
		objArray[1][0]="uma";
		objArray[1][1]="uma project tyss";
		objArray[1][2]="completed";
		objArray[1][3]=402;
		return objArray;
		
	}
	
}
