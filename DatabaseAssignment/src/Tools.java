
public class Tools {
	
	public static String decidenlj(int numOfLines1,int numOfLines2,int memsize)
	{
		String decision = "";
		
		if ((numOfLines1>memsize) && (numOfLines2>memsize))
		{
			decision = "None";
		}
		else if ((numOfLines1<=memsize) ^ (numOfLines2<=memsize))
		{
			decision = "One";
		}
		else if (numOfLines1+numOfLines2<=memsize)
		{
			decision = "Both";
		}
		return decision; //poia apo tis 3 periptwseis nlj
	}
	
	public static String swapString(String a,String b){
		return a;
	}
	
	public static int swapInt(int a,int b){
		return a;
	}
	

}
