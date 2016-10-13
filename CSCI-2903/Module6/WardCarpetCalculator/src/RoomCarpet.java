/**
 * Steven Ward
 * RoomCarpet.java | Carpet Calculator Project
 *
 * This file contains the definition of the RoomCarpet class, which is described below.
 *
 * Due Date: October 09, 2016
 *
 */

/**
 * RoomCarpet class to "wrap" the general process of determining the cost to carpet a room.
 * The 'RoomCarpet' class serves as a sort of "model" component for this (Carpet Calculator)
 * program. It stores user input in its two member fields: 1) 'size', which stores length and width
 * values retrieved from the user and calculates the corresponding area, and 2) 'carpetCost' to hold
 * the price per square foot of carpet provided by the user. With those above fields containing
 * acceptable values, the total cost to carpet a room can be calculated by the 'getTotalCost()'
 * member function and presented to the user, along with the data, with th 'toString()' member
 * function.
 *
 */
public class RoomCarpet {

  private final RoomDimension size;  // dimensions of the room, given as RoomDimension object
  private final double carpetCost;   // unit cost of the carpet, in dollars per square foot

  /**
   * Sole constructor.
   * Creates an instance of the RoomCarpet class from two parameters, which are used to initialize
   * the corresponding member fields for the instance.
   *
   * @param dim    RoomDimension object containing the length and width of the room
   * @param cost   double value representing the carpet's unit cost in dollars per square foot
   *
   * @see          #size
   * @see          #carpetCost
   * @see          RoomDimension#length
   * @see          RoomDimension#width
   * @see          RoomDimension#RoomDimension(double,double)
   *
   */
  public RoomCarpet(RoomDimension dim, double cost) {
    this.size = dim;
    this.carpetCost = cost;
  }


  /**
   * Calculates the total cost of carpeting a room.
   * Uses the getArea() function of the instance's size member, and the value of its carpetCost
   * member to determine the total cost of carpeting the room represented by its RoomCarpet
   * instance.
   *
   * @return  double value representing the total cost of carpeting
   *
   * @see     #size
   * @see     #carpetCost
   * @see     RoomDimension#getArea()
   *
   */
  public double getTotalCost() {
    return this.size.getArea() * this.carpetCost;
  }


  /**
   * Translates the instance's data into a String object.
   * Generates a String which expresses the data contained in the instance's size member (through
   * the object's own toString() member function) and carpetCost member.
   *
   * @return  String containing the relevant data corresponding to the instance
   *
   * @see     #size
   * @see     #carpetCost
   * @see     RoomDimension#toString()
   *
   */
  public String toString() {
    return ( this.size.toString() + ", which at $" + this.carpetCost + " per sq ft, will cost a total of $" + this.getTotalCost() );
  }
}
