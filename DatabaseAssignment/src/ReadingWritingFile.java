import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingWritingFile {
	
	public int readFirstLineofFile(String file){
	    int numOflines=0;
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    
	    	numOflines = Integer.parseInt(br.readLine());
		    
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return numOflines;
	}
	
	public void Writethis(String text)
	{

		try{

	        //Specify the file name and path here
	    	File file =new File("./output.txt");

	    	/* This logic is to create the file if the
	    	 * file is not already present
	    	 */
	    	if(!file.exists()){
	    	   file.createNewFile();
	    	}
	    	//Here true is to append the content to file
	    	FileWriter fw = new FileWriter(file,true);
	    	//BufferedWriter writer give better performance
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	bw.write(text);
	    	//Closing BufferedWriter Stream
	    	bw.close();
	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	       }
	   }
}
