package api.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import Excel.ToReadExcel;

import api.endpoint.GuideLinesEndPoints;
import api.utilies.APIValidations;
import api.utilies.Reports;
import api.utilies.ToReadJson;
import io.restassured.response.Response;

public class GuideLineTest extends APIValidations {
	 @BeforeClass
	 public void toGenerateReport() throws Throwable {
	 Reports.Report(); 
	 Reports.ReportCreateTestcase("API RESPONSE");
	 
	  }
		@Test
		public void keyGeneration() throws Throwable {
			Reports.ReportCreateTestcase("token");
			GuideLinesEndPoints.toGenerate();

		}
		@Test(dependsOnMethods = {"keyGeneration"})
		public void toCreateGuideLine() throws Throwable {
			Reports.ReportCreateTestcase(" To Create GuideLine");
		Response response =GuideLinesEndPoints.createGuideLine();
		
		response.then().log().all();
		responsetimevalidation(response);
        responsecodevalidation(response, 200);
        responsebodyvalidation( response,ToReadJson.createGuideLine());
        responseHeader(response, ToReadExcel.readData(1,10,"Sheet1"),ToReadExcel.readData(1,11,"Sheet1") );
        responsestatuslinevalidation(response,ToReadExcel.readData(1,9,"Sheet1"));
        

		}
		@Test(dependsOnMethods = {"keyGeneration"})
		
		public  void toViewAllGuideLine() throws Throwable {
			Reports.ReportCreateTestcase(" To View All GuideLine");
			Response response=	GuideLinesEndPoints.viewAllGuideLine(1, 10,"created_at","DESC");
			
			response.then().log().all();
			responsecodevalidation(response, 400);
			responsetimevalidation(response);
			responseHeader(response, ToReadExcel.readData(2,10,"Sheet1"),ToReadExcel.readData(2,11,"Sheet1") );
			responsestatuslinevalidation(response,ToReadExcel.readData(2,9,"Sheet1"));
			responsebodyvalidation( response,ToReadJson.toView());

		}
		@Test(dependsOnMethods = {"keyGeneration"})
		public void toEditGuideLine() throws Throwable {
			Reports.ReportCreateTestcase(" To Edit GuideLine");
			Response response=	GuideLinesEndPoints.toEditGuideLine();
			response.then().log().all();
			responsecodevalidation(response, 200);
			responsetimevalidation(response);
			responsebodyvalidation( response,ToReadJson.toUpdate());
			responsestatuslinevalidation(response,ToReadExcel.readData(3,9,"Sheet1"));
			responseHeader(response, ToReadExcel.readData(3,10,"Sheet1"),ToReadExcel.readData(3,11,"Sheet1") );
		}
		@Test(dependsOnMethods = {"keyGeneration"})
		public void toDeleteGuideLine() throws Throwable {
			Reports.ReportCreateTestcase(" To Delete GuideLine");
			Response response=	GuideLinesEndPoints.toDeleteGuideLine(274);
			response.then().log().all();
			responsecodevalidation(response, 400);
			responsetimevalidation(response);
			responsebodyvalidation( response,ToReadJson.toDelete());
			responsestatuslinevalidation(response,ToReadExcel.readData(4,9,"Sheet1"));
			responseHeader(response, ToReadExcel.readData(4,10,"Sheet1"),ToReadExcel.readData(4,11,"Sheet1") );
		}
		@AfterClass
		 public static void ReportCooldown() {
			 Reports.ReportCooldown();
		  }
		 

}
