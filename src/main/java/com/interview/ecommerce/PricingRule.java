package com.interview.ecommerce;

public class PricingRule {

  private Character itemName;
  private int itemCount;
  private int total;

  public PricingRule (Character itemName, int itemCount, int total) {
    this.itemCount = itemCount;
    this.itemName = itemName;
    this.total = total;
  }

  public Character getItemName() {
    return itemName;
  }

  public int getTotal() {
    return total;
  }

  public int getItemCount() {
    return itemCount;
  }
}
