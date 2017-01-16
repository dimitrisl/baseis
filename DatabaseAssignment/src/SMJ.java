import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SMJ {
	
	public static void main(String[] args) throws IOException
	{
		smjjoinstart("D.csv","E.csv",50,1,2);
	}
	
	
	public static void smjjoinstart(String f1, String f2, int memsize, int attribute1, int attribute2) throws IOException{
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(f1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(f2);
		String lines1 = "";
		String lines2 = "";
		int []mem = new int[memsize];
			 	
		int i=1;
		int j=1;
		String []text1 = new String[numberoflines1];
		String []text2 = new String[numberoflines2];
	
		BufferedReader fr=new BufferedReader(new FileReader(f1));
		fr.readLine();
		for (int y=0;y<numberoflines1;y++)
		{
			text1[y]=fr.readLine();
		}
		
		BufferedReader sr=new BufferedReader(new FileReader(f2));
		sr.readLine();
		for (int y=0;y<numberoflines2;y++)
		{
			text2[y]=sr.readLine();
		}
		
		text1 = sortedbyattribute(text1,attribute1,numberoflines1);// sorted file1
		text2 = sortedbyattribute(text2,attribute2,numberoflines2);// sorted file2
		
		
		//from now on we have to take some of the records of text1
		//to the temporary file.
		for (int counter=0;counter<text1.length;counter++)
		{
			System.out.println(text1[counter]);
		}

	}
	
	public static void OutputTuples(int i, int j, int numberoflines1, int numberoflines2){
		
	}

	public static String[] sortedbyattribute(String[] file,int attribute1,int numberoflines)
	{
		String []line = new String[numberoflines];
		
		for (int i=0;i<file.length;i++)
		{
			line[i] = file[i].split(",")[attribute1].toString()+"A"+file[i];
		}
		Arrays.sort(line);
		
		for (int counter=0;counter<line.length;counter++)
		{
			line[counter] =  line[counter].replace((line[counter].split("A")[0])+"A","");
			System.out.println(line[counter]);
		}
		
		return line; 
	}


}
	