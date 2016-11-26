/**
 * Steven Ward
 * VendingMachine.java | Drink Machine Project
 *
 * This file contains the definition of the VendingMachine abstract class, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */

/*
 * TODO: Class-level documentation for VendingMachine class
 */

import java.util.Arrays;

public abstract class VendingMachine {
  private double itemPrice;
  private Inventory inventory;

  enum Money {
    PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25), HALF_DOLLAR(0.50), DOLLAR(1.00);
    Money(double val) { this.value = val; }
    public double value( ) { return this.value; }
    private double value;
  }

  protected abstract class Inventory {
    private final double price;
    private final Object[] products;
    private int[] stock;

    protected Inventory(Object[] items, int initStock) {
      this.price = VendingMachine.this.itemPrice;
      this.products = items.clone();
      this.stock = new int[items.length];
      Arrays.fill(this.stock, initStock);
    }

    protected Inventory(Object[] items, int[] initStock) {
      if (items.length > initStock.length) {
        int ndiff = items.length - initStock.length;
        throw new IllegalArgumentException("Initial stock not provided for all available items - " + ndiff + " omitted.");
      }
      else if (initStock.length > items.length) {
        int ndiff = initStock.length - items.length;
        throw new IllegalArgumentException("Initial stock list provided contains trailing entries - " + ndiff + " additional.");
      }
      this.price = VendingMachine.this.itemPrice;
      this.products = items.clone();
      this.stock = initStock.clone();
    }

    public abstract Object dispense(int item);
    public abstract int nRemaining(Object o);
    public abstract boolean soldOut(Object o);
    public boolean soldOut( ) {
      for (Object item : this.products) {
        if (!this.soldOut(item)) {
          return false;
        }
      }
      return true;
    }
  }
}
