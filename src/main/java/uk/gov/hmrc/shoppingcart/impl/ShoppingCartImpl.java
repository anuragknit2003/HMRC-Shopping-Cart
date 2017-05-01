package uk.gov.hmrc.shoppingcart.impl;

import java.util.ArrayList;
import java.util.List;

import uk.gov.hmrc.shoppingcart.ShoppingCart;
import uk.gov.hmrc.shoppingcart.model.Product;

/**
 * Implementation of @ShoppingCart
 * @author anuragtripathi
 *
 */
public class ShoppingCartImpl implements ShoppingCart {
	
	private List<Product> productList = new ArrayList<Product>();
	private double totalCartValue;

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
			for (Product product : productList) {
				totalCartValue = totalCartValue + product.getProductPrice();
			}
		}
		return totalCartValue;
	}
}
