package api.endpoint;

import static io.restassured.RestAssured.given;

import Excel.ToReadExcel;
import api.utilies.ToReadJson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GuideLinesEndPoints {
	 static String token;

		public static void toGenerate() throws Throwable {
			 token = given().contentType(ContentType.JSON)
					 .accept(ContentType.JSON)
					 .header("app_language","en").header("app_version","1")
					.body(ToReadJson.readJson())
					.when().post(ToReadExcel.readData(1, 0,"Sheet2")).then().extract().response()
					.jsonPath().getString("result.token");
					 System.out.println("-----------Token Value-----------------------");
					 System.out.println("Token: "+token);
					 System.out.println("-------------End---------------------");
					
			

		}

		public static Response createGuideLine() throws Throwable {
			Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON)
					.header("app_language","en").header("app_version","1").header("Authorization",token).body(ToReadExcel.readData(1,5,"Sheet1"))
					.when().post(ToReadExcel.readData(1,4,"Sheet1"));
				return response;

		}
		 
		public static Response viewAllGuideLine(int pageNo, int limitNo,String field,String sort) throws Throwable {
			Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("page_no",pageNo ).pathParam("limit_no", limitNo).pathParam("sortField", field).pathParam("sortBy",sort)
				.header("app_language","en").header("app_version","1").header("Authorization",token)
					.when().get(ToReadExcel.readData(2,4,"Sheet1"));
				return response;
			

		}
		public static Response toEditGuideLine() throws Throwable {
			Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON)
					.header("app_language","en").header("app_version","1").header("Authorization",token).body(ToReadExcel.readData(3,5,"Sheet1"))
					.when().post(ToReadExcel.readData(3,4,"Sheet1"));
				return response;

		}
		
		public static Response toDeleteGuideLine(int guideLineId ) throws Throwable {
			Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON)
					.header("app_language","en").header("app_version","1").header("Authorization",token).pathParam("id",guideLineId )
					.when().delete(ToReadExcel.readData(4,4,"Sheet1"));
				return response;

		}
}
