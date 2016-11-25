/**
 * Steven Ward
 * MachineController.java | Drink Machine Project
 *
 * This file contains the definition of the MachineController class, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MachineController {
  public static final double DRINK_PRICE = 0.75;
  public static final NumberFormat currency_format = NumberFormat.getCurrencyInstance(Locale.US);

  private int[] inventory = { 10, 10, 10 };
  private List<Coin> paid = new ArrayList<>();
  private boolean canPurchase = false;

  enum Coin {
    PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25), HALF_DOLLAR(0.50), DOLLAR(1.00);
    Coin(double val) { this.value = val; }
    public double value( ) { return this.value; }
    private final double value;
  }

  enum Drinks {
    COLA(0), LEMON_LIME(1), WATER(2);
    Drinks(int i) { this.i = i; }
    public int toInt( ) { return this.i; }
    private final int i;
  }

  public boolean canPurchase( ) { return this.canPurchase; }

  public double getAmountPaid( ) {
    double amountPaid = 0.0;
    for (Coin coin : this.paid) {
      amountPaid += coin.value();
    }
    return amountPaid;
  }

  public boolean insertCoin(final Coin coin) {
    if (this.canPurchase) {
      return false;
    }
    else {
      this.paid.add(coin);
      this.canPurchase = this.getAmountPaid() >= DRINK_PRICE ? true : canPurchase;
      return true;
    }
  }

}
