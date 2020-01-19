//Student Name: Sridevi Nataraj 
//Student ID: 40005572
//Programming Assignment 1
//Part 1- BinaryFib

import java.io.*;

public class Binaryfib {
	public static void main(String[] args) {
		
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter(new FileOutputStream("BinaryFib.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file BinaryFib.txt");
		}
		
		
		// A code to print the runtime in nanoseconds
		for (int i = 10; i <= 35; i = i+5)
		{
			long startTime = System.nanoTime();
			Binaryfib(i);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) ;
			writer.println("The runtime needed to calculate Binaryfib(" + i + ") is: " + duration +" nanoseconds");
		}
		
		
		
		writer.close();
		System.out.println("End of program.");
	}
	
	public static long Binaryfib(int n)  
	{
	    if(n <= 2)
	        return 1; //the first two Fibonnaci numbers are 1, 1
	    else
	      return (Binaryfib(n - 1) + Binaryfib(n - 2)); //after the first 2 predetermined Fibonacci numbers,
	    																	//each value afterwards is the sum of the preceding two values
	    																    //for n, the preceding numbers are n-1 and n-2
	}
}
