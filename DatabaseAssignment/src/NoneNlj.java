import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoneNlj {
	
	public static void joinstart( String filepath1, String filepath2, int memsize,int attributesF1, int attributesF2) throws IOException{
		
		int numOfLines1;
		int numOfLines2;
		int[] memory=new int[memsize]; //allocates memory
		String lines1="";
		String lines2="";
		numOfLines1=ReadingWritingFile.readFirstLineofFile(filepath1);
		numOfLines2=ReadingWritingFile.readFirstLineofFile(filepath2);
		
		if(numOfLines1>=numOfLines2){//put the file with less records in the outter loop
			swapIntegers(numOfLines1,numOfLines2);
			swapStrings(filepath1,filepath2);
			swapIntegers(attributesF1,attributesF2);
		}
		
		BufferedReader fr=new BufferedReader(new FileReader(filepath1));
		BufferedReader sr=new BufferedReader(new FileReader(filepath2));
		//skip the first line
		fr.readLine();
		sr.readLine();
		
		while ((lines1 = fr.readLine()) != null || (((lines2 = sr.readLine())!= null)))
		{

			for (int i=0;i<numOfLines1/(memsize-1);i++) //poses fores xwraei to M ston pinaka me tis ligoteres eggrafes
			{
				//readFile1 and put it in memory
				for(int k=0;k<memsize-1;k++){
					lines1=fr.readLine();
					memory[k]=Integer.parseInt(lines1.split(",")[attributesF1]);				
				}
				
				for (int j=0;j<=numOfLines2;j++)
				{
					lines2=sr.readLine();
					memory[memsize-1]=Integer.parseInt(lines2.split(",")[attributesF2]);//change in every iteration only the last record in the memory
					for(int l=0;l<=memsize-1;l++){
						if(memory[l]==memory[memsize-1]){
							ReadingWritingFile.Writethis(lines1);
						}
					}
				}
				
				if (((lines2 = sr.readLine()) == null))
				{
					sr = new BufferedReader(new FileReader(filepath2));
					//go back to the beggining
				}
				
			}
		}
	}
	
	public static void swapIntegers(int a,int b){
	    int temp = a;
	    a = b;
	    b = temp;
	}
	public static void swapStrings(String a,String b){
	    String temp = a;
	    a = b;
	    b = temp;
	}
}
