package Login;

import java.sql.Statement;

import Admin.IViewAdmin;
import Admin.ModelAdmin;
import Admin.PresenterAdmin;
import Admin.ViewAdmin;
import Customer.IViewCustomer;
import Customer.ModelCustomer;
import Customer.PresenterCustomer;
import Customer.ViewCustomer;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class ModelLogin implements IModelLogin
{
	  private String username;
	  private String password;
	  
		public void set(String username,String password) 
	    {
	        this.username = username;
	        this.password = password;
	    } 
		
		//Login method to connect the sqlserver and get the datas
		public String login() throws SQLException  
		{
			Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
			Statement s1 = c.createStatement();
			ResultSet rs = s1.executeQuery("select * from login");
		
			String result = "Please re-enter correct username and password :";

			while(rs.next())
			{
				String name  = rs.getString("User_Name");
				String password = rs.getString("Password");
			
				//check the given username and password is correct or not
				//Already username and password is stored in database
			    if(name.equals(this.username) && password.equals(this.password)) 
			    {
			    	System.out.println("Login Successfully");
				    if(username.contains("@admin"))
				    {
				    	IViewAdmin viewadmin = new ViewAdmin();
						viewadmin.setPresenter(new PresenterAdmin(viewadmin,new ModelAdmin()));
				    }
				    else
				    {
						IViewCustomer view = new ViewCustomer(username);
						view.setPresenter(new PresenterCustomer(view,new ModelCustomer()));
				    }
			    	result = "Thank You!";
				   break;
			    }
		  	}
			return result;
		}
		
		//Sign up the Account 
		public void signup(String username, String password) throws SQLException 
		{
			Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
			Statement s1 = c.createStatement();
			s1.executeUpdate("insert into login values ('"+ username + "','" + password+"')");
		}

		//Delete exist account 
		public String delete_account(String username, String password) throws SQLException 
		{
			Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
			Statement s1 = c.createStatement();
			ResultSet rs = s1.executeQuery("select * from login");
			
			String result = "false";
			while(rs.next())
			{
				String name  = rs.getString("User_Name");
				String pass = rs.getString("Password");
				
				//Username and password is correct means delete account
			    if(name.equals(username) && pass.equals(password))
			    {
					Connection c2 = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
					Statement s2 = c2.createStatement();
					s2.executeUpdate("DELETE FROM login WHERE User_Name ='"+ username +"' AND Password ='"+ password +"'");
					result = "true";break;
			    }
			}
			return result;
		}
}