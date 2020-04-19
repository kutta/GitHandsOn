package restAssuredHandsOn;

import java.io.IOException;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIAutoTest {

	@Test
	public void testAPI() throws IOException{
		
		 
		 String baseURI = "http://ergast.com/api/f1/2017/circuits.json";
		try {
			
			
			given()
			.when()
			.get(baseURI)
			.then()
			.assertThat()
			.statusCode(200)
			
			.and()
			.body("MRData.CircuitTable.Circuits.circuitId", hasSize(21))
			
			.and()
			.header("content-length", equalTo(4552));
			
			
			
			
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
