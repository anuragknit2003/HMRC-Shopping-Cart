package uk.gov.hmrc.shoppingcart;

import org.junit.Assert;
import org.junit.Test;

import uk.gov.hmrc.shoppingcart.impl.ShoppingCartImpl;
import uk.gov.hmrc.shoppingcart.model.Product;
import uk.gov.hmrc.shoppingcart.model.ProductName;

/**
 * Test to cover functionality of @ShoppingCartImpl
 * @author anuragtripathi
 *
 */
public class ShoppingCartTest {

	/**
	 * Tests An Shopping Cart can be created and on initialisation it will have no products
	 * and no cart value
	 */
	@Test
	public void testCreateEmptyShoppingCart() {
		final ShoppingCart cart = new ShoppingCartImpl();
		Assert.assertEquals(0, cart.getProductCount());
		Assert.assertEquals(0.00, cart.getTotalCartValue(),0.00);

	}
	
	/**
	 * Tests An Apple can be added to shopping cart
	 */
	@Test
	public void testAddAppleToShoppingCart() {
		final ShoppingCart cart = new ShoppingCartImpl();
		final Product apple = new Product(ProductName.APPLE, 0.60);
		cart.addProduct(apple);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(0.60, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests An Orange can be added to shopping cart
	 */
	@Test
	public void testAddOrangeToShoppingCart() {
		final ShoppingCart cart = new ShoppingCartImpl();
		final Product orange = new Product(ProductName.ORANGE, .25);
		cart.addProduct(orange);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(.25, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests An Orange and An Apple can be added in same cart 
	 */
	@Test
	public void addSingleAppleAndOrangeToTheCart(){
		final ShoppingCart cart = new ShoppingCartImpl();
		final Product apple = new Product(ProductName.APPLE, 0.60);
		final Product orange = new Product(ProductName.ORANGE, .25);
		cart.addProduct(apple);
		cart.addProduct(orange);
		Assert.assertEquals(2, cart.getProductCount());
		Assert.assertEquals(0.85, cart.getTotalCartValue(),0.0);
	}
	
	/**
	 * Tests Multiple Number of Oranges and Apples can be added in same cart 
	 */
	@Test
	public void addDifferentPrdsToTheCart(){
		final ShoppingCart cart = new ShoppingCartImpl();
		final Product apple1 = new Product(ProductName.APPLE, 0.60);
		final Product apple2 = new Product(ProductName.APPLE, 0.60);
		final Product orange1 = new Product(ProductName.ORANGE, .25);
		final Product orange2 = new Product(ProductName.ORANGE, .25);
		final Product orange3 = new Product(ProductName.ORANGE, .25);
		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		Assert.assertEquals(5, cart.getProductCount());
		Assert.assertEquals(1.95, cart.getTotalCartValue(),0.00);
	}
}
