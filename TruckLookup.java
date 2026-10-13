/* Class Name: TruckLookup
Student Number: 23302287
Class Description: Manages the food truck systems. It asks the use for input asking what the user is looking for then gives information back based on user input. */




import java.io.*;
import java.util.*;


public class TruckLookup
{

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = kb.nextLine();
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);

        if (!inputFile.hasNextLine())
        {
            System.out.println("\"" + fileName + "\" is an empty file. The program will now close.");
            return;
        }

        System.out.print("Enter cuisine type: ");
        String searchCuisine = kb.nextLine();

        boolean found = false;

        while (inputFile.hasNextLine())
        {

            String line = inputFile.nextLine();
            String[] parts = line.split("\\|");

            String truckName = parts[0];
            String cuisine = parts[1];
            String zone = parts[2];
            double rating = Double.parseDouble(parts[3]);
            String speciality = parts[4];

            if (cuisine.equalsIgnoreCase(searchCuisine))

            {
                if (!found)
                {
                    System.out.println("Trucks serving " + searchCuisine + " cuisine:");

                }
                found = true;

                System.out.println("Truck: " + truckName);
                System.out.println("Zone: " + zone);
                System.out.printf("Rating: %.2f / 5.00%n", rating);
                System.out.println("Speciality: " + speciality);
            }


           

        }

        if (!found)
        {
            System.out.println("No trucks found serving the " + searchCuisine + " cuisine");


        }
        
        inputFile.close();
       

      
        
    }
}