package methods;

import static io.restassured.RestAssured.given;

public class Delete {
public void deleteUser(int id) {
given()
.when()
.delete("https://reqres.in/api/users/"+id)
.then()
.statusCode(204)
.log().all();
System.out.println(5);

}
}
