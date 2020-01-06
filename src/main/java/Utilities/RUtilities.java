package Utilities;

import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RUtilities {
	Logger logger = Logger.getLogger(RUtilities.class.getName());
	
	public Response fireGetRequest(String url, Method method, String urlParameters) {
		logger.info(" ===  Get request fired with url "+url+" urlParameters "+urlParameters);
		 RestAssured.baseURI = url ;
		 RequestSpecification request = RestAssured.given();
		 return request.request(method, urlParameters);
	}
	
	public Response firePostRequest(String url, Method method, String urlParameters, HashMap<String,String> headers,String payload ) {
		logger.info(" ===  Post request fired with url "+url+" urlParameters "+urlParameters );
		RestAssured.baseURI = url ;
		  RequestSpecification request = RestAssured.given();
		  if(headers.size()!=0) {
			  Set keys1 = headers.keySet();
			  for(Object key : keys1) {
				  request.headers(key.toString(),headers.get(key.toString()));
				  logger.info("  post request headers key "+key.toString()+" :: value "+headers.get(key.toString()));
			  }
		  }
		  request.body(payload);
		  logger.info("  post request body "+payload);
		  return request.request(method,urlParameters);
	

	}
	
	public Response fireDeleteRequest(String url, Method method, String urlParameters) {
		logger.info(" ===  delete request fired with url "+url+" urlParameters "+urlParameters);
		  RestAssured.baseURI = url ;
		  RequestSpecification request = RestAssured.given();
		  return request.request(method, urlParameters);
	}
	
	public int getStatusCode(Response response) {
		  return response.getStatusCode();
	}

	public String getKeyValueBasedValue(Response response,String key) {
		return response.jsonPath().getString(key);
	}
}
