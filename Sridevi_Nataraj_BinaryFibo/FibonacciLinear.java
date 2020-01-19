//Student Name: Sridevi Nataraj 
//Student ID: 40005572
//Programming Assignment 1
//Part 2 - Linear Fibonacci

import java.io.*;

public class  FibonacciLinear {
	public static void main(String[] args) {
		
		
		//write to a text file
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter(new FileOutputStream("FibonacciLinear.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file FibonacciLinear.txt");
		}
		
		for (int i = 10; i < 100; i = i+5)
		{
			long startTime = System.nanoTime();
			FibonacciLinear(i, 1, 1);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) ;
			writer.println("The runtime needed to calculate  Fibonacci(" + i + ") is: " + duration +" nanoseconds");
		}
		
		writer.close();
		System.out.println("End of program.");
	}

	public static long FibonacciLinear(int n, int a, int b)
	{
		if(n == 1)
	        return a;        //returns the first Fibonacci number
	    else if(n == 2)
	      return b;          //returns the second Fibonacci number
	   
	    else
	      return ( FibonacciLinear (n - 1, b, a+b)); //a recursive call to previous Fibonnaci (n-1)
	}
}
