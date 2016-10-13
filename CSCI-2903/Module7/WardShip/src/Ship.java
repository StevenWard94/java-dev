/**
 * Steven Ward
 * Ship.java | Ship, CruiseShip, and CargoShip Classes Project
 *
 * This file contains the definition of the Ship class, which is described below.
 *
 * Due Date: October 16, 2016
 *
 */

/**
 * Represents the general "definition" of a ship, in any form.
 * Primarily intended to serve as a base class for ships having a more explicitly defined type. It
 * declares two member fields to hold the String values for the ship's name and the year in which it
 * was built. Apart from these two fields and their respective accessor/mutator methods, this class
 * also contains a 'toString()' member function, which generates a "human-readable" String giving
 * the ship's name and the year it was built. There is also a single constructor, which takes two
 * String parameters and assigns them to their corresponding member variables.
 *
 * @see CruiseShip
 * @see CargoShip
 * @see #name_
 * @see #year_
 * @see #Ship(String,String)
 * @see #toString( )
 */
public class Ship {

  private String name_;  /** the ship's name */
  private String year_;  /** year the ship was built. */

  /**
   * Provides access to private member field, 'name_'.
   * Allows the value of 'name_' to be accessed from outside this class definition, especially from
   * within the definitions of classes derived from this one. Declared with the 'final' modifier to
   * prevent unnecessary and/or problematic overrides in subclasses.
   *
   * @return String    the String referenced by the instance's 'name_' member
   *
   * @see              #name_
   * @see              #name(String)
   * @see              #Ship(String,String)
   */
  public final String name( ) {
    return this.name_;
  }


  /**
   * Provides mutator-access to private member field, 'name_'.
   * Allows the value of 'name_' to be accessed, and modified, from outside this class definition,
   * especially from within the definitions of classes derived from this one. Declared with the
   * 'final' modifier to prevent unnecessary and/or problematic overrides in subclasses.
   *
   * @param name       the String that is to be referenced by the instance's 'name_' member
   *
   * @see              #name_
   * @see              #name( )
   * @see              #Ship(String,String)
   */
  public final void name(String name) {
    this.name_ = name;
  }


  /**
   * Provides access to private member field, 'year_'.
   * Allows the value of 'year_' to be accessed from outside this class definition, especially from
   * within the definitions of classes derived from this one. Declared with the 'final' modifier to
   * prevent unnecessary and/or problematic overrides in subclasses.
   *
   * @return String    the String referenced by the instance's 'year_' member
   *
   * @see              #year_
   * @see              #year(String)
   * @see              #Ship(String,String)
   */
  public final String year( ) {
    return this.year_;
  }


  /**
   * Provides mutator-access to private member field, 'year_'.
   * Allows the value of 'year_' to be accessed, and modified, from outside this class definition,
   * especially from within the definitions of classes derived from this one. Declared with the
   * 'final' modifier to prevent unnecessary and/or problematic overrides in subclasses.
   *
   * @param year       the String that is to be referenced by the instance's 'year_' member
   *
   * @see              #year_
   * @see              #year( )
   * @see              #Ship(String,String)
   */
  public final void year(String year) {
    this.year_ = year;
  }


  /**
   * Single constructor of this class.
   * Accepts two String parameters, the first containg the ship's name, and the second containing
   * the year in which the ship was built. These Strings are assigned to the corresponding member
   * fields of the newly-instantiated 'Ship' object.
   *
   * @param name    String object containing the ship's name
   * @param year    String object containing the year in which the ship was built
   * @see           #name_
   * @see           #year_
   * @see           CruiseShip#CruiseShip(String,String,int)
   * @see           CargoShip#CargoShip(String,String,int)
   */
  public Ship(String name, String year) {
    this.name(name);
    this.year(year);
  }
}
