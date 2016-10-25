/**
 * Steven Ward
 * CargoShip.java | Ship, CruiseShip, and CargoShip Classes Project
 *
 * This file contains the definition of the CargoShip class, which is described below.
 *
 * Due Date: October 16, 2016
 *
 */

/**
 * TODO: BRIEF DESCRIPTION OF CARGOSHIP CLASS.
 * TODO: DETAILED DESCRIPTION OF CARGOSHIP CLASS.
 * TODO: TAGS and COMPLETE DOCUMENTATION.
 *
 * @see            Ship
 * @see            CruiseShip
 */
public class CargoShip extends Ship {

  private int cargoCap_;  /** the ship's deadweight tonnage (cargo weight in tons) */


  /**
   * Provides access to private member field, 'cargoCap_'.
   * Allows the value of 'cargoCap_' to be accessed from outside this class definition, especially
   * from external implementations of the 'Ship' class and its subclasses or if this hierarchy were
   * to be further extended.
   * Not to be confused with CruiseShip's 'capacity()' member.
   *
   * @return       int value currently help by the instance's 'cargoCap_' member
   * @see          #cargoCap_
   * @see          #capacity(int)
   * @see          #CargoShip(String,String,int)
   * @see          CruiseShip#capacity( )
   */
  public int capacity( ) {
    return this.cargoCap_;
  }


  /**
   * Provides mutator-access to private member field 'cargoCap_'.
   * Allows the value of 'cargoCap_' to be modified from outside this class definition, especially
   * from external implementations of the 'Ship' class and its subclasses or if this hierarchy were
   * to be further extended.
   * Not to be confused with CruiseShip's 'capacity(int)' member.
   *
   * @param  cap   int value that is to be referenced by the instance's 'cargoCap_' member
   * @see          #cargoCap_
   * @see          #capacity( )
   * @see          #CargoShip(String,String,int)
   * @see          CruiseShip#capacity(int)
   */
  public void capacity(int cap) {
    this.cargoCap_ = cap;
  }


  /**
   * Provides a specialized String representation of the data relating to a CargoShip object.
   * Overrides the 'toString' method defined in, and inherited from, the 'Ship' class. Returns
   * a human-readable description of the calling instance, similar to that of the 'Ship' class, but
   * with the latter half describing the ship's deadweight tonnage (max cargo weight - 'cargoCap_')
   * INSTEAD OF the year in which it was built.
   *
   * @return       String with the format: "The ${NAME}, with a deadweight tonnage of ${CAPACITY}."
   * @see          #cargoCap_
   * @see          Ship#name_
   * @see          Ship#name( )
   * @see          Ship#toString( )
   */
  @Override public String toString( ) {
    return ( "The " + this.name() + ", with a deadweight tonnage of " + this.cargoCap_ + "." );
  }


  /**
   * Single constructor of this class.
   * Behaves like an "extension" of the constructor provided by the 'Ship' class. Its first two
   * arguments are identical to those of the 'Ship' constructor and are used to call it. The third
   * parameter corresponds to this class's additional member field, 'cargoCap_', which is
   * initialized separately from the inherited fields.
   *
   * @param  name  String object containing the ship's name
   * @param  year  String object containing the year in which the ship was built
   * @param  cap   int value representing the ship's maximum cargo capacity
   * @see          #cargoCap_
   * @see          #capacity(int)
   * @see          Ship#name_
   * @see          Ship#year_
   * @see          Ship#Ship(String,String)
   */
  public CargoShip(String name, String year, int cap) {
    super(name, year);
    this.capacity(cap);
  }
}
