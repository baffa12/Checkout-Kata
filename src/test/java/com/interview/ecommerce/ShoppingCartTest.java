package com.interview.ecommerce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

  private ShoppingCart shoppingCart = new ShoppingCart();

  @BeforeEach
  void init(){
    PricingRule ruleA = new PricingRule('A',  3, 130);
    PricingRule ruleB = new PricingRule('B',  2, 45);

    shoppingCart.updatePricingRule(ruleA);
    shoppingCart.updatePricingRule(ruleB);

    // Add to cart
    shoppingCart.addToCart(new Item('A', 50));
    shoppingCart.addToCart(new Item('C', 20));
    shoppingCart.addToCart(new Item('D', 15));
    shoppingCart.addToCart(new Item('A', 50));
    shoppingCart.addToCart(new Item('C', 20));
  }


  @Test
  void checkToSeeExceptionThrownForNullItem (){
    Assertions.assertThrows(NullPointerException.class, () -> {shoppingCart.addToCart(null);});
  }

  @Test
  void checkToSeeExceptionThrownForNullPricingRule (){
    Assertions.assertThrows(NullPointerException.class, () -> {shoppingCart.updatePricingRule(null);});
  }

  @Test
  void calculateTotalPasses(){
    double total = shoppingCart.calculateTotal();
    Assertions.assertEquals(155, total);
  }

  @Test
  void calculateTotalUsesSpecialPricePasses(){
    shoppingCart.addToCart(new Item('A', 50));
    double total = shoppingCart.calculateTotal();
    Assertions.assertEquals(185, total);
  }


}
