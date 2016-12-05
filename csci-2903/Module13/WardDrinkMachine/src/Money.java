/**
 * Steven Ward
 * Money.java | Drink Machine Project
 *
 * This file defines the Money enumerator class.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.Deque;

public enum Money {
  DOLLAR  (1.00),
  QUARTER (0.25),
  DIME    (0.10),
  NICKEL  (0.05),
  PENNY   (0.01);

  public final double value;

  Money(double val) {
    this.value = val;
  }

  public static double totalValue(Deque<Money> money) {
    double total_value = 0.0;
    for (Money m : money) {
      total_value += m.value;
    }
    return total_value;
  }
}
