/**
 * Steven Ward
 * FuelGauge.java | Car Instrument Simulator Project
 *
 * This file contains the definition of the FuelGauge class, which is described below.
 *
 * Due Date: October 09, 2016
 *
 */

/**
 * FuelGauge class to simulate a car's fuel gauge.
 *
 * TODO: DOCUMENT FUELGAUGE CLASS AND ITS MEMBERS
 *
 */

public class FuelGauge {

  public static final int TANK_VOLUME = 15;


  private int fuelLevel;

  public FuelGauge() {
    this.fuelLevel = 0;
  }

  public int getFuelLevel() {
    return this.fuelLevel;
  }

  public boolean incrementFuel() {
    boolean fullTank = ( this.fuelLevel >= TANK_VOLUME  );
    this.fuelLevel += fullTank ? 0 : 1;
    return !fullTank;
  }

  public boolean decrementFuel() {
    boolean emptyTank = ( this.fuelLevel <= 0 );
    this.fuelLevel -= emptyTank ? 0 : 1;
    return !emptyTank;
  }
}
