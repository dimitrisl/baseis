import java.io.IOException;

public class joinalgs {
	
	public static void main(String[] args) throws IOException
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
//		String file1 = args[1]; // first csv
//		int attribute1 = Integer.parseInt(args[3]);
//		String file2 = args[5]; // second csv
//		int atribute2 = Integer.parseInt(args[7]);
//		String algorithm = args[9];
//		int memory = Integer.parseInt(args[11]);
//		String tempFilesDir = args[13];
//		String outputFile = args[15];
//		
		String file1="D.csv";
		int attribute1=3;
		String file2="C.csv";
		int attribute2=0;
		String algorithm="MSJ";
		int memory=200;
		String outputFile="output.csv";
		String tempFilesDir="tempFiles\\";
		
		if (algorithm=="NLJ")
		{
			
			int numberoflines1=ReadingWritingFile.readFirstLineofFile(file1);
			int numberoflines2=ReadingWritingFile.readFirstLineofFile(file2);
			
			/*Because we want the file with the less lines to be in the outer loop 
			we should swap file1-file2,numberoflines1-numberoflines2 and attribute1-attribute2
			if numberoflines1>numberoflines2*/
			if(numberoflines1>numberoflines2){
				file1=Tools.swapString(file2,file2=file1);
				attribute1=Tools.swapInt(attribute2, attribute2=attribute1);
				numberoflines1=Tools.swapInt(numberoflines2, numberoflines2=numberoflines1);
			}
			
			String decision =Tools.decidenlj(numberoflines1,numberoflines2,memory);
			
			if (decision.equals("None"))
			{
				try {
					NoneNlj.joinstart(file1,file2,memory,attribute1,attribute2,numberoflines1,numberoflines2,outputFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (decision.equals("One"))
			{
				try {
					Onenlj.joinstart(file1,file2,memory,attribute1,attribute2,numberoflines1,numberoflines2,outputFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else
			{
				try {
					Bothnlj.joinstart(file1,file2,attribute1,attribute2,outputFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}else if (algorithm=="MSJ")
		{
			SMJ.smjjoinstart(file1, file2, memory, attribute1, attribute2, outputFile,tempFilesDir);
		}
	
	}

}