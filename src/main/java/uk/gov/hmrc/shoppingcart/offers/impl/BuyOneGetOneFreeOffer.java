package uk.gov.hmrc.shoppingcart.offers.impl;

import java.math.BigDecimal;
import java.util.List;

import uk.gov.hmrc.shoppingcart.model.Product;
import uk.gov.hmrc.shoppingcart.offers.Offer;

/**
 * Implementation of @Offer which applies Buy One Get One free Offer on the products list passed to it.
 * @author anuragtripathi
 *
 */
public class BuyOneGetOneFreeOffer implements Offer {

	@Override
	public double applyOfferAndCalculatePrice(List<Product> productList) {
		if(productList ==null || productList.size()<1 ) {
			return 0.00;
		}
		
		final int totalItmes = productList.size();
		final double costPerUnit = productList.get(0).getProductPrice();
		final int mod = totalItmes/2;
		final int reminder = totalItmes%2;
		
		return BigDecimal.valueOf(mod * costPerUnit).add(BigDecimal.valueOf(reminder*costPerUnit)).doubleValue();
	}
}
