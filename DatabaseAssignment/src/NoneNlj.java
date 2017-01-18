import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoneNlj {
	
	public static void joinstart( String filepath1, String filepath2, int memsize,int attributesF1, int attributesF2,int numOfLines1,int numOfLines2,String outputFile) throws IOException{
		
		int[] memory=new int[memsize]; //allocates memory
		String[] memlines=new String[memsize];
		
		String lines1="";
		String lines2="";
		
		FileReader fr1=new FileReader(filepath1);
		FileReader fr2=new FileReader(filepath2);

		BufferedReader fr=new BufferedReader(fr1);
		BufferedReader sr=new BufferedReader(fr2);
	
		sr.readLine();
		
		
		while ((lines1 = fr.readLine()) != null)
		{

			for (int i=0;i<numOfLines1/(memsize-1);i++) //how many times m fits in the number of lines
			{
				//read File1 and put it in memory
				for(int k=0;k<memsize-1;k++){
					lines1=fr.readLine();
					if(lines1==null){
						for(int z=k;z<memsize-1;z++){
							memory[z]=0;
						}
						break;
					}
					memlines[k]=lines1;
					memory[k]=Integer.parseInt(lines1.split(",")[attributesF1]);		
				}
				
				for (int j=0;j<numOfLines2;j++)
				{	
					lines2=sr.readLine();
					memlines[memsize-1]=lines2;
					memory[memsize-1]=Integer.parseInt(lines2.split(",")[attributesF2]);//change in every iteration only the last record in the memory
					for(int l=0;l<memsize-1;l++){
						if(memory[l]==memory[memsize-1]){
							String concatenate ="";
							String both = memlines[l]+","+memlines[memsize-1];
							String []holder = both.split(",");
							for (int counter=0;counter<holder.length;counter++)
							{
								if (counter != attributesF1)
								{
									concatenate += holder[counter]+",";
								}else if(counter == holder.length-1)
								{
									concatenate +=holder[counter];
								}
							}

							ReadingWritingFile.Writethis(concatenate+"\n",outputFile);
						}
							
					}
							
				}
				sr.close();
				sr = new BufferedReader(new FileReader(filepath2));
				sr.readLine();							
				
			}
		}
		fr.close();
		sr.close();
	}
	
}
