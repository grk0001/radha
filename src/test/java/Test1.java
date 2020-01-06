import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestData.TestData;
import Utilities.RUtilities;
import io.restassured.http.Method;

public class Test1 {

	RUtilities  utilities = new RUtilities();
	@Test
	public void getExample() {
		int statusCode = utilities.getStatusCode(utilities.fireGetRequest(TestData.getReqURL, Method.GET, "/1"));
		Assert.assertEquals(200, 101);
	}
	
	@Test
	public void postExample() {
		HashMap<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("Content-Type", "application/json");
		int statusCode = utilities.getStatusCode(utilities.firePostRequest(TestData.postReqURL, Method.POST, "/create",hashMap,TestData.postReq1));
		Assert.assertEquals(200, 200);
	}
	
	@Test
	public void delete() {
		int statusCode = utilities.getStatusCode(utilities.fireDeleteRequest(TestData.delReqURL, Method.DELETE, "/1"));
		Assert.assertEquals(200, 200);
	}

}
