package GenericUtility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIclass {
	
	public DataBaseUtility dlib =new DataBaseUtility();
	public JavaUtillity jlib = new JavaUtillity();
	public RestAssuredUtility rlib =new RestAssuredUtility();
	
	@BeforeSuite
	public void bsconfig() throws Throwable {
		
		baseURI = "http://localhost";
		port= 8084;
		dlib.connectDb();
		System.out.println("========database connection established========");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		
		dlib.closeDB();
		System.out.println("==========database connection closed============");
	}
}
