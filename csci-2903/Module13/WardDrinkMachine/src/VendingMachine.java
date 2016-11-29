/**
 * Steven Ward
 * VendingMachine.java | Drink Machine Project
 *
 * This file contains the definition of the abstract VendingMachine class, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * TODO: Class-level documentation for VendingMachine class
 *
 */

public abstract class VendingMachine {
  public final double itemPrice;
  private Inventory inventory;
  private Deque<Money> moneyInserted;

  enum Money {
    PENNY       (0.01),
    NICKEL      (0.05),
    DIME        (0.10),
    QUARTER     (0.25),
    HALF_DOLLAR (0.50),
    DOLLAR      (1.00);

    Money(double val) { this.value = val; }
    public final double value;
  }


  protected class Inventory {
    public final Object[] itemList;
    private int[] currentStock;

    private Inventory(Object[] items, int[] initStock) {
      int off = items.length -initStock.length;
      if (off > 0) {
        throw new IllegalArgumentException("No initial stock provided for " + off +
                                          (off > 1 ? " items" : " item") + "in item list -"
                                          + " Specify zero (0) explicitly for no stock.");
      }
      else if (off < 0) {
        int[] trunc_tmp = new int[items.length];
        for (int i = 0; i < items.length; i++) {
          trunc_tmp[i] = initStock[i];
        }
        initStock = trunc_tmp;
      }
      int nItems = items.length;
      this.itemList = new Object[nItems];
      this.currentStock = new int[nItems];
      for (int i = 0; i < nItems; i++) {
        itemList[i] = items[i];
        currentStock[i] = initStock[i];
      }
    }
  }


  protected final double price( ) { return this.itemPrice; }
  protected final Inventory inventory( ) { return this.inventory; }

  protected final double amountPaid( ) {
    double amt = 0.0;
    for (Money m : moneyInserted) {
      amt += m.value;
    }
    return amt;
  }

  protected final double amountNeeded( ) {
    double rem = this.itemPrice - amountPaid();
    return rem > 0 ? rem : 0;
  }

  protected final boolean addMoney(final Money m) {
    if (amountNeeded() > 0) {
      this.moneyInserted.push(m);
      return true;
    }
    else { return false; }
  }

  protected final Deque<Money> dispenseAllChange( ) {
    Deque<Money> change = new ArrayDeque<Money>(this.moneyInserted.size());
    while ( !this.moneyInserted.isEmpty() ) {
      change.push(moneyInserted.pop());
    }
    return change;
  }


  protected VendingMachine(double price, final Object[] items, int[] stock) {
    this.itemPrice = price;
    this.moneyInserted = new ArrayDeque<Money>();
    this.inventory = new Inventory(items, stock);
  }

  protected VendingMachine(double price, final Object[] items, int u_stock) {
    this.itemPrice = price;
    this.moneyInserted = new ArrayDeque<Money>();
    int[] stock = new int[items.length];
    Arrays.fill(stock, u_stock);
    this.inventory = new Inventory(items, stock);
  }

}
