package org.strangeway.tsr.pojos;

import java.util.List;

public final class Product {
  private final String name;
  private final Double price;
  private final int count;

  public Product(String name, Double price, int count) {
    this.name = name;
    this.price = price;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public int getCount() {
    return count;
  }

  @Override
  public String toString() {
    return "Product{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", count=" + count +
        '}';
  }

  public static void main(String[] args) {
    Product p = new Product("Some", 10.0, 100);
    System.out.println(List.of(p));
  }
}
