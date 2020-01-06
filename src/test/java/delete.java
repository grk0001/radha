import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class delete {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/delete" ;
	  RequestSpecification request = RestAssured.given();
	  
	  Response response = request.request(Method.DELETE, "/1");
	  
	  String body = response.getBody().asString();
	  System.out.println(" ===>>> "+body);
	  
	  int statusCode = response.getStatusCode();
	  String employee_name = response.jsonPath().getString("employee_name");
	  
	 
  }
}
