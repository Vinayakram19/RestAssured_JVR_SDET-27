package practiceCRUDwithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteResourceTest {

	
	@Test
	public void deleteresource() {
		
		
		when()
		  .delete("http://localhost:8084/projects/TY_PROJ_005")
       .then()
       .assertThat()
       .log().all();
	}
}
