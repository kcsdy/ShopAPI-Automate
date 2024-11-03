package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.Orderproduct;
import pojo.Orders;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class OrderAProduct {

	@Test
	public void OrderAProductFromCart() {

		RequestSpecification reqSpec = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com/api/ecom/order/create-order")
				.setContentType(ContentType.JSON).addHeader("Authorization", LoginTest.token).build();
		
		Orderproduct ordPrd = new Orderproduct();
		
		List<Orders> opd = new ArrayList<Orders>();
		
		Orders od = new Orders();
		
		od.setCountry("United Kingdom");
		od.setProductOrderedId(AddProductToCart.productId);
		
		opd.add(od);
		
		ordPrd.setOrders(opd);

		given().log().all().spec(reqSpec).body(ordPrd).when().post().then().log().all().assertThat().statusCode(201);
	}

}
