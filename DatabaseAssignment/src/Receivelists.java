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
					ReadingWritingFile.Writethis(rows[min_loc]+"\n","sorted"+file+".csv");
					insert = buffers[min_loc].readLine();
					if (insert != null){
						rows[min_loc] =insert;
					}else
						{
							rows[min_loc]="--";
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
		String []min={"0","0"};
		String min_location = "";
	    int tmp  ;
	    int minimum = Integer.parseInt(arr[0].split(",")[attr]);
	    System.out.println(minimum);
		for (int counter = 1; counter < arr.length ; counter++) {
			//System.out.println(arr[counter]);
			if (arr[counter]!="--" && arr[counter]!=null)
			{	
				tmp = Integer.parseInt(arr[counter].split(",")[attr]);
		    	if (tmp<minimum)
		    	{
		    		minimum = tmp;
		    		min[0] = arr[counter];
		    		System.out.println(counter);
		    		min[1] = ""+counter;
		    	}
			}
		}
	    return min; // return max line
	} 



	public static void main(String[] args) throws IOException
	{
			reclists("B.csv", 30, 1, 200);
	}
}
