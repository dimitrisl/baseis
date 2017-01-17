import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Receivelists {

	public void reclists(String file,int numfiles,int attribute,int memorysize) throws IOException
	{
			if (numfiles<=memorysize)
			{
			BufferedReader[] buffers = new BufferedReader[numfiles];
			String []rows = new String[memorysize];

				for (int i = 0;i<rows.length;i++)
				{
					rows[i]="";//initialization
				}
				for (int i= 0 ;i<numfiles;i++)
				{
					buffers[i]=new BufferedReader(new FileReader(file+i+"sublist.csv"));
					rows[i] = buffers[i].readLine();
				}

				int min_loc;
				String []compare;
				String insert = "";
				Boolean state = true;
				String worst = "";
				while (state)
				{
					compare = findmin(rows,attribute);
					min_loc = Integer.parseInt(compare[1]);
					ReadingWritingFile.Writethis(rows[min_loc],"sorted"+file+".csv");
					insert = buffers[min_loc].readLine();
					if (insert != null){
						rows[min_loc] =insert;
					}else
						{
							rows[min_loc]="999999990";
							for (int counter = 0 ; counter<rows[min_loc].split(",").length -1;counter++)
								{
								rows[min_loc] += ",999999990";
								}
							worst = rows[min_loc];
						}
					int flag =0;
					for (int i = 0 ;i<rows.length;i++)
					{
						if (rows[i].equals(worst))
						{
							flag++;
						}
					}
					if (flag == rows.length)
					{
						state = false;
						break;
					}
				}
		}
	}

	public static String[] findmin(String[] arr,int attr)
	{
		String []min={"",""};
		String min_location = "";
	    int tmp ;
	    int minimum = Integer.parseInt(arr[0].split(",")[attr]);
		for (int counter = 1; counter < arr.length ; counter++) {
	    	tmp = (Integer.parseInt(arr[counter].split(",")[attr]));
	    	if (tmp<minimum)
	    	{
	    		minimum = tmp;
	    		min[0] = arr[counter];
	    		min[1] = ""+counter;
	    	}
	    }
	    return min; // return max line
	} 

}
