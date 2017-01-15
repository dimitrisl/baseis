
public class SMJ {
	
	public static void smjjoinstart(String f1, String f2, int memsize, int attribute1, int attribute2){
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(f1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(f2);
		String lines1 = "";
		String lines2 = "";
		int []mem = new int[memsize];
			 	
		int i=1;
		int j=1;
		String []text1 = new String[numberoflines1];
		String []text2 = new String[numberoflines2];
		
		text1 = sortedbyattribute(text1,attribute1);
		text2 = sortedbyattribute(text2,attribute2);
		
		while (i<=numberoflines1 && j<=numberoflines2){
			
		}
	}
	
	public static void OutputTuples(int i, int j, int numberoflines1, int numberoflines2){
		
	}

	public String[] sortedbyattribute(String[] file,int attribute1)
	{
		String[] line;
		String[] resta;
		for (int i=0;i<file.length;i++)
		{
			for (int j=0)
			
			line[i] = file[i].split(",")[attribute1];
			
		}
		return Answer; 
	}

	    public static void bubble_srt(int array[]) {
	        int n = array.length;
	        int k;
	        for (int m = n; m >= 0; m--) {
	            for (int i = 0; i < n - 1; i++) {
	                k = i + 1;
	                if (array[i] > array[k]) {
	                    swapNumbers(i, k, array);
	                }
	            }
	        }
	    }
	  
	    private static void swapNumbers(int i, int j, int[] array) {
	  
	        int temp;
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }

}
