/**
 * Steven Ward
 * Inventory.java | Drink Machine Project
 *
 * This file contains the definition of the Inventory generic class.
 *
 * Due Date: December 4, 2016
 *
 */

import java.util.EnumMap;
import java.util.Map;

public class Inventory<ItemT extends Enum<ItemT>> {

  public final Class<ItemT> itemType;
  private Map<ItemT, Integer> inventory;


  public int getStock(ItemT item) {
    return inventory.get(item);
  }

  public boolean isSoldOut(ItemT item) {
    return !(getStock(item) > 0);
  }

  public boolean isSoldOut( ) {
    for (Integer i : inventory.values()) {
      if (i > 0) return false;
    }
    return true;
  }

  public boolean removeOneOf(ItemT item) {
    if (!isSoldOut(item)) {
      inventory.put(item, inventory.get(item) - 1);
      return true;
    }
    else {
      return false;
    }
  }


  public Inventory(final Class<ItemT> item_type, int[] initStock) {
    this.itemType = item_type;
    this.inventory = new EnumMap<ItemT, Integer>(itemType);
    int i = 0;
    for (ItemT key : itemType.getEnumConstants()) {
      try {
        inventory.put(key, new Integer(initStock[i]));
      }
      catch (ArrayIndexOutOfBoundsException index_except) {
        inventory.put(key, new Integer(0));
      }
      i++;
    }
  }
}
