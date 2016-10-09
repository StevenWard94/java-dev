/**
 * Steven Ward
 * WardCarInstrument.java | Car Instrument Simulator Project
 *
 * This file contains the definition for the program's general execution, which is described below.
 *
 * Due Date: October 09, 2016
 *
 */

public class WardCarInstrument {

  private class Car {
    public static final int FUEL_ECONOMY = 24;
    public final FuelGauge fuelGauge;
    public final Odometer odometer;

    public Car() {
      this.fuelGauge = new FuelGauge();
      this.odometer = new Odometer();
    }

    public void refuel() {
      System.out.println("Current fuel level: " + fuelGauge.getFuelLevel() + " gal. Refueling...");
      while ( fuelGauge.incrementFuel() ) {
        System.out.println("Current fuel level: " + fuelGauge.getFuelLevel() + " gal.");
      }
      System.out.println("Vehicle is fully refueled.");
    }

    public void drive() {
      System.out.println("Going for a drive!");
      while ( fuelGauge.getFuelLevel() > 0 ) {
        int fuel = fuelGauge.getFuelLevel();
        for (int i = 0; i < FUEL_ECONOMY; i++) {
          odometer.incrementMileage();
          System.out.println
        }
      }
    }
  }
}
