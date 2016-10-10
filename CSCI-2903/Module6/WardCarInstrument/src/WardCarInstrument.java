/**
 * Steven Ward
 * WardCarInstrument.java | Car Instrument Simulator Project
 *
 * This file contains the definition for the program's general execution, which is described below.
 *
 * Due Date: October 09, 2016
 *
 */

import java.util.Scanner;

public class WardCarInstrument {

  public static void main(String[] args) {
    WardCarInstrument wci = new WardCarInstrument();
    Car vehicle = wci.new Car();

    System.out.println("We have a car ready just for you!");
    System.out.println("Hit \"Enter\" to get in!");
    pause();

    System.out.println("Oh no! It looks like the car is out of gas...");
    System.out.println("No Worries! Hit \"Enter\" to fuel up!");
    pause();
    vehicle.refuel();

    System.out.println();
    System.out.println("Super! How about we take this baby for a test drive?");
    System.out.println("Hit \"Enter\" one more time to get on the road!");
    System.out.println();
    pause();

    vehicle.drive();
    System.out.println();
    System.out.println("Wow! Wasn't that fun?");
    System.out.println("Well, we're out of time - and gas - so I guess this is goodbye...");
    System.out.println("I hope to drive with you again soon!");
  }


  private class Car {
    public static final int FUEL_ECONOMY = 24;
    public final FuelGauge fuelGauge;
    public final Odometer odometer;

    public Car() {
      this.fuelGauge = new FuelGauge();
      this.odometer = new Odometer();
    }

    private void applyFuelEconomy() {
      if ( odometer.getMileage() % FUEL_ECONOMY == 0 ) {
        fuelGauge.decrementFuel();
      }  // else { }
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
          odometer.incrementMileage();
          this.applyFuelEconomy();  // Fuel decremented here, if necessary.

          int mileage = odometer.getMileage();
          int amtFuel = fuelGauge.getFuelLevel();

          String readout = "Mileage: " + mileage + (mileage == 1 ? " mile," : " miles,")
            + "  Fuel Level: " + amtFuel + (amtFuel == 1 ? " gallon" : " gallons");
          System.out.println(readout);
      }
      System.out.println("Out of gas! Need to refuel...");
      System.out.println("We traveled a total of " + odometer.getMileage() + " miles!");
    }
  }


  private static void pause() {
    Scanner in = new Scanner(System.in);
    in.nextLine();
  }
}
