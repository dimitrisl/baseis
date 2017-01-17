import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SMJ {
	
	public static void main(String[] args) throws IOException
	{
		smjjoinstart("A.csv","B.csv",200,1,2);
	}
	
	
	public static void smjjoinstart(String f1, String f2, int memsize, int attribute1, int attribute2) throws IOException{
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(f1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(f2);
		String []memory = new String[memsize];
		
		BufferedReader fr=new BufferedReader(new FileReader(f1));
		fr.readLine();
		for(int i=0;i<=numberoflines1/memsize;i++){
			
			createSublist(f1,fr,memory,attribute1,i);
		}
		fr.close();
		BufferedReader sr=new BufferedReader(new FileReader(f2));
		sr.readLine();
		for(int j=0;j<=numberoflines2/memsize;j++){
			createSublist(f2,sr,memory,attribute2,j);
		}
		sr.close();
	}
	
	public static void OutputTuples(int i, int j, int numberoflines1, int numberoflines2){
		
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