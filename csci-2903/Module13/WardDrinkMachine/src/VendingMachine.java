/**
 * Steven Ward
 * VendingMachine.java | Drink Machine Project
 *
 * This file contains the definition of the VendingMachine interface, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO: CLASS-LEVEL DOCUMENTATION FOR VENDINGMACHINE INTERFACE!
 *       JAVADOC TAGS
 */

public interface VendingMachine {

  enum Money {
    PENNY       (0.01),
    NICKEL      (0.05),
    DIME        (0.10),
    QUARTER     (0.25),
    HALF_DOLLAR (0.50),
    ONE_DOLLAR  (1.00),
    FIVE_DOLLAR (5.00);

    public final double value;

    Money(double val) { this.value = val; }

    public static double totalValue(Deque<Money> money) {
      double total_value = 0.0;
      for (Money m : money) {
        total_value += m.value;
      }
      return total_value;
    }
  }


  Money receiveMoney(Money m);

  <ItemType extends Enum<ItemType>> boolean canDispense(ItemType item);

  <ItemType extends Enum<ItemType>> ItemType dispense(ItemType item);

  Deque<Money> giveChange( );

  double moneyRequired( );

  double moneyInserted( );

  boolean sufficientFunds( );


}
