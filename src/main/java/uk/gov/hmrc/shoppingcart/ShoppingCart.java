package uk.gov.hmrc.shoppingcart;

import uk.gov.hmrc.shoppingcart.model.Product;

/**
 * Interface to expose what operations will be carried out by Application
 * @author anuragtripathi
 *
 */
public interface ShoppingCart {
	
	/**
	 * Returns Total Count of Products User has added in the Shopping cart
	 * @return Total Count of Products
	 */
	public int getProductCount();
	
	/**
	 * Adds a particular product in the Shopping Cart
	 * @param product Product
	 */
	public void addProduct(Product product);
	
	/**
	 * The Total Value of all the products added in the Shopping cart
	 * @return Total Value
	 */
	public double getTotalCartValue();
	
}
