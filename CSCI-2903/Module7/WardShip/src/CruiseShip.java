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

  private int passengerCap_;  /** the ship's maximum occupancy */

  /**
   * Provides access to private member field, 'passengerCap_'.
   * Allows the value of 'passengerCap_' to be accessed from outside this class definition,
   * especially from external implementations of the 'Ship' class and its subclasses or if this
   * hierarchy were to be further extended.
   * Not to be confused with CargoShip's 'capacity()' member.
   *
   * @return       int value currently held by the instance's 'passengerCap_' member
   * @see          #passengerCap_
   * @see          #capacity(int)
   * @see          #CruiseShip(String,String,int)
   * @see          CargoShip#capacity( )
   */
  public int capacity( ) {
    return this.passengerCap_;
  }


  /**
   * Provides mutator-access to private member field, 'passengerCap_'.
   * Allows the value of 'passengerCap_' to be modified from outside this class definition,
   * especially from external implementations of the 'Ship' class and its subclasses or if this
   * hierarchy were to be further extended. Not to be confused with CargoShip's 'capacity(int)'
   * member.
   *
   * @param  cap   int value that is to be referenced by the instance's 'passengerCap_' member
   * @see          #passengerCap_
   * @see          #capacity( )
   * @see          #CruiseShip(String,String,int)
   * @see          CargoShip#capacity(int)
   */
  public void capacity(int cap) {
    this.passengerCap_ = cap;
  }


  /**
   * Provides a specialized String representation of the data relating to a CruiseShip object.
   * Overrides the 'toString' method defined in, and inherited from, the 'Ship' class. Returns
   * a human-readable description of the calling instance, similar to that of the 'Ship' class, but
   * with the latter half describing the ship's maximum occupancy ('passengerCap_') INSTEAD OF the
   * year in which it was built.
   *
   * @return       String with the format: "The ${NAME}, with a capacity of ${CAPACITY} passengers."
   * @see          #passengerCap_
   * @see          Ship#name_
   * @see          Ship#name( )
   * @see          Ship#toString( )
   */
  @Override public String toString( ) {
    return ( "The " + this.name() + ", with a capacity of "
            + this.passengerCap_ + " passengers." );
  }


  /**
   * Single constructor of this class.
   * Behaves like an "extension" of the constructor provided by the 'Ship' class. Its first two
   * arguments are identical to those of the 'Ship' constructor and are used to call it. The third
   * parameter corresponds to this class's additional member field, 'passengerCap_', which is
   * initialized separately from the inherited fields.
   *
   * @param  name  String object containing the ship's name
   * @param  year  String object containing the year in which the ship was built
   * @param  cap   int value representing the ship's maximum occupancy
   * @see          #passengerCap_
   * @see          #capacity(int)
   * @see          Ship#name_
   * @see          Ship#year_
   * @see          Ship#Ship(String,String)
   */
  public CruiseShip(String name, String year, int cap) {
    super(name, year);
    this.capacity(cap);
  }

}
