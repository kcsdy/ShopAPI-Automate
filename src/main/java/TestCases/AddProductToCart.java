package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.AddProductPayload;
import pojo.AddProductResponse;
import pojo.ProductDetails;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddProductToCart {
	
	public static String productId ="6581ca979fd99c85e8ee7faf";
	
	@Test
	public void addAproduct() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/api/ecom/user/add-to-cart";
		
		
		AddProductPayload appl = new AddProductPayload();
		
		appl.set_id(LoginTest.userId);
		
		ProductDetails prodDetails = new ProductDetails();
		prodDetails.set_id(productId);
		prodDetails.setProductName("ADIDAS ORIGINAL");
		prodDetails.setProductPrice("31500");
		prodDetails.setProductCategory("household");
		prodDetails.setProductSubCategory("shoes");
		prodDetails.setProductDescription("Adidas shoes for Men");
		prodDetails.setProductAddedBy("admin@gmail.com");
		prodDetails.setProductImage("https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649488046.jpg");
		prodDetails.setProductRating("0");
		prodDetails.setProductStatus(true);
		prodDetails.setProductFor("men");
		prodDetails.setProductTotalOrders("0");
		prodDetails.set__v(0);
		
		
		appl.setProduct(prodDetails);
		
		AddProductResponse ap = given().log().all().header("Content-Type","application/json")
				.header("Authorization",LoginTest.token)
		.body(appl).when().post()
		.then().log().all().assertThat().statusCode(200).extract().response().as(AddProductResponse.class);
		
		System.out.println(ap.getMessage());
		System.out.println("Doneee");
	}

}
