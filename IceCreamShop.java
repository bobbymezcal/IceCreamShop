import java.util.Scanner;

class ShopItems {
    // INSTANCE FIELDS
    int totalCount;

    // NESTED CLASSES
    class NonVegan {
        //INSTANCE FIELDS
        int iceCreamCount, shakeCount, totalCount;

        public void increaseCount(int type, int count) {
            if (type == 1) iceCreamCount += count;
            if (type == 2) shakeCount += count;
            totalCount += count;
            ShopItems.this.totalCount += count;
        }
    }

    class Vegan {
        // INSTANCE FIELDS
        int smoothieCount, slushieCount, totalCount;

        public void increaseCount(int type, int count) {
            if (type == 3) smoothieCount += count;
            if (type == 4) slushieCount += count;
            totalCount += count;
            ShopItems.this.totalCount += count;
        }
    }
}

public class IceCreamShop {

  public static void main(String[] args) {
    ShopItems shopItems = new ShopItems();
    ShopItems.NonVegan nonVegan = shopItems.new NonVegan();
    ShopItems.Vegan vegan = shopItems.new Vegan();

    int orderType = 0;
    Scanner input = new Scanner(System.in);
    int itemCount = 0;
    String itemName;

    System.out.println("\n\nHello! Welcome to the ice cream shop. \nWe are ready to take your order. \n\nFor ice-cream type 1, for shakes type 2, for smoothies type 3, and for slushies type 4. \nIf you are done ordering type 0.");
    orderType = input.nextInt();

    while(orderType != 0) {
      System.out.println("How many items of this item would you like to order?");
      itemCount = input.nextInt();
      if(orderType == 1){
        itemName = "ice cream"; nonVegan.increaseCount(orderType, itemCount);
      } else if(orderType == 2) {
        itemName = "shake"; nonVegan.increaseCount(orderType, itemCount);
      } else if(orderType == 3) {
        itemName = "smoothie"; vegan.increaseCount(orderType, itemCount);
      } else if(orderType == 4) {
        itemName = "slushie"; vegan.increaseCount(orderType, itemCount);
      } else {
        break;
      }

      System.out.println("Adding " + itemCount + " of the item "+ itemName + " to your order!");

      System.out.println("\n\nType a number for the next item in your order:\n1: Ice cream\n2: Shake\n3: Smoothie\n4: Slushie\n\nIf you are done ordering type 0.");
      orderType = input.nextInt();
    }
    System.out.println("Thank you for your order! Today we have sold " + shopItems.totalCount + " orders of sweetness!");
    System.out.println(nonVegan.totalCount + " items have been ice cream and shakes");
    System.out.println(vegan.totalCount + " items have been smoothies and slushies");
  }
}