import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bothnlj {
	
	public static void joinstart(String file1,String file2,int cattribute1,int cattribute2) throws IOException//filepath1,filepath2,memory size,collumnf1,collumnf2
	{

		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(file1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(file2);
		String temp = "";
		if (numberoflines1>=numberoflines2)
		{
			temp.concat(file2);
			file2 = "";
			file2.concat(file1);
			file1 = "";
			file1.concat(temp);
		}
		
		String file1line = "";
		String file2line = "";
		
		BufferedReader fr = new BufferedReader(new FileReader(file1));
		file1line = fr.readLine();
		BufferedReader sr = new BufferedReader(new FileReader(file2));
		file2line = sr.readLine();
		
		while(((file2line = sr.readLine())!=null))	
		{
			int line2 = Integer.parseInt(file2line.split(",")[cattribute2]);
			while (((file1line =fr.readLine())!=null))
			{
				int line1 = Integer.parseInt(file1line.split(",")[cattribute1]);
				 if (line1 == line2)
				 {
					 String concatenated_string = "";
					 for (int counter = 0;counter<file1line.split(",").length;counter++)
					 {
						 if (counter == cattribute1)
						 {
							 continue;
						 }else
						 {
							 concatenated_string.concat(file1line.split(",")[counter]);
						 }
					 }
					 concatenated_string.concat(file2line);
					 ReadingWritingFile.Writethis(concatenated_string);
				 }
			}
			fr = new BufferedReader(new FileReader(file1));
		}
	}

}

