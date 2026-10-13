import java.util.*;

public class ShiftSimulator 
{
   
    public static void main(String[] args) 
    {

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of customers (5-30): ");
        int customers = kb.nextInt();

        while (customers < 5 || customers > 30)
        {
            System.out.println("Invalid, please enter a number between (5 and 30): ");
            customers = kb.nextInt();
        }


        System.out.print("Enter Revenue goal $: ");
        double revenueGoal = kb.nextDouble();

        while (revenueGoal <=0)
        {
            System.out.print("Invalid, please enter a positive revenue goal $: ");
            revenueGoal = kb.nextDouble();

        }

        Random rand = new Random();
        double totalRevenue = 0;

        for (int i = 1; i <= customers; i++)
        {
            double order = 5 + (25 * rand.nextDouble());

            totalRevenue = totalRevenue + order; 

            System.out.printf("Customer %d order: $%.2f%n and Running total: $%.2f%n", i, order, totalRevenue);
            

            
        }

        double averageOrder = totalRevenue / customers; 

        System.out.println("Shift Summary");
        System.out.printf("Total revenue: $%.2f%n", totalRevenue);
        System.out.printf("Average order: $%.2f%n", averageOrder);
       
        if (totalRevenue >= revenueGoal)
        {
            double exceeded = totalRevenue - revenueGoal;
            System.out.printf("Goal ($%.2f): MET (exceeded by $%.2f)%n", revenueGoal, exceeded);
        
        }
        else{

            double shortBy = revenueGoal - totalRevenue;
            System.out.printf("Goal ($%.2f): NOT MET (short by $%.2f)%n", revenueGoal, shortBy);
        }
    }

}
