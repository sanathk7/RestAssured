package methods;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
public class Create {
	
	/*
	 * public Create() {
	 * 
	 * }
	 */
	 
public int createuser() {
	
	 HashMap<String, Object> data = new HashMap<>(); data.put("name", "Sanath1");
	  data.put("age", "100");
	 
	
	/*  ObjectMapper objectMapper = new ObjectMapper();
      Map<String, Object> data;

      try {
          // Read JSON file into a Map
          data = objectMapper.readValue(new File("C:\\Users\\sakum\\eclipse-workspace\\Maven_Project\\src\\test\\java\\testdata\\user_details.json"), Map.class);
      } catch (IOException e) {
          throw new RuntimeException("Failed to read JSON file", e);
      }*/
    	int id;
    	id =given()
    			.contentType("application/json")
    			.body(data)
    			.when()
    			.post("https://reqres.in/api/users")
    			.then()
.statusCode(201)
.log().all()
.extract()
.jsonPath().getInt("id");

    	System.out.println("Created User ID: " + id);
    	System.out.println(1);
    	return id;
}
}
