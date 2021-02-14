package com.interview.ecommerce;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {


  private Map<Character, Integer> skuMap;
  private Map<Character, Item> itemMap;
  private Map<Character, PricingRule> pricingRuleMap;



  public ShoppingCart(){
    skuMap = new HashMap<>();
    itemMap = new HashMap<>();
    pricingRuleMap = new HashMap<>();
  }

  public void addToCart(Item item){

    if(item == null)
      throw new NullPointerException();

    Character sku = item.getName();

    if(skuMap.containsKey(sku)){
      skuMap.put(sku, skuMap.get(sku) + 1);
    }else{
      skuMap.put(sku, 1);
    }

    itemMap.put(sku, item);
  }



  public void updatePricingRule(PricingRule rule) {
    if(rule == null)
      throw new NullPointerException();

    pricingRuleMap.put(rule.getItemName(), rule);
  }




  public double calculateTotal(){

    double total = 0;
    for(Map.Entry<Character, Integer> entry : skuMap.entrySet()){

      Character itemsSku = entry.getKey();
      double normalPrice = itemMap.get(itemsSku).getPrice();

      if(pricingRuleMap.containsKey(itemsSku)){
        int itemCount = entry.getValue();
        PricingRule pricingRule =  pricingRuleMap.get(itemsSku);

        int remainder =  itemCount % pricingRule.getItemCount();
        int wholeDiscounts = itemCount / pricingRule.getItemCount();

        total += (remainder * normalPrice) + (wholeDiscounts * pricingRule.getTotal());

      }else{
        total += entry.getValue() * normalPrice;
      }

    }

    return total;
  }

}
