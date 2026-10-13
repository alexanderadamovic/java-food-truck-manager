/*
 * Class Name:       RallyManager
 * Student Number:   23302287
 * Class Description: Driver class for the Food Truck Manager system.
 *                    Manages up to two Zone objects and provides a menu.
 */

import java.util.Scanner;

public class RallyManager
{
    // ----- Attributes -----
    private Zone zone1;
    private Zone zone2;
    private Scanner kb;


    // ----- main -----
    public static void main(String[] args)
    {
        RallyManager rm = new RallyManager();
        rm.run();
    }


    // ----- Constructor -----
    public RallyManager()
    {
        zone1 = null;
        zone2 = null;
        kb = new Scanner(System.in);
    }


    // ----- Menu loop -----
    // Runs until the user chooses Exit (option 5).
    public void run()
    {
        int choice = 0;
        while (choice != 5)
        {
            displayMenu();
            choice = kb.nextInt();
            kb.nextLine();  // consume the leftover newline after nextInt
            process(choice);
        }
    }


    // ----- Print the menu -----
    public void displayMenu()
    {
        System.out.println();
        System.out.println("Food Truck Manager - Main Menu");
        System.out.println("  1. Add Zone: ");
        System.out.println("  2. Assign Truck to Zone: ");
        System.out.println("  3. Update Truck Rating: ");
        System.out.println("  4. Display: ");
        System.out.println("  5. Exit: ");
        System.out.print("Enter choice:  ");
    }


    // ----- Route the menu choice to the correct method -----
    public void process(int choice)
    {
        switch (choice)
        {
            case 1: addZone();      break;
            case 2: assignTruck();  break;
            case 3: updateRating(); break;
            case 4: display();      break;
            case 5: System.out.println("See you around!"); break;
            default: System.out.println("Invalid choice, please try again.");
        }
    }


    // ----- Menu option 1 -----
    public void addZone()
    {
        if (zone1 != null && zone2 != null)
        {
            System.out.println("Both Zone slots are already taken.");
            return;
        }

        System.out.print("Enter Zone name: ");
        String zoneName = kb.nextLine();

        if ((zone1 != null && zone1.getZoneName().equalsIgnoreCase(zoneName)) ||
        (zone2 != null && zone2.getZoneName().equalsIgnoreCase(zoneName)))
        {
            System.out.println("This Zone name already exists.");
            return;
        }

        if (zone1 == null)
        {
            zone1 = new Zone(zoneName);
        }
        else
        {
            zone2 = new Zone(zoneName);
        }

    }


    // ----- Menu option 2 -----
    public void assignTruck()
    {
     
        if (zone1 == null && zone2 == null)
        {
            System.out.println("Cannot assign Truck because there are no zones. Please add a Zone.");
            return;
        }

        System.out.print("Enter Zone Name: ");
        String zoneName = kb.nextLine();

        Zone selectedZone = null;


        if (zone1 != null && zone1.getZoneName().equalsIgnoreCase(zoneName))
        {
            selectedZone = zone1;
        }
        else if (zone2 != null && zone2.getZoneName().equalsIgnoreCase(zoneName))
        {
            selectedZone = zone2;
        }

        if (selectedZone == null)
        {
            System.out.print("Zone not found");
            return;
        }

        if (selectedZone.hasTruck())
        {
            System.out.println("This Zone already has a Truck.");
            return;
        }

        System.out.print("Enter Truck Id: ");
        String TruckId = kb.nextLine();

        if ((zone1 != null && zone1.getTruckId().equalsIgnoreCase(TruckId)) ||
         (zone2 != null && zone2.getTruckId().equalsIgnoreCase(TruckId)))
        {
            System.out.println("Truck Id already exists. ");
            return;
        }

        System.out.print("Enter Truck name: ");
        String TruckName = kb.nextLine();
        
        System.out.print("Enter Cuisine: ");
        String cuisine = kb.nextLine();

        selectedZone.addTruck(TruckId, TruckName, cuisine);

    }



    // ----- Menu option 3 -----
    public void updateRating()
    {
        if (zone1 == null && zone2 == null)
        {
            System.out.println("Cannot update rating, no Zones.");
            return;
        }


        System.out.print("Enter Zone name: ");
        String zoneName = kb.nextLine();

        Zone selectedZone = null;

        if (zone1 != null && zone1.getZoneName().equalsIgnoreCase(zoneName))
        {
            selectedZone = zone1;
        }
        else if (zone2 != null && zone2.getZoneName().equalsIgnoreCase(zoneName))
        {
            selectedZone = zone2;
        }
        if (selectedZone == null)
        {
            System.out.println("Zone not found.");
            return;
        }

        if (!selectedZone.hasTruck())
        {
            System.out.println("No Truck is assinged to this Zone.");
            return;
        }

        System.out.print("Enter new rating (0-5): ");
        int newRating = kb.nextInt();
        kb.nextLine();

        if (newRating < 0 || newRating > 5)
        {
            System.out.println("The rating must be between 0 and 5. The rating has been unchanged.");
            return;
        }

        selectedZone.updateTruckRating(newRating);
        System.out.println("Rating updated.");
    }



    // ----- Menu option 4 -----
    public void display()
    {
       if (zone1 == null && zone2 == null)
       {
        System.out.println("There are no Zones in the system.");
       }
       else
       {
        if (zone1 != null)
        {
            System.out.println(zone1);
        }

        if (zone2 != null)
        {
            System.out.println(zone2);
        }
       }
    }
}
