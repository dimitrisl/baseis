import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Onenlj {
	public static void main(String[] args) {
		
		String f1="A.csv";
		String f2="B.csv";
		int m=200;
		int a1=2;
		int a2=2;
				try {
					joinstart(f1,f2,m,a1,a2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	public static void joinstart(String file1,String file2,int memsize,int attribute1,int attribute2)throws IOException
	{
		
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(file1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(file2);
		String lines1 = "";
		String lines2 = "";
		int []mem = new int[memsize];
		

		if(numberoflines1>=numberoflines2){//put the file with less records in the outer loop
			swapIntegers(numberoflines1,numberoflines2);
			swapStrings(file1,file2);
			swapIntegers(attribute1,attribute2);
		
		BufferedReader fr=new BufferedReader(new FileReader(file1));
		BufferedReader sr=new BufferedReader(new FileReader(file2));
		fr.readLine();
		
			//readFile1 and put it in memory
			for(int k=0; k<numberoflines1; k++){
				
				lines1=fr.readLine();
				mem[k]=Integer.parseInt(lines1.split(",")[attribute1]);
			}
				//restart reading file from the beginning
				fr = new BufferedReader(new FileReader(file1));
				fr.readLine();
				sr.readLine();
			int n= memsize-numberoflines1;
			while ((lines1 = fr.readLine()) != null)
			{
				for (int i=0;i<=numberoflines1;i++) 
				{	
					for (int j=0;j<=numberoflines2;j=j+n)
					{
						for (int l=0;l<n;l++){
						lines2=sr.readLine();
						mem[memsize-2]=Integer.parseInt(lines2.split(",")[attribute2]);//change in every iteration only the last record in the memory
							if(mem[i]==mem[memsize-2]){
								//ReadingWritingFile.Writethis(lines1);
								System.out.println(lines1+" "+lines2);
						    }
						}
					}
					
					if (((lines2 = sr.readLine()) == null))
					{
						sr = new BufferedReader(new FileReader(file2));
						//go back to the beginning
					}
					
				}
			  }
			
		
		fr.close();
		sr.close();
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

