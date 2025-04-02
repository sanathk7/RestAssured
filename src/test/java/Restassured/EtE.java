package Restassured;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import methods.Create;
import methods.Delete;
import methods.Get;
import methods.Update;

public class EtE {
int id;

/*
 * static ExtentReports extent; static ExtentTest test; static
 * ExtentSparkReporter sparkReporter;
 */

private static ExtentReports extent;
private static ExtentTest test;

@BeforeSuite
public void setUpReport() {
	
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\sakum\\eclipse-workspace\\Maven_Project\\test-output\\ExtentReport.html");
   
    extent = new ExtentReports();
    extent.attachReporter(sparkReporter);
    
  
    extent.setSystemInfo("OS", System.getProperty("os.name"));
    extent.setSystemInfo("Tester", "Sanath Kumar");

    
}



@Test(priority=1) 
void createUser() {
	//ExtentReports extent = null;
	/*
	 * HashMap<String, Object> data = new HashMap<>(); data.put("name", "Sanath1");
	 * data.put("age", "100");
	 * 
	 * id =given() .contentType("application/json") .body(data) .when()
	 * .post("https://reqres.in/api/users") .jsonPath().getInt("id");
	 * System.out.println("Created User ID: " + id); System.out.println(1);
	 */
    test = extent.createTest("Create User", "Tests the creation of a user");
    Create create=new Create();
	id=create.createuser();
    test.pass("User created successfully. User ID: " + id);
}






    @Test(priority=2)
    void GetUsers() {
		/*
		 * given() .when() .get("https://reqres.in/api/users/3") .then()
		 * .statusCode(200) .log().all(); System.out.println(2);
		 */
    	Get get=new Get();
    	get.getUsers();
    }
    
    
    
    
    @Test(priority=3)
    void updateUser() {
		/*
		 * HashMap<String, Object> data = new HashMap<>(); data.put("name", "sachin1");
		 * data.put("age", "1000"); given() .contentType("application/json") .body(data)
		 * .when() .put("https://reqres.in/api/users/"+id) .then() .statusCode(200)
		 * .log().all(); System.out.println("User  ID: " + id); System.out.println(3);
		 */
    	test = extent.createTest("Update User", "Tests updating user details");
    	
    	Update update=new Update();
    	update.updateUser(id);
    	
    	test.pass("User Updated successfully. User ID: " + id);
    }

	/*
	 * @Test(priority=4) void GetUsers1() { given() .when()
	 * .get("https://reqres.in/api/users/3") .then() .statusCode(200) .log().all();
	 * System.out.println(4); }
	 */
    
    
    
  
    
    
    @Test(priority=4)
void deleteUser() {
	/*
	 * given() .when() .delete("https://reqres.in/api/users/"+id) .then()
	 * .statusCode(204) .log().all(); System.out.println(5);
	 */
    	Delete delete=new Delete();
    	delete.deleteUser(id);
    }
    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush(); 
            System.out.println("Extent Report generated successfully!");
        }
    }   
}