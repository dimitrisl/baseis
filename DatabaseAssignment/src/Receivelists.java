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

				int max_loc;
				String []compare;
				String insert = "";
				Boolean state = true;
				String worst = "";
				while (state)
				{
					compare = findmax(rows,attribute);
					max_loc = Integer.parseInt(compare[1]);
					ReadingWritingFile.Writethis(rows[max_loc],"sorted"+file+".csv");
					insert = buffers[max_loc].readLine();
					if (insert != null){
						rows[max_loc] =insert;
					}else
						{
							rows[max_loc]="0";
							for (int counter = 0 ; counter<rows[max_loc].split(",").length -1;counter++)
								{
								rows[max_loc] += ",0";
								}
							worst = rows[max_loc];
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

	public static String[] findmax(String[] arr,int attr)
	{
		String []max={"",""};
		String max_location = "";
	    int tmp ;
	    int maximum = 0;
		for (int counter = 0; counter < arr.length ; counter++) {
	    	tmp = (Integer.parseInt(arr[counter].split(",")[attr]));
	    	if (tmp>maximum)
	    	{
	    		maximum = tmp;
	    		max[0] = arr[counter];
	    		max[1] = ""+counter;
	    	}
	    }
	    return max; // return max line
	} 

}
