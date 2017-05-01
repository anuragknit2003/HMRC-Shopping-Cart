package uk.gov.hmrc.shoppingcart.offers;

import java.util.List;

import uk.gov.hmrc.shoppingcart.model.Product;

/**
 * Interface 
 * @author anuragtripathi
 *
 */
public interface Offer  {

  /**
   * Applies Offer on the items passed and calculates the orice
   * @param productList Product List
   * @return
   */
  public double applyOfferAndCalculatePrice(List<Product> productList);
}
