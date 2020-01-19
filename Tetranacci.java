//Student Names: Sridevi Nataraj
//Programming Assignment 1
//Part 2 - Tetranacci

import java.io.*;
public class Tetranacci {

	public static void main(String[] args) {
		//System.out.println(tetranacci(5));
	
				
				PrintWriter writer = null;
				try
				{
					writer = new PrintWriter(new FileOutputStream("Tetranacci.txt"));
				}
				catch (FileNotFoundException e)
				{
					System.out.println("Error opening the file Tetranacci.txt");
				}
				
				
				for (int i = 5; i <= 35; i = i+5)
				{
					long startTime = System.nanoTime();
					tetranacci(i);
					long endTime = System.nanoTime();
					long duration = (endTime - startTime) ;
					writer.println("The runtime needed to calculate Tetranacci(" + i + ") is: " + duration +" nanoseconds");
					
				}
				
				/* A code to print the runtime in nanoseconds
				for (int i = 5; i <= 35; i = i+5)
				{
					long startTime = System.nanoTime();
					Tetranacci(i);
					long endTime = System.nanoTime();
					long duration = (endTime - startTime) ;
					writer.println("The runtime needed to calculate Tetranacci(" + i + ") is: " + duration +" nanoseconds");
				}
				*/
				
				writer.close();
				System.out.println("End of program.");
			}
			
			public static long tetranacci(int n)  
			{
			    if(n <= 4)
			        return 1; //the first four Tetranacci numbers are 0,0,0,1
			    else
			      return (tetranacci(n - 1) + tetranacci(n - 2) + tetranacci (n - 3) + tetranacci (n-4)); //after the first three predetermined tetranacci numbers,
			    																						 //each value afterwards is the sum of the preceding four values
			    																    					//for n, the preceding numbers are n-1, n-2, n-3 and n-4
			}
		}
