
public class Bothnlj {
	
	String file1;
	String file2;
	int memory;
	int collumn1;
	int collumn2;
	
	public Bothnlj(String f1,String f2,int m,int collumn1,int collumn2)//filepath1,filepath2,memory size,collumnf1,collumnf2
	{
		file1 = f1;
		file2 = f2;
		memory = m;
		this.collumn1 = collumn1;
		this.collumn2 = collumn2;
	}
	
	public void joinstart()
	{
		
		int numberoflines1 = ReadingWritingFile.readFirstLineofFile(file1);
		int numberoflines2 = ReadingWritingFile.readFirstLineofFile(file2);
	}
}

