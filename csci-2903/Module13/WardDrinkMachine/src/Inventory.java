/**
 * Steven Ward
 * Inventory.java | Drink Machine Project
 *
 * This file contains the definition of the Inventory generic class, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */


/**
 * TODO: CLASS-LEVEL DOCUMENTATION FOR INVENTORY CLASS!
 *       JAVADOC TAGS
 */
public class Inventory<ProductType extends Enum<ProductType>> {

  public final Class<ProductType>;
  public final EnumSet<ProductType> products;
  public int[] currentStock;

}
