package com.interview.ecommerce;

public class Item {

  private Character name;
  private double price;

  public Item(Character name, double price) {
    this.name = name;
    this.price = price;
  }

  public Character getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}
