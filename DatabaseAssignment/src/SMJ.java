	import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class SMJ {
	
	public static void main(String[] args) throws IOException
	{
		smjjoinstart("test.csv","test3.csv",10,1,2);
	}
	
	
	public static void smjjoinstart(String f1, String f2, int memsize, int attribute1, int attribute2) throws IOException{
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(f1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(f2);
		BufferedReader fr=new BufferedReader(new FileReader(f1));
		fr.readLine();
		BufferedReader sr=new BufferedReader(new FileReader(f2));
		sr.readLine();
		String line = fr.readLine();
		String []memory = new String[memsize];
		
		
		while (line!=null)
		{
			for (int i=0;i<memory.length;i++)
			{
				if (line==null)
				{
					memory[i] = "Z";
				}else
				{
					memory[i] = line ;
				}
				line = fr.readLine();
			}
//			String []placeholder = new String [memsize];
//			int counter = 0;
//			while (memory[counter]!="EMPTY")
//				{
//					placeholder[counter] = memory[counter];
//					counter++;
//				}
//			placeholder = sortedbyattribute(placeholder,attribute1,memsize);
//			
			memory =sortedbyattribute(memory,attribute1,memsize);
			
			
		}

		//from now on we have to take some of the records of text1
		//to the temporary file.
//		for (int counter=0;counter<memory.length;counter++)
//		{
//			System.out.println(memory[counter]);
//		}

	}
	
	public static void OutputTuples(int i, int j, int numberoflines1, int numberoflines2){
		
	}

	public static String[] sortedbyattribute(String[] file,int attribute1,int numberoflines)
	{
		String []line = new String[numberoflines];
		
		for (int i=0;i<file.length;i++)
		{
			if (file[i]=="Z")
			{
				line[i]=null;
			}
			else
			{
				line[i] = file[i].split(",")[attribute1].toString()+"A"+file[i];
			}
		}
		//Arrays.sort(line);
		Arrays.sort(line, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));

		for (int counter=0;counter<line.length;counter++)
		{
			if (line[counter]!=null)
			{	
				line[counter] =  line[counter].replace((line[counter].split("A")[0])+"A","");
				System.out.println(line[counter]);
			}
		}
		
		return line; 
	}


}
	
