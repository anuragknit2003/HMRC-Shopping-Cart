package uk.gov.hmrc.shoppingcart.offers.impl;

import java.math.BigDecimal;
import java.util.List;

import uk.gov.hmrc.shoppingcart.model.Product;
import uk.gov.hmrc.shoppingcart.offers.Offer;

/**
 * Implementation of @Offer which applies Buy Three For Price of Two Offer on the products list passed to it.
 * @author anuragtripathi
 *
 */
public class BuyThreeForPriceOfTwoOffer implements Offer {

	@Override
	public double applyOfferAndCalculatePrice(List<Product> productList) {
		if(productList ==null || productList.size()<1 ) {
			return 0.00;
		}
		
		final int totalItmes = productList.size();
		final double costPerUnit = productList.get(0).getProductPrice();
		final int mod = totalItmes/3;
		final int reminder = totalItmes%3;
		
		return BigDecimal.valueOf(mod * costPerUnit * 2).add(BigDecimal.valueOf(reminder*costPerUnit)).doubleValue();
	}

}
