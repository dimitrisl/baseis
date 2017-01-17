import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
		String []memory = new String[memsize];
		
		for(int i=0;i<numberoflines1/memsize;i++){
			createSublist(f1,memory,attribute1);
		}
		
		for(int j=0;j<numberoflines2/memsize;j++){
			createSublist(f2,memory,attribute2);
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
			
			
			

		//from now on we have to take some of the records of text1
		//to the temporary file.
//		for (int counter=0;counter<memory.length;counter++)
//		{
//			System.out.println(memory[counter]);
//		}

	}
	
	public static void OutputTuples(int i, int j, int numberoflines1, int numberoflines2){
		
	}

	public static void createSublist(String filepath,String []mem,int att) throws IOException{
		
		BufferedReader br=new BufferedReader(new FileReader(filepath));
		br.readLine();
		String line = br.readLine();
		
		while (line!=null)
		{
			for (int i=0;i<mem.length;i++)
			{
				if (line==null)
				{
					mem[i] = "Z";
				}else
				{
					mem[i] = line ;
				}
				line = br.readLine();
			}
		}
		
		mem =sortedbyattribute(mem,att,mem.length);
		
		for(int i=0;i<mem.length;i++){
			ReadingWritingFile.Writethis(mem[i]);//its good to put another attribute called fileout which is the name of the file we want to write
		}
		
		br.close();
		
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
	
