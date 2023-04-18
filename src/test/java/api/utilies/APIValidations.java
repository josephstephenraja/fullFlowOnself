package api.utilies;

import org.testng.Assert;

import io.restassured.response.Response;

public class APIValidations extends Reports {
	public static void responsecodevalidation(Response response, int statuscode) {
		try {
			Assert.assertEquals(statuscode,  response.getStatusCode());
			testcase.pass("successfully validated status code, status code is ::"+ response.getStatusCode());
		}catch(AssertionError e) {
			testcase.fail("Expected status code is ::"+ statuscode +",instead of getting :: "+ response.getStatusCode());
		}
	}
	public static void responsetimevalidation(Response response) {
		try {
			long responseTime = response.getTime();
	        Assert.assertTrue(responseTime < 5000L);
	        testcase.pass("successfully validated Response time and response time less than 5000 milliseconds");
	        
		}catch(AssertionError e) {
			testcase.fail(" Response time is more than 5000 milliseconds");
		}
	}
	public static void responsestatuslinevalidation(Response response, String statusline) {
		try {
			Assert.assertEquals(statusline,  response.getStatusLine());
			testcase.pass("successfully validated status line, status line is ::"+ response.getStatusCode());
		}catch(AssertionError e) {
			testcase.fail("Expected status line is ::"+ statusline +",instead of getting :: "+ response.getStatusLine());
		}
	}	

	
	public static void responsebodyvalidation(Response response,String stringToSearch) {
		try {
			String responseBody = response.getBody().asString();
	        String searchString = stringToSearch;
	        
	        Assert.assertTrue(responseBody.contains(searchString));
			testcase.pass("successfully validated response body, response is ::"+ response.body().asString());
		}catch(AssertionError e) {
			testcase.fail("Does not contains the expected response body");
		}
	}	

	public static void responseHeader(Response response, String headerName,String expectedValue ) {
		try {
			String actualHeaderValue = response.getHeader(headerName);
			String expectedHeaderValue = expectedValue;
			Assert.assertEquals(actualHeaderValue, expectedHeaderValue);
			testcase.pass("successfully validated header value "+response.getHeader(headerName));
		} catch (AssertionError e) {
			testcase.fail("Expected status line is ::"+expectedValue+",instead of getting ::"+response.getHeader(headerName));
			
		}

	}

}
