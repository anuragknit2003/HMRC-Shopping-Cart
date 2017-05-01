package uk.gov.hmrc.shoppingcart.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import uk.gov.hmrc.shoppingcart.ShoppingCart;
import uk.gov.hmrc.shoppingcart.model.Product;
import uk.gov.hmrc.shoppingcart.model.ProductName;
import uk.gov.hmrc.shoppingcart.offers.Offer;
import uk.gov.hmrc.shoppingcart.offers.impl.FullPricedWithNoOffer;

/**
 * Implementation of @ShoppingCart
 * 
 * @author anuragtripathi
 *
 */
public class ShoppingCartImpl implements ShoppingCart {

	private final List<Product> productList = new ArrayList<Product>();
	private double totalCartValue;

	private Map<ProductName, Offer> offersMap;

	/**
	 * Initialises Shopping Cart with No Offers to be applied
	 */
	public ShoppingCartImpl() {
		offersMap = new HashMap<>();
		offersMap.put(ProductName.APPLE, new FullPricedWithNoOffer());
		offersMap.put(ProductName.ORANGE, new FullPricedWithNoOffer());
	}

	/**
	 * Initialises Shopping Cart with Offers to be applied
	 * @param cartWithOffers Map of Offers
	 */
	public ShoppingCartImpl(final Map<ProductName, Offer> cartWithOffers) {
		offersMap = new HashMap<>();
		offersMap.putAll(cartWithOffers);
	}

	@Override
	public int getProductCount() {
		return productList.size();
	}

	@Override
	public void addProduct(Product product) {
		productList.add(product);
	}

	@Override
	public double getTotalCartValue() {
		if (productList.size() > 0) {
			final Map<ProductName, List<Product>> map = productList.stream()
					.collect(Collectors.groupingBy(Product::getProductName));
			totalCartValue = map.entrySet().stream()
					.map(e -> offersMap.get(e.getKey()).applyOfferAndCalculatePrice(e.getValue()))
					.reduce(0.00, Double::sum);
		}
		return totalCartValue;
	}
}
