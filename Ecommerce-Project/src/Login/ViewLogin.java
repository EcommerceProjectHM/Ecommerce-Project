package Login;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewLogin implements IViewLogin 
{
	private IPresenterLogin presenterlogin; 
	
	public static void main(String args[]) 
	{
		//create the view class object
		ViewLogin view = new ViewLogin();
		
		//call the setPresenter method and then
		//Argument of create the PresenterLogin class object
		//PresenterLogin class object Argument of view class object and ModelLogin class object
		view.setPresenter(new PresenterLogin(view,new ModelLogin()));
	}
	
	public void setPresenter(IPresenterLogin presenter) 
	{
		this.presenterlogin = presenter;
		homepage();
	}

	//Home page method to call sign in or sign up or account delete method
	public void homepage()
	{
		@SuppressWarnings("resource")
		Scanner scannerObject1= new Scanner(System.in);
		System.out.println("Home Page :");
		System.out.println("Sign in Press ---> 1");
		System.out.println("Sign Up Press ---> 2");
		System.out.println("Account Delete Press ---> 3");
		System.out.println("Exit Application Press ---> 4");
		int option = scannerObject1.nextInt();

		switch(option)
		{
			case 1 : userlogin(); break;
			case 2 : try 
					{
						signup();
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					} break;
			case 3 : try 
					{
						delete_account();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					} break;
			case 4 : System.out.println("You had been successfully Exited"); System.exit(0); break;
			default : 
					{
						System.out.println("\nPlease Enter Valid Number");
						homepage();
					}
		}
	}

	//UserLogin method to get UserName and Password 
	//call the Interface presenterlogin methods
	public void userlogin() 
	{
		System.out.println("\nSign In Page :");
		@SuppressWarnings("resource")
		Scanner scannerObject1 = new Scanner(System.in);
		System.out.println("Enter Your Username :");
		String username = scannerObject1.nextLine();
		System.out.println("Enter Your Password :");
		String password = scannerObject1.nextLine();
		
		presenterlogin.pass(username,password);
		presenterlogin.login();
	}

	//Sign up method to create new account 
	public void signup() throws SQLException 
	{
		System.out.println("\nSign Up Page :");
		@SuppressWarnings("resource")
		Scanner scannerObject1 = new Scanner(System.in);
		System.out.println("Enter the Username :");
		String username = scannerObject1.nextLine();
		System.out.println("Enter the Password :");
		String password = scannerObject1.nextLine();
		
		presenterlogin.signup(username,password);
		System.out.println("Sign Up Successfully");
		homepage();
	}
	
	//Delete account method to delete exist account 
	public void delete_account() throws SQLException 
	{
		System.out.println("\nAccount Delete Page :");
		@SuppressWarnings("resource")
		Scanner scannerObject1 = new Scanner(System.in);
		System.out.println("Enter Your Username :");
		String username = scannerObject1.nextLine();
		System.out.println("Enter Your Password :");
		String password = scannerObject1.nextLine();
		
		String result = presenterlogin.delete_account(username,password);
		if("true" == result)
		{
			System.out.println("Account Delete Successfully");
			homepage();
		}
		else
		{
			System.out.println("Incorrect Username or Password");
			homepage();
		}
	}
	
	public void updateStatusLabel(String result) 
	{
		System.out.println(result);
		homepage();
	}
}