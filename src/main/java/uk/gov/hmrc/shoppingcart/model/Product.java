package uk.gov.hmrc.shoppingcart.model;

/**
 * Model Class to hold Product Name and it's price
 * @author anuragtripathi
 *
 */
public class Product {
	
	private final ProductName productName;
	private final double productPrice;
 
	/**
	 * Initialises Product Instance
	 * @param productName Product Name
	 * @param productPrice Product's Price
	 */
	public Product(final ProductName productName, double productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
 
	/**
	 * Returns Product Name
	 * @return Product Name
	 */
	public ProductName getProductName() {
		return productName;
	}
 
	/**
	 * Returns Product's Price
	 * @return Product's Price
	 */
	public double getProductPrice() {
		return productPrice;
	}
}
