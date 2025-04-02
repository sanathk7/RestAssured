package methods;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class Update {
	  public int updateUser(int id) {
	        HashMap<String, Object> data = new HashMap<>();
	        data.put("name", "sachin");
	        data.put("age", "1000");
	    	given()
	    			.contentType("application/json")
	    			.body(data)
	    		.when()
	    			.put("https://reqres.in/api/users/"+id)
	    		.then()
	    			.statusCode(200)
	    			.log().all();
	    	System.out.println("User  ID: " + id);
	    	System.out.println(3);
	    	return id;
	    }
}
