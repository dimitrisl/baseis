import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Joins {

	public static void main(String[] args) {
		/*
1			-f1 <file1 path>: full path to file1
2			-a1 <file1_join_attribute>: the column to use as join attribute from file1 (counting from 0)
3			-f2 <file2 path>: same as above for file2
4			-a2 <file2_join_attribute>: same as above for file2
5			-j <join_algorithm_to_use>: SMJ or NLJ
6			-m <available_memory_size>: we use as memory metric the number of records*
7			-t <temporary_dir_path>: a directory to use for reading/writing temporary files
8			-o <output_file_path>: the file to store the result of the join 
		 * */		
//		String f1 = args[1]; // first csv
//		String a1 = args[3];
//		String f2 = args[5]; // second csv
//		String a2 = args[7];
//		String j = args[9];
//		String m = args[11];
//		String t = args[13];
//		String o = args[15];
	
		
		int [][]apotelesmata = Csv("C:\\Users\\Dimitris\\Desktop\\DatabaseAssignment\\src\\A.csv");
		int [][]apotelesmata2 = Csv("C:\\Users\\Dimitris\\Desktop\\DatabaseAssignment\\src\\B.csv");
		
		System.out.println(apotelesmata2[1][2]);
		System.out.println(apotelesmata[1][1]);
		
	}

	public ArrayList<String> Nlj (int[][] arxeio1,int[][] arxeio2 , int a1,int a2)
		{
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i=0; i < arxeio1.length; i++)
		{
			for (int j=0; j < arxeio2.length; j++)
			{
				if (arxeio1[i][a1] == arxeio2[j][a2])
					{
						
					}
			}
		}
			
			
		return result;
		}

	public ArrayList<String> Smj(String f1,String f2,String a1,String a2)
		{
		ArrayList<String> result= new ArrayList<String>();
		return result;
		}


	public static int[][] Csv(String csvFile){
		
	    String line = "";
	    int first ;
	    int counter = 0;
	    int result[][] = null;
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	    
	    	first = Integer.parseInt(br.readLine());
		    result = new int[first][4];
		    while ((line = br.readLine()) != null) {
		    	String temp[] = line.split(",");
		    	for (int k=0;k<4;k++)
			    	{
		    			result[counter][k] = Integer.parseInt(temp[k]);
			    	}
		    	counter++;

	        }
	   
		    
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return result;
	}

}