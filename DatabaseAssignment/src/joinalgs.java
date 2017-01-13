import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.AbstractDocument.BranchElement;

public class joinalgs {
	
	public static void main(String[] args)
	{
		
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
		String f1 = args[1]; // first csv
		int a1 = Integer.parseInt(args[3]);
		String f2 = args[5]; // second csv
		int a2 = Integer.parseInt(args[7]);
		String j = args[9];
		int m = Integer.parseInt(args[11]);
		String t = args[13];
		String o = args[15];
		
		
		if (j=="NLJ")
		{
			try {
				Nlj(f1,f2,m,a1,a2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (j=="MSJ")
		{
			
		}

		
	}
	
	public int[] compare(int File1,int File2,int memsize)
	{
		int decision[] = new int[3];
		//compares the two files decides the fraction of the memsize that will be used
		
		
		return decision;
	}
	
	public static void Nlj(String loc1,String loc2,int memorysize, int attribute1,int attribute2) throws IOException
	//that this buffer is splitted.
	{
	String file1line = "";
	String file2line = "";
	int numberoflines1 = 0;
	int numberoflines2 = 0;
	String csvFile1 = loc1;//locations of both files
	String csvFile2 = loc2;
	int m = memorysize; //size of the memory.
	
	BufferedReader fr = new BufferedReader(new FileReader(csvFile1));
	BufferedReader sr = new BufferedReader(new FileReader(csvFile2));
	
	numberoflines1 = Integer.parseInt(fr.readLine());
	numberoflines2 = Integer.parseInt(sr.readLine());
	// we got number of lines for both files to be joined
	// by convention in this implementation we get that the first file will be the smallest of the two (this will be decided by another method)
	
		
		while ((file1line = fr.readLine()) != null || (((file2line = sr.readLine())!= null)))
		{
			if (((file2line = sr.readLine()) == null))
			{
				sr = new BufferedReader(new FileReader(csvFile2));
			}
			
			for (int i=0;i<(numberoflines1)/m -1;i++) //milame gia to poses fores xwraei to paketo M genikotera
			{
				//readFile1 and put it in memory
				for (int j = 0;j<= numberoflines2;j++)
				{
				
				//readFile2 lines put in memory
				//compare
				}
			}
		}
	}
}