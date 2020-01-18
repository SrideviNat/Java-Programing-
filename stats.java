/*
 Name: Sridevi Nataraj.
 */

import java.util.Scanner;

 public class stats
{
    public static void main(String [] args)
    {
        Scanner in  = new Scanner(System.in); // sets object in to the system.in
        
        double minimum = Double.POSITIVE_INFINITY, maximum = Double.NEGATIVE_INFINITY, sum = 0, mean, valueIn;
        int nValues = 0;


        while(in.hasNextDouble())
        {
            valueIn = in.nextDouble(); // holds the double value entered from standard in
            
            nValues++; // counts the number of values entered
            sum += valueIn; // adds numbers from the standard in to sum
            
            if(valueIn > maximum) //checks if the number entered is larger.
            {
                maximum = valueIn;
            }
            if(valueIn < minimum) //check if the number entered is smaller.
            {
                minimum = valueIn;
            }

        }
        
        if(nValues == 0) // checks whether there is an empty input. 
        {
            System.out.println("There were no inputs");
        }
        else
        {
            
            mean = sum/nValues; //this calcultes the average.
            
            System.out.println("Results: ");
            System.out.println("\tminimun = " + minimum);
            System.out.println("\tmaximum = " + maximum);
            System.out.println("\tsum = " + sum);
            System.out.println("\tnumber of values = " + nValues);
            System.out.println("\tmean = " + mean);
        }
    }


}
