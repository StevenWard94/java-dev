/**
 * Steven Ward
 * Inventory.java | Drink Machine Project
 *
 * This file contains the definition for the generic class, Inventory, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.Arrays;

/**
 * TODO: CLASS-LEVEL DOCUMENTATION FOR INVENTORY CLASS!
 *       JAVADOC TAGS
 */

public class Inventory<Product extends Enum<Product>> {
  private Class<Product> productType;
  //private final Product[] products;
  private int[] currentStock;


  public int nLeftInStock(int productNo) {
    return this.currentStock[productNo];
  }


  public int nLeftInStock(Product product) {
    int productNo = 0;
    for (Product p : this.productType.getEnumConstants()) {
      if (product == p) { break; }
      productNo++;
    }
    return this.currentStock[productNo];
  }


  public boolean soldOutOf(int productNo) {
    return !(nLeftInStock(productNo) > 0);
  }


  public boolean soldOutOf(Product product) {
    return !(nLeftInStock(product) > 0);
  }


  public boolean soldOut( ) {
    for (int i : this.currentStock) {
      if (i > 0) { return false; }
    }
    return true;
  }


  public Inventory(final Class<Product> productType, final int[] initStock) {
    this.productType = productType;
    Product[] products = this.productType.getEnumConstants();
    this.currentStock = new int[products.length];
    if (products.length > initStock.length) {
      for (int i = 0; i < products.length; i++) {
        currentStock[i] = i < initStock.length ? initStock[i] : 0;
      }
    }
    else {
      for (int i = 0; i < products.length; i++) {
        currentStock[i] = initStock[i];
      }
    }
  }


  public Inventory(final Class<Product> productType, int uniform_stock) {
    this.productType = productType;
    Product[] products = this.productType.getEnumConstants();
    this.currentStock = new int[products.length];
    Arrays.fill(currentStock, uniform_stock);
  }
}
