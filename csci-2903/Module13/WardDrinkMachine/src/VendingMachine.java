/**
 * Steven Ward
 * VendingMachine.java | Drink Machine Project
 *
 * This file contains the definition of the VendingMachine class.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class VendingMachine {

  public static final double PRICE = 0.75;
  public static final int CHOICES = 3;

  enum Drink { COLA, LEMON_LIME, WATER };

  private Inventory<Drink> inventory;
  private Deque<Money> moneyInserted = new ArrayDeque<Money>();

  public double valueInserted( ) {
    return Money.totalValue(this.moneyInserted);
  }

  public double valueRequired( ) {
    return sufficientFunds() ? 0 : VendingMachine.PRICE - valueInserted();
  }

  public boolean sufficientFunds( ) {
    return valueInserted() >= VendingMachine.PRICE;
  }

  public int getStockOf(Drink d) {
    return this.inventory.getStock(d);
  }

  public boolean soldOutOf(Drink d) {
    return this.inventory.isSoldOut(d);
  }

  public boolean soldOut( ) {
    return this.inventory.isSoldOut();
  }

  public Money receiveMoney(Money m) {
    if (!sufficientFunds()) {
      moneyInserted.push(m);
      return null;
    }
    else {
      return m;
    }
  }

  public boolean canDispense(Drink d) {
    return sufficientFunds() && !soldOutOf(d);
  }

  public Drink dispense(Drink d) {
    if (canDispense(d)) {
      inventory.removeOneOf(d);
      return d;
    }
    else {
      throw new IllegalArgumentException("VendingMachine.dispense(Drink d) - item unavailable, call 'VendingMachine.canDispense(Drink d)' prior to method call");
    }
  }

  public Deque<Money> giveChange(double amt) {
    Deque<Money> change = new ArrayDeque<Money>();
    double change_value = 0.0;
    Money[] m_enums = Money.values();
    int i = 0;
    while (change_value < amt) {
      Money m = m_enums[i];
      if ( (change_value + m.value) <= amt ) {
        change.push(m);
        change_value += m.value;
      }
      else {
        i++;
      }
    }
    return change;
  }

  public Deque<Money> giveChange( ) {
    Deque<Money> change = new ArrayDeque<Money>(moneyInserted.size());
    if (valueInserted() > 0.0) {
      while (!moneyInserted.isEmpty()) {
        change.push(moneyInserted.pop());
      }
    }
    return change;
  }


  public VendingMachine(int[] initStock) {
    this.inventory = new Inventory<Drink>(Drink.class, initStock);
  }

  public VendingMachine(int initStock) {
    this.inventory = new Inventory<Drink>(Drink.class, new int[] { initStock, initStock, initStock });
  }
}
