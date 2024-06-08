/*
* UML Diagram: 
* Concrete class: 1 concrete class MUST have full tester class (model class reccomended; look at UD0 CardTester.java as example)
* Abstract class
* Inner Class
* Inheritance/Polymorphism
* Custom exception
* CAN NOT USE 2 OF THE ABOVE BUT MUST INCLUDE WHY THEY ARE EXCLUDED ON LUCIDCHART UML DIAGRAM 
*/

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
    {  
  // DECLARATION + INITIALIZATION
  //int choice = -1;
  //boolean tryAgain = true;
  NewItem[] added = {
    new NewItem("Xtra Spicy Chili Crisp", 860007570, 78182, 6, 53779, 35.80, 14.99, "A", "OZ", "UNITED", "United Natural Foods", "Fly By Jing", "Ethnic Foods", "Asian Marinade/Sauces", "Non-GMO", 6),
    new NewItem("White Chocolate Macadamia Bar", 850025501, 78182, 12, 83055, 19.76, 3.09, "A", "OZ", "UNITED", "United Natural Foods", "Kate's Real Food", "Bars", "Energy/Nutrition", "Organic", 2),
    new NewItem("Nitro Cold Brew Coffee Oat Milk Latte", 868235000, 78182, 12, 27688, 24.78, 3.89, "A", "OZ", "UNITED", "United Natural Foods", "Rise Brewing Co", "Beverage", "Coffee", "Organic", 7 ),
    new NewItem("Haunted Ghost Pepper Tortilla Chips", 891760002, 78182, 6, 87981, 20.35, 6.35, "A", "OZ", "UNITED", "United Natural Foods", "Paqui", "Chips", "Corn/Tortilla", "Non-GMO", 7),
    new NewItem("Strawberry Crumble Ice Cream", 850015096, 78182, 8, 15489, 42.58, 10.29, "A", "OZ", "UNITED", "United Natural Foods", "Alec's Ice Cream", "Frozen", "Dessert Items", "Organic", 14),
    new NewItem("Smart Plant-Based Bacon Box", 434541010, 78182, 12, 12210, 39.11, 6.09, "A", "OZ", "UNITED", "United Natural Foods", "Lightlife Foods", "Refrigerated Products", "Meat Alternatives - Breakfast", "Vegan", 5)
  };

  // WELCOME
  System.out.println("Preloading New Item Box...");
  NewItemBox myBox = new NewItemBox(added);
  System.out.println("...Done!\n");

  System.out.println("---------------------------");
  System.out.println("| Welcome to NewItem Box! |");
  System.out.println("---------------------------\n");
  System.out.println(myBox);
//EVERYTHING ABOVE REMOVE IF NEEDED 
  
   
    ItemMaintenance[] inventory = new ItemMaintenance[10];
    Scanner keyboard = new Scanner(System.in);
    // Prompt user with options in a loop
    int choice, distributorNumber = 0, vendorCase = 0, vendorProductNumber = 0, upc = 0, size = 0, startMonth = 0, startDay = 0, startYear = 0, endMonth = 0, endDay = 0, endYear = 0, count = 0;
    String itemDescription = null, brand, category, subCategory, attributes, maintenanceType, unit, distributorIdentification, distributorName;
    double retail = 0.0, caseCost = 0.0, salePrice = 0.0;

    do{
      System.out.println();
      System.out.println("1) Enter new New Item");
      System.out.println("2) Enter new Item Promotion");
      System.out.println("3) Print full Maintenance List");
      System.out.println("4) Exit");
      System.out.print(">> ");
      choice = keyboard.nextInt();
      keyboard.nextLine(); //clean buffer   

      if(choice >= 1 && choice <= 2){
        //Item Maintenance data: 
        System.out.print("Enter item description      : ");
        itemDescription = keyboard.nextLine();
        System.out.print("Enter upc (9 digit whole number)     : ");
        upc = keyboard.nextInt();
        System.out.print("Enter assigned distributor number (5 digit whole number)   : ");
        distributorNumber = keyboard.nextInt();
        System.out.print("Enter vendor case quantity     : ");
        vendorCase = keyboard.nextInt();
        System.out.print("Enter vendor assigned product number (5 digit whole number)    : ");
        vendorProductNumber = keyboard.nextInt();
        System.out.print("Enter vendor case cost     $ ");
        caseCost = keyboard.nextDouble();
        System.out.print("Enter retail     $ ");
        retail = keyboard.nextDouble();
        keyboard.nextLine(); //clear newline in buffer 
        }

       //getting derived class specific data  
        switch (choice)
        {
          case 1: 
              //New Item data
              System.out.print("Enter maintenance type (new items always A): ");
              maintenanceType = keyboard.nextLine();
              System.out.print("Enter single item unit (ounce, each, pound): ");
              unit = keyboard.nextLine();
              System.out.print("Enter distributor identification (shortened name): ");
              distributorIdentification = keyboard.nextLine();
              System.out.print("Enter distributor name (full name): ");
              distributorName = keyboard.nextLine();
              System.out.print("Enter item brand name: ");
              brand = keyboard.nextLine();
              System.out.print("Enter items generic category: ");
              category = keyboard.nextLine();
              System.out.print("Enter items specific category: ");
              subCategory = keyboard.nextLine();
              System.out.print("Enter items attributes (organic, gluten free): ");
              attributes = keyboard.nextLine();
              System.out.print("Enter single item size (whole number): ");
              size = keyboard.nextInt();
  
              //Create a new item put into array
              inventory[count] = new NewItem(itemDescription, upc, distributorNumber, vendorCase, vendorProductNumber, caseCost, retail, maintenanceType, unit, distributorIdentification, distributorName, brand, category, subCategory, attributes, size);

              count++;
              break;

          case 2:
                //Item promotion specific data
                //name, assuring run passes is 0 but could input that data here if you wanted to 
              System.out.print("Enter maintenance type (item promotions are always C): ");
              maintenanceType = keyboard.nextLine();
              System.out.print("Enter items sale price (must be lower than retail):     $  ");
              salePrice = keyboard.nextDouble();
              System.out.print("Enter promotion start month (01, 12): ");
              startMonth = keyboard.nextInt();
              System.out.print("Enter promotion start day (01, 30): ");
              startDay = keyboard.nextInt();
              System.out.print("Enter promotion start Year (2024): ");
              startYear = keyboard.nextInt();
              System.out.print("Enter promotion end month (01, 12): ");
              endMonth = keyboard.nextInt();
              System.out.print("Enter promotion end day (01, 30): ");
              endDay = keyboard.nextInt();
              System.out.print("Enter promotion end Year (2024): ");
              endYear = keyboard.nextInt();
  
            //Create a Item promotion, put into array 
                inventory[count] = new ItemPromotion(itemDescription, upc, distributorNumber, vendorCase, vendorProductNumber, caseCost, retail, maintenanceType, salePrice, startMonth, startDay, startYear, endMonth, endDay, endYear);

              count++;
              break;

          case 3:
              //print all maintenance items
              System.out.println("\n\nFull maintenance queue :");
            Main.printItems(added, count);

              break;
      default:
              System.out.println("ERROR: not a valid choice. Please try again. \n");
       }

    } while (choice != 3);

      keyboard.close();
  }

/*
  * Prints all items in partially filled array, numbered in array order
  *
  * @param items partially filled array with item maintenance queue  
  * @param numItems size of partially filled aray 
*/  

  public static void printItems(NewItem[] added, int count){
    for(int i = 0; i < count; i++){
      //System.out.println("Item #" + (i + 1) + " = " + added[i].toString());
      System.out.println("Item #" + (i + 1) + " = " + added[i].getItemDescription());
    }
  }

}