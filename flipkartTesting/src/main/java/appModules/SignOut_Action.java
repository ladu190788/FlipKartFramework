package appModules;



import pageObjects.Home_Page_main;
import utility.Utils;

public class SignOut_Action 
{
	public static void signOutExecute() throws Exception
	{
		Utils.mouseHoverAction(Home_Page_main.lnk_MyAccount(),"Logout").click();

	}
}