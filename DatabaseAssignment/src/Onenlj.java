import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Onenlj {
			
	public static void joinstart(String file1,String file2,int memsize,int attribute1,int attribute2)throws IOException
	{
		
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(file1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(file2);
		String lines1 = "";
		String lines2 = "";
		int []mem = new int[memsize];
		
		
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
			    int n= memsize-numberoflines1;
				
			    for (int i=0;i<=numberoflines1;i++) 
				{	
			    	lines1=fr.readLine();
					sr = new BufferedReader(new FileReader(file2));
				    lines2=sr.readLine();
					loop:
					for (int j=0;j<=numberoflines2; j= j+n)
					{
						for (int y=1;y<n;y++){
							
							lines2=sr.readLine();
							if (lines2!=null){
								mem[memsize-y]=Integer.parseInt(lines2.split(",")[attribute2]);
								String concatenated_string = "";
								if (mem[i] == mem[memsize-y])
								 {
									 
									 for (int counter = 0;counter<lines1.split(",").length;counter++)
									 {
										 if (counter == attribute1)
										 {
											 continue;
										 }else
										 {
											 concatenated_string =concatenated_string + lines1.split(",")[counter] + ",";
										 }
									 }
									 concatenated_string+=lines2;
									 //ReadingWritingFile.Writethis(concatenated_string+"\n");
									 System.out.println(concatenated_string);
								 }
							}else{break loop;}
						}
					}				
				}
			}
			//fr.close();
			//sr.close();
	}

