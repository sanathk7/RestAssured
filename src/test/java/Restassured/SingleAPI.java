package Restassured;

import org.testng.annotations.Test;

import methods.Get;

public class SingleAPI {
	  @Test(priority=1)
	    void GetUsers() {
			/*
			 * given() .when() .get("https://reqres.in/api/users/3") .then()
			 * .statusCode(200) .log().all(); System.out.println(2);
			 */
	    	Get get=new Get();
	    	get.getUsers();
	    }
}
