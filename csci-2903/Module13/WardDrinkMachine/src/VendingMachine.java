/**
 * Steven Ward
 * VendingMachine.java | Drink Machine Project
 *
 * This file contains the definition of the VendingMachine interface, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */


/**
 * TODO: CLASS-LEVEL DOCUMENTATION FOR VENDINGMACHINE INTERFACE!
 *       JAVADOC TAGS
 */

public interface VendingMachine<ProductType extends Enum<ProductType>> {

  enum Money {
    PENNY       (0.01),
    NICKEL      (0.05),
    DIME        (0.10),
    QUARTER     (0.25),
    HALF_DOLLAR (0.50),
    ONE_DOLLAR  (1.00),
    FIVE_DOLLAR (5.00);

    public final value;
    Money(double val) { this.value = val; }

    public static double totalValue(List<Money> money) {

    }
  }
}
