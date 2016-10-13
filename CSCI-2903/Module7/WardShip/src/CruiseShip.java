/**
 * Steven Ward
 * CruiseShip.java | Ship, CruiseShip, and CargoShip Classes Project
 *
 * This file contains the definition of the CruiseShip class, which is described below.
 *
 * Due Date: October 16, 2016
 *
 */

/**
 * TODO: BRIEF DESCRIPTION OF CRUISESHIP CLASS.
 * TODO: DETAILED DESCRIPTION OF CRUISESHIP CLASS.
 *
 * @see            Ship
 * @see            CargoShip
 */
public class CruiseShip extends Ship {

  private int passengerCap_;

  /**
   * Provides access to private member field, 'passengerCap_'.
   * Allows the value of 'passengerCap_' to be accessed from outside this class definition,
   * especially from external implementations of the 'Ship' class and its subclasses or if this
   * hierarchy is to be further extended.
   *
   * @see          #passengerCap_
   * @see          #capacity(int)
   * @see          #CruiseShip(String,String,int)
   */
  public int capacity( ) {
    return this.passengerCap_;
  }


  /**
   * Provides mutator-access to private member field, 'passengerCap_'.
   * Allows the value of 'passengerCap_' to be accessed, and modified, from outside this class
   * definition, especially from external implementations of the 'Ship' class and its subclasses or
   * if this hierarchy is to be further extended.
   *
   * @param  cap   int value that is to be referenced by the instance's 'passengerCap_' member
   * @see          #passengerCap_
   * @see          #capacity( )
   * @see          #CruiseShip(String,String,int)
   */
  public void capacity(int cap) {
    this.passengerCap_ = cap;
  }


  @Override public String toString( ) {
    return ( "The " + this.name() + ", with a capacity of "
            + this.passengerCap_ + " passengers." );
  }


  public CruiseShip(String name, String year, int cap) {
    super(name, year);
    this.capacity(cap);
  }

}
