import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MergeTmpFiles {
	
	public static void mergeFiles(String file1,String file2,int att1,int att2,String outputFile) throws IOException  {
		
		int numOfLines1=ReadingWritingFile.readFirstLineofFile(file1);
		int numOfLines2=ReadingWritingFile.readFirstLineofFile(file2);
		
		BufferedReader fr=new BufferedReader(new FileReader("sorted"+file1+".csv"));
		BufferedReader sr=new BufferedReader(new FileReader("sorted"+file2+".csv"));
		
		String lines1="";
		String lines2="";
		
		for(int i=0;i<numOfLines1;i++){
			lines1=fr.readLine();
			for(int j=0;j<numOfLines2;j++){
				lines2=sr.readLine();
				int tmp1=Integer.parseInt(lines1.split(",")[att1]);
				int tmp2=Integer.parseInt(lines2.split(",")[att2]);
				if(tmp1==tmp2){
					String temp=lines1.split(",")[att1];
					lines1=lines1.replaceAll(temp+",","");
					ReadingWritingFile.Writethis(lines1+","+lines2+"\n",outputFile);
				}
			}
		}
		fr.close();
		sr.close();
	}
	public static void main(String[] args) throws IOException
	{
		mergeFiles("C.csv", "D.csv", 0,3, "output.csv");
	}

}
