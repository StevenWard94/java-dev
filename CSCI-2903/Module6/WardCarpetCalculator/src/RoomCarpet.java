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
 * @see #size
 * @see #carpetCost
 * @see #getTotalCost
 * @see #toString
 * @see RoomDimension
 * @see WardCarpetCalculator#main(String[] args)
 */

public class RoomCarpet {

  private final RoomDimension size;
  private final double carpetCost;

  public RoomCarpet(RoomDimension dim, double cost) {
    this.size = dim;
    this.carpetCost = cost;
  }


  public double getTotalCost() {
    return this.size.getArea() * this.carpetCost;
  }


  public String toString() {
    return ( this.size.toString() + ", which at $" + this.carpetCost + " per sq ft, will cost a total of $" + this.getTotalCost() );
  }
}
