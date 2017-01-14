import java.io.BufferedReader;
import java.io.FileReader;
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
	

}
