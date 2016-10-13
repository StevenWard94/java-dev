/**
 * Steven Ward
 * Odometer.java | Car Instrument Simulator Project
 *
 * This file contains the definition of the Odometer class, which is described below.
 *
 * Due Date: October 09, 2016
 *
 */

package wardCarInstrument;

/**
 * Odometer class to simulate a car's odometer.
 *
 * TODO: DOCUMENT THE ODOMETER CLASS AND ITS MEMBERS
 *
 */

public class Odometer {

  private int mileage;

  public Odometer() {
    this.mileage = 0;
  }

  public int getMileage() {
    return this.mileage;
  }

  public int incrementMileage() {
    this.mileage = this.mileage == 999999 ? 0 : this.mileage + 1;
    return this.mileage;
  }
}
