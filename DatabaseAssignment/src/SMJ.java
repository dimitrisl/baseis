import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class SMJ {
	
	public static void main(String[] args) throws IOException
	{
		smjjoinstart("C.csv","D.csv",200,0,3,"output.csv");
	}
	
	
	public static void smjjoinstart(String f1, String f2, int memsize, int attribute1, int attribute2,String outputFile) throws IOException{
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(f1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(f2);
		String []memory = new String[memsize];
		int i,j;//number of sublists
		
		BufferedReader fr=new BufferedReader(new FileReader(f1));
		fr.readLine();
		for(i=0;i<=numberoflines1/memsize;i++){
			createSublist(f1,fr,memory,attribute1,i);
		}
		fr.close();
		BufferedReader sr=new BufferedReader(new FileReader(f2));
		sr.readLine();
		for(j=0;j<=numberoflines2/memsize;j++){
			createSublist(f2,sr,memory,attribute2,j);
		}
		sr.close();
		
		Receivelists.reclists(f1, i-1, attribute1, memsize);
		//delete sublists
		for(int m=0;m<i;m++){
			new File(f1+m+"sublist.csv").delete();
		}
		
		Receivelists.reclists(f2, j-1, attribute2, memsize);
		//delete sublists
		for(int m=0;m<j;m++){
			new File(f2+m+"sublist.csv").delete();
		}
		
		MergeTmpFiles.mergeFiles(f1, f2, attribute1, attribute2, outputFile);
		//delete sorted files
		new File("sorted"+f1+".csv").delete();
		new File("sorted"+f2+".csv").delete();
		
	}
	
	public static void createSublist(String filepath,BufferedReader br,String []mem,int attr,int iteration) throws IOException{
		
		String line;
		
		for (int i=0;i<mem.length;i++)
		{
			line = br.readLine();
			if (line==null)
			{	
				mem[i]="-1,-1,-1,-1";
				
			}else
			{
				mem[i] = line ;
			}
			
		}
		
		mem =sortedbyattribute(mem,attr);
		
		for(int i=0;i<mem.length;i++){
			if(mem[i]=="-1,-1,-1,-1"){continue;}
			ReadingWritingFile.Writethis(mem[i]+"\n",filepath+iteration+"sublist.csv");
			
		}
		
	}
	public static String[] sortedbyattribute(String[] arr,int attr)
	{
		String tmp;
		 
	    for (int c = 0; c < ( arr.length - 1 ); c++) {
	      for (int d = 0; d < arr.length - c - 1; d++) {
	        if ((Integer.parseInt(arr[d].split(",")[attr])) > (Integer.parseInt(arr[d+1].split(",")[attr]))) /* For descending order use < */
	        {
	          tmp      = arr[d];
	          arr[d]   = arr[d+1];
	          arr[d+1] = tmp;
	        }
	      }
	    }

	    return arr;
	} 
}