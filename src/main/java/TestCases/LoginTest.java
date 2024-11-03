package TestCases;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import pojo.LoginTokenPayload;
import pojo.LoginTokenResponse;

public class LoginTest {
	
	public static String userId;
	public static String token;

	@Test
	public void Login() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/api/ecom/auth/login";
		
		LoginTokenPayload lt = new LoginTokenPayload();
		lt.setUserEmail("postmankaka@gmail.com");
		lt.setUserPassword("Kuntal@422");
		
		LoginTokenResponse lts = given().log().all().header("Content-Type","application/json").body(lt)
		.when().post()
		.then().log().all().assertThat().statusCode(200).extract().response().as(LoginTokenResponse.class);
		token = lts.getToken();
		userId = lts.getUserId();
	}
}
