package methods;

import static io.restassured.RestAssured.given;

public class Get {
	   public void getUsers() {
	        given()
	        .when()
	        .get("https://reqres.in/api/users/3")
	        .then()
	        .statusCode(200)
	        .log().all();
	        System.out.println(2);
	    }
}