package utility;

import java.io.File;

public class Constant 

{

	public static final String URL="http://www.flipkart.com";
	public static final String Username = "ladu190788@gmail.com";
	 
    public static final String Password ="1qaz2WSX";

    static File resourcesDirectory = new File("flip_data.xlsx");
    static String fullPath=resourcesDirectory.getAbsolutePath();
	public static final String Path_TestData_old=fullPath.substring(0,fullPath.lastIndexOf(File.separator)+1);
	public static final String Path_TestData=Path_TestData_old.replace("\\", "\\\\");
	public static final String File_TestData="flip_data.xlsx";
    
    
	public static final int Col_TestCaseName = 0;	
	 
	public static final int Col_UserName=1;

	public static final int Col_Password=2;
	
	public static final int Col_Browser = 3;
	
	public static final int Col_saerchItem=4;
	
	public static final int Col_Result=5;
	
	
}
