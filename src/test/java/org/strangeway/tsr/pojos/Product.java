/*
 * Copyright © 2022 Yuriy Artamonov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.strangeway.tsr.pojos;

import java.util.List;
import java.util.Map;

public final class Product {
  private final ProductType productType;
  private final String name;
  private final Double price;
  private final int count;

  public Product(ProductType productType, String name, Double price, int count) {
    this.productType = productType;
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

  public ProductType getProductType() {
    return productType;
  }

  @Override
  public String toString() {
    return "Product{" +
        "productType=" + productType +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", count=" + count +
        '}';
  }

  public static void main(String[] args) {
    Product p = new Product(ProductType.USED, "Some", 10.0, 100);
    System.out.println(List.of(p));
    System.out.println(Map.of("product", p));
    System.out.println(Map.of(new UserRef(), p));
  }
}

class UserRef {

}