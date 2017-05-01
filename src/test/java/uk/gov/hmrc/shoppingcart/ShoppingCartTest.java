package uk.gov.hmrc.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uk.gov.hmrc.shoppingcart.impl.ShoppingCartImpl;
import uk.gov.hmrc.shoppingcart.model.Product;
import uk.gov.hmrc.shoppingcart.model.ProductName;
import uk.gov.hmrc.shoppingcart.offers.Offer;
import uk.gov.hmrc.shoppingcart.offers.impl.BuyOneGetOneFreeOffer;
import uk.gov.hmrc.shoppingcart.offers.impl.BuyThreeForPriceOfTwoOffer;

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
	 * Tests An Apple can be added to shopping cart without offer and it reflects correct price.
	 */
	@Test
	public void testAddAppleToShoppingCartWithoutOffer() {
		final ShoppingCart cart = new ShoppingCartImpl();
		final Product apple = new Product(ProductName.APPLE, 0.60);
		cart.addProduct(apple);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(0.60, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests An Orange can be added to shopping cart without offer and it reflects correct price.
	 */
	@Test
	public void testAddOrangeToShoppingCartWithoutOffer() {
		final ShoppingCart cart = new ShoppingCartImpl();
		final Product orange = new Product(ProductName.ORANGE, .25);
		cart.addProduct(orange);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(.25, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests An Orange and An Apple can be added in same cart without offer and it reflects correct price.
	 */
	@Test
	public void addSingleAppleAndOrangeToTheCartWithoutOffer(){
		final ShoppingCart cart = new ShoppingCartImpl();
		final Product apple = new Product(ProductName.APPLE, 0.60);
		final Product orange = new Product(ProductName.ORANGE, .25);
		cart.addProduct(apple);
		cart.addProduct(orange);
		Assert.assertEquals(2, cart.getProductCount());
		Assert.assertEquals(0.85, cart.getTotalCartValue(),0.0);
	}
	
	/**
	 * Tests Multiple Number of Oranges and Apples can be added in same cart without offer and it reflects correct price. 
	 */
	@Test
	public void addDifferentPrdsToTheCartWithoutOffer(){
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
	
	/**
	 * Tests An Apple can be added to shopping cart With BuyOneGetOneFree offer and it reflects correct price.
	 */
	@Test
	public void testAddSingleAppleToShoppingCartWithBuyOneGetOneFreeOffer() {
		
		final Map<ProductName, Offer> offersMap = new HashMap<ProductName, Offer>();
		offersMap.put(ProductName.APPLE, new BuyOneGetOneFreeOffer());
		offersMap.put(ProductName.ORANGE, new BuyThreeForPriceOfTwoOffer());
		
		final ShoppingCart cart = new ShoppingCartImpl(offersMap);
		final Product apple = new Product(ProductName.APPLE, 0.60);
		cart.addProduct(apple);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(0.60, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests An Apple can be added to shopping cart With BuyOneGetOneFree offer and it reflects correct price.
	 */
	@Test
	public void testAddMultipleAppleToShoppingCartWithBuyOneGetOneFreeOffer() {
		
		final Map<ProductName, Offer> offersMap = new HashMap<ProductName, Offer>();
		offersMap.put(ProductName.APPLE, new BuyOneGetOneFreeOffer());
		offersMap.put(ProductName.ORANGE, new BuyThreeForPriceOfTwoOffer());
		
		final ShoppingCart cart = new ShoppingCartImpl(offersMap);
		final Product apple = new Product(ProductName.APPLE, 0.60);
		cart.addProduct(apple);
		cart.addProduct(apple);
		cart.addProduct(apple);
		cart.addProduct(apple);
		cart.addProduct(apple);
		Assert.assertEquals(5, cart.getProductCount());
		Assert.assertEquals(1.80, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests An Orange can be added to shopping cart With BuyThreeForPriceOfTwoOffer offer and it reflects correct price.
	 */
	@Test
	public void testAddSingleOrangeToShoppingCartWithBuyThreeForPriceOfTwoOffer() {
		
		final Map<ProductName, Offer> offersMap = new HashMap<ProductName, Offer>();
		offersMap.put(ProductName.APPLE, new BuyOneGetOneFreeOffer());
		offersMap.put(ProductName.ORANGE, new BuyThreeForPriceOfTwoOffer());
		
		final ShoppingCart cart = new ShoppingCartImpl(offersMap);
		final Product orange = new Product(ProductName.ORANGE, .25);
		cart.addProduct(orange);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(0.25, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests Multiple Oranges can be added to shopping cart With BuyThreeForPriceOfTwoOffer offer and it reflects correct price.
	 */
	@Test
	public void testAddMultipleOrangesToShoppingCartWithBuyThreeForPriceOfTwoOffer() {
		
		final Map<ProductName, Offer> offersMap = new HashMap<ProductName, Offer>();
		offersMap.put(ProductName.APPLE, new BuyOneGetOneFreeOffer());
		offersMap.put(ProductName.ORANGE, new BuyThreeForPriceOfTwoOffer());
		
		final ShoppingCart cart = new ShoppingCartImpl(offersMap);
		final Product orange = new Product(ProductName.ORANGE, .25);
		cart.addProduct(orange);
		cart.addProduct(orange);
		cart.addProduct(orange);
		cart.addProduct(orange);
		cart.addProduct(orange);
		
		Assert.assertEquals(5, cart.getProductCount());
		Assert.assertEquals(1.00, cart.getTotalCartValue(),0.00);
	}
	
	/**
	 * Tests Multiple Apples and Oranges can be added to shopping cart With offers and it reflects correct price.
	 */
	@Test
	public void testAddMultipleApplesAndOrangesToShoppingCartWithOffers() {
		
		final Map<ProductName, Offer> offersMap = new HashMap<ProductName, Offer>();
		offersMap.put(ProductName.APPLE, new BuyOneGetOneFreeOffer());
		offersMap.put(ProductName.ORANGE, new BuyThreeForPriceOfTwoOffer());
		
		final ShoppingCart cart = new ShoppingCartImpl(offersMap);
		final Product orange = new Product(ProductName.ORANGE, .25);
		cart.addProduct(orange);
		cart.addProduct(orange);
		cart.addProduct(orange);
		cart.addProduct(orange);
		cart.addProduct(orange);
		
		final Product apple = new Product(ProductName.APPLE, 0.60);
		cart.addProduct(apple);
		cart.addProduct(apple);
		cart.addProduct(apple);
		cart.addProduct(apple);
		cart.addProduct(apple);
		
		Assert.assertEquals(10, cart.getProductCount());
		Assert.assertEquals(2.80, cart.getTotalCartValue(),0.00);
	}
	
}
