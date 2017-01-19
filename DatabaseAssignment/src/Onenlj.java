import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Onenlj {
			
	public static void joinstart(String file1,String file2,int memsize,int attribute1,int attribute2,int numberoflines1,int numberoflines2,String outputFile)throws IOException
	{
		
		String lines1 = "";
		String lines2 = "";
		int []mem = new int[memsize];
		
		
		BufferedReader fr=new BufferedReader(new FileReader(file1));
		BufferedReader sr=new BufferedReader(new FileReader(file2));
		fr.readLine();
		
			//readFile1 and put it in memory
			for(int k=0; k<numberoflines1; k++){
				
				lines1=fr.readLine();
				System.out.println(lines1);
				mem[k]=Integer.parseInt(lines1.split(",")[attribute1]);
			}
				fr.close();;
				//restart reading file from the beginning
				fr = new BufferedReader(new FileReader(file1));
				fr.readLine();
			    int n= memsize-numberoflines1;
				
			    for (int i=0;i<=numberoflines1;i++) //iterate through first file
				{	
			    	lines1=fr.readLine();
					sr = new BufferedReader(new FileReader(file2));			//restart the file2 reading
				    lines2=sr.readLine();
				    
					loop:
					for (int j=0;j<=numberoflines2; j= j+n)		//iterate through lines of second file
					{
						for (int y=1;y<n;y++){					// inner memory iteration and comparison 
							
							lines2=sr.readLine();
							if (lines2!=null){
								mem[memsize-y]=Integer.parseInt(lines2.split(",")[attribute2]);   		//put in the spots of the memory left as many tuples of the second file fit
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
									 ReadingWritingFile.Writethis(concatenated_string+"\n",outputFile);
								 }
							}else{break loop;}
						}
					}				
				}
			    fr.close();
				sr.close();
			}
			
	}

