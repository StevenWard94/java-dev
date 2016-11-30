/**
 * Steven Ward
 * Transactable.java | Drink Machine Project
 *
 * This file contains the definition of the Transactable interface, which is described below.
 *
 * Due Date: December 4, 2016
 *
 */


/**
 * TODO: CLASS-LEVEL DOCUMENTATION FOR TRANSACTABLE INTERFACE!
 *       JAVADOC TAGS
 */

public interface Transactable {

  DispenseStatus tryDispense(int i);
  <Item extends Enum<Item>> DispenseStatus tryDispense(Item p);

  <Item extends Enum<Item>> Item dispense(int itemNo);
  <Item extends Enum<Item>> Item dispense(Item item);

}
