import java.io.IOException;

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
//		String f1 = args[1]; // first csv
//		int a1 = Integer.parseInt(args[3]);
//		String f2 = args[5]; // second csv
//		int a2 = Integer.parseInt(args[7]);
//		String j = args[9];
		int memory = Integer.parseInt(args[11]);
//		String t = args[13];
//		String o = args[15];
//		
		String j="NLJ";
		if (j=="NLJ")
		{
			// filepath1,filepath2,memory size,collumnf1,collumnf2
			//create decision method to choose case for nlj
			//Nonenlj fits -->joinstart
			String file1="A.csv";
			String file2="B.csv";
			String decision = decidenlj(file1,file2,memory);
			
			if (decision.equals("None"))
			{
				try {
					NoneNlj.joinstart(file1, file2, 100, 0, 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (decision.equals("One"))
			{
				try {
					Onenlj.joinstart(file1, file2, 100, 0, 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else
			{
				try {
					Bothnlj.joinstart(file1, file2, 0, 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Onenlj fits -->joinstart
			//both fit Bothnlj-->joinstart
		}else if (j=="MSJ")
		{
			//create decision method to choose case for smj
		}

		
	}
	
	public static String decidenlj(String File1,String File2,int memsize)
	{
		String decision = "";
		int numOfLines1=ReadingWritingFile.readFirstLineofFile(File1);
		int numOfLines2=ReadingWritingFile.readFirstLineofFile(File2);
		
		if ((numOfLines1>memsize) && (numOfLines2>memsize))
		{
			decision = "None";
		}
		else if ((numOfLines1<=memsize) ^ (numOfLines2<=memsize))
		{
			decision = "One";
		}
		else if (numOfLines1+numOfLines2<=memsize)
		{
			decision = "Both";
		}
		return decision; //poia apo tis 3 periptwseis nlj
	}

}