import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bothnlj {
	
	public static void joinstart(String file1,String file2,int m,int cattribute1,int cattribute2) throws IOException//filepath1,filepath2,memory size,collumnf1,collumnf2
	{

		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(file1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(file2);
		String file1line = "";
		String file2line = "";
		try {
			BufferedReader fr = new BufferedReader(new FileReader(file1));
			file1line = fr.readLine();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 BufferedReader sr = new BufferedReader(new FileReader(file2));
			 file1line = sr.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}

