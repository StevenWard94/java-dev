/**
 * Steven Ward
 * RoomDimension.java | Carpet Calculator Project
 *
 * This file contains the definition of the RoomDimension class, which is described below.
 *
 * Due Date: October 09, 2016
 *
 */

/**
 * RoomDimension class to "wrap" the dimensions of a room.
 * The 'RoomDimension' class exists to provide an additional layer of encapsulation for the
 * underlying data used by an instance of the 'RoomCarpet' class. Instances of the 'RoomDimension'
 * class possess two (2) private, member fields, 'length' and 'width', which represent the length
 * and width, in feet, of a room, respectively. This class does not provide accessor functions for
 * these fields, as their exact values are irrelevant to the program's implementation. Instead,
 * a 'getArea()' member function is provided to return the product of that instance's 'length' and
 * 'width' fields as a double type. The only other function provided is the 'toString()' member
 * function, which returns a String output of the information contained in, and provided by, an
 * instance of the 'RoomDimension' class. A public constructor is also provided.
 *
 * @see #length
 * @see #width
 * @see #getArea
 * @see #toString
 * @see RoomCarpet
 * @see RoomCarpet#size
 */

public class RoomDimension {

  private final double length;  // A room's length in feet.
  private final double width;   // A room's width in feet.

  public RoomDimension(double len, double w) {
    this.length = len;
    this.width = w;
  }

  public double getArea() {
    return this.length * this.width;
  }

  public String toString() {
    return ( "The room is " + this.length + "ft x " + this.width + "ft, giving it an area of " + this.getArea() + "sq ft" );
  }
}
