import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1" ;
	  RequestSpecification request = RestAssured.given();
	  
	  JSONObject jo = new JSONObject();
	  jo.put("id","1009");
	  jo.put("employee_name","radha");
	  jo.put("employee_salary","100000");
	  jo.put("employee_age", "31");
	  //jo.put("profile_image", "");
	  
	 
	  
	  request.headers("Content-Type", "application/json"); 
	  request.body(jo.toJSONString());
	  Response response = request.request(Method.POST,"/create");
	  
	  String body = response.getBody().asString();
	  System.out.println(" ===>>> "+body);
	  
//	  int statusCode = response.getStatusCode();
//	  String employee_name = response.jsonPath().getString("employee_name");
//	  
//	  System.out.println(" -- >> "+employee_name);
	  
  }
}
