/**
 * Steven Ward
 * DrinkMachine.java | Drink Machine Project
 *
 * This file contains the definition of the DrinkMachine class, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO: CLASS-LEVEL DOCUMENTATION FOR DRINKMACHINE CLASS!
 *       JAVADOC TAGS
 */

public class DrinkMachine implements VendingMachine {

  enum Drink {
    COLA(0), LEMON_LIME(1), WATER(2);

    public final int itemNo;
    Drink(int itemNo) { this.itemNo = itemNo; }
  }

  public static final double PRICE = 0.75;

  private Inventory<Drink> inventory;
  private Deque<Money> moneyInserted;

  // Implementation of VendingMachine interface contract.
  @Override public double moneyInserted( ) {
    return Money.totalValue(this.moneyInserted);
  }

  @Override public double moneyRequired( ) {
    return sufficientFunds() ? 0 : DrinkMachine.PRICE - moneyInserted();
  }

  @Override public boolean sufficientFunds( ) {
    return moneyInserted() >= DrinkMachine.PRICE;
  }

  @Override public Deque<Money> giveChange( ) {
    Deque<Money> change = new ArrayDeque<Money>();
    while (!this.moneyInserted.isEmpty()) {
      change.push(this.moneyInserted.pop());
    }
    return change;
  }

  @Override public Money receiveMoney(Money m) {
    if (sufficientFunds()) {
      this.moneyInserted.push(m);
      return null;
    }

    return m;
  }
}
