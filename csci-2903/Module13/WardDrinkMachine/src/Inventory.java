/**
 * Steven Ward
 * Inventory.java | Drink Machine Project
 *
 * This file contains the definition of the Inventory generic class, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * TODO: CLASS-LEVEL DOCUMENTATION FOR INVENTORY CLASS!
 *       JAVADOC TAGS
 */
public class Inventory<ProductType extends Enum<ProductType>> {

  public final Class<ProductType> productType;
  public final List<ProductType> products;
  private int[] currentStock;

  public Inventory(Class<ProductType> productType, final int[] initStock) {
    this.productType = productType;
    this.products = new ArrayList<ProductType>( Arrays.asList(this.productType.getEnumConstants()) );

    // the 'Arrays.copyOf(int[] original, int newLength)' method truncates (or pads with zeros) the
    // resulting copy so that it has the specified length - so, 'initStock' will be copied to the
    // proper length by removing trailing elements or adding elements with a zero value, if necessary
    this.currentStock = Arrays.copyOf(initStock, products.size());
  }


  public Inventory(Class<ProductType> productType, int initStock) {
    this.productType = productType;
    this.products = new ArrayList<ProductType>( Arrays.asList(this.productType.getEnumConstants()) );
    this.currentStock = new int[products.size()];
    Arrays.fill(currentStock, initStock);
  }


  public boolean removeItem(int itemNo) {
    if (itemNo >= this.currentStock.length) throw new IllegalArgumentException();

    if (currentStock[itemNo] > 0) {
      --currentStock[itemNo];
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeItem(ProductType item) {
    return removeItem(getItemNo(item));
  }


  public boolean isSoldOut(int itemNo) {
    return this.currentStock[itemNo] <= 0;
  }

  public boolean isSoldOut(ProductType item) {
    return isSoldOut(getItemNo(item));
  }

  public boolean isSoldOut( ) {
    for (int n : this.currentStock) {
      if (n > 0) return false;
    }
    return true;
  }


  private int getItemNo(ProductType item) {
    return this.products.indexOf(item);
  }

}
