import java.io.BufferedReader;
import java.io.FileReader;

public class NoneNlj {
	public void joinstart( String filepath1, String filepath2, int memsize,int columnF1, int columnF2){
		
		int numOfLines1;
		int numOfLines2;
		ReadingWritingFile r=new ReadingWritingFile();
		numOfLines1=r.readFirstLineofFile(filepath1);
		numOfLines2=r.readFirstLineofFile(filepath2);
		
		while ((numOfLines1 = fr.readLine()) != null || (((numOfLines2 = sr.readLine())!= null)))
		{

			for (int i=0;i<(numOfLines1)/memsize -1;i++) //poses fores xwraei to M ston pinaka me tis ligoteres eggrafes
			{
				//readFile1 and put it in memory
				
				for (int n = 0 ;n<memsize-1;n++)
				{
					
				}
				
				if (((numOfLines2 = sr.readLine()) == null))
				{
					sr = new BufferedReader(new FileReader(filepath2));
					//go back to the beggining
				}
				
				for (int j = 0;j<= numOfLines2;j++)
				{
				
				//readFile2 lines put in memory
				//compare
				Writethis(file1line+file2line);
				}
			}
		}
	}
}
