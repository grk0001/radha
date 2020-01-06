import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/" ;
	  RequestSpecification request = RestAssured.given();
	  
	  Response response = request.request(Method.GET, "/1");
	  
	  String body = response.getBody().asString();
	  System.out.println(" ===>>> "+body);
	  
	  int statusCode = response.getStatusCode();
	  String employee_name = response.jsonPath().getString("employee_name");
	  
	  System.out.println(" -- >> "+employee_name);
	  
	  
	  
  }
}
