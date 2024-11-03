package pojo;


public class AddProductPayload {

	private String _id;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public ProductDetails getProduct() {
		return product;
	}
	public void setProduct(ProductDetails product) {
		this.product = product;
	}
	private ProductDetails product;
	
	
	
}
