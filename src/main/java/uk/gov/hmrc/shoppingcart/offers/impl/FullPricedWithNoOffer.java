package uk.gov.hmrc.shoppingcart.offers.impl;

import java.util.List;

import uk.gov.hmrc.shoppingcart.model.Product;
import uk.gov.hmrc.shoppingcart.offers.Offer;

/**
 * Implementation of @Offer which doesn't apply any offer on the products passed
 
 * @author anuragtripathi
 *
 */
public class FullPricedWithNoOffer implements Offer {

	@Override
	public double applyOfferAndCalculatePrice(List<Product> productList) {
		if(productList ==null || productList.size()<1 ) {
			return 0.00;
		}
		return productList.size()*productList.get(0).getProductPrice();
		
	}

}
