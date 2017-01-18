import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Receivelists {
		

	public static void reclists(String file,int numfiles,int attribute,int memorysize) throws IOException
	{
			if (numfiles<=memorysize)
			{
			BufferedReader[] buffers = new BufferedReader[numfiles];
			String []rows = new String[numfiles];

				for (int i= 0 ;i<numfiles;i++)
				{
					buffers[i]=new BufferedReader(new FileReader(file+i+"sublist.csv"));
					rows[i] = buffers[i].readLine();
				}

				int min_loc;
				String []compare;
				String insert = "";
				Boolean state = true;
				String worst_case;
				int counter = 0;
				while (state)
				{
						compare = findmin(rows,attribute);
						min_loc = Integer.parseInt(compare[1]);
						ReadingWritingFile.Writethis(rows[min_loc]+"\n","sorted"+file+".csv");
						if ((insert = buffers[min_loc].readLine()) != null){
							rows[min_loc] =insert;
						}else
							{
								//worst_case = compare[2]+","+compare[2]+","+compare[2]+","+compare[2];
								rows[min_loc] = "empty";	
								counter++;
							}
						if (counter == buffers.length) 
						{
							state = false;
							break;
						}
				}//endwhile
		}//endif
	}

	public static String[] findmin(String[] arr,int attr)
	{
		String []min={"","",""};
		int max = 0;
	    int tmp;
		for (int counter=0;counter<arr.length;counter++)
		{
			if (arr[counter]!=null && arr[counter]!="empty")
			{
				if (Integer.parseInt(arr[counter].split(",")[attr])>max)
					{
						max = Integer.parseInt(arr[counter].split(",")[attr])+10;
					}
			}
		} 
	    int minimum = max;
		
	    for (int counter = 0; counter < arr.length ; counter++) {
			if (arr[counter]!=null &&arr[counter]!="empty")
			{	
				tmp = Integer.parseInt(arr[counter].split(",")[attr]);
		    	if (tmp<minimum)
		    	{
		    		minimum = tmp;
		    		min[0] = arr[counter];//record
		    		min[1] = ""+counter;//record location
		    	}
			}
		}
		min[2] = ""+max; // maximum value of the attribute
	    return min;
	} 
}
