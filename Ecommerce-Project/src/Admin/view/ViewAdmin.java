package Admin.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Admin.presenter.IPresenterAdmin;
import Login.model.ModelLogin;
import Login.presenter.PresenterLogin;
import Login.view.ViewLogin;
import list.model.ModelList;
import list.presenter.PresenterList;
import list.view.IViewList;
import list.view.ViewList;

public class ViewAdmin implements IViewAdmin
{
	private IPresenterAdmin presenteradmin; 
	
	public void setPresenter(IPresenterAdmin prese) throws SQLException 
	{
		this.presenteradmin = prese;
		showdetails();
	}
	
	@SuppressWarnings("resource")
	
	// show details
	void showdetails() throws SQLException
	{
		Scanner scannerObject=new Scanner(System.in);
		while(true)
		{
			System.out.println("Add products Press ---> 1");
			System.out.println("Remove products Press ---> 2");
			System.out.println("View products Press ---> 3");
			System.out.println("logout Press ---> 4");
		int option = scannerObject.nextInt();
		switch(option)
		{
			case 1:addproducts();break;
			case 2:removeproducts();break;
			case 3:viewproducts();break;
			case 4:
			{
				ViewLogin view = new ViewLogin();
				view.setPresenter(new PresenterLogin(view,new ModelLogin()));
			}
			default :continue;
		}
		}
	}
	
	// add products
	public void addproducts() throws SQLException
	{
		
		@SuppressWarnings("resource")
		Scanner scannerObject = new Scanner(System.in);
		ArrayList<String> arrayListObject= new ArrayList<String>();
		
		
		System.out.println("Enter the Product_Name");
		arrayListObject.add(scannerObject.nextLine());
		System.out.println("Enter the Category_Name");
		arrayListObject.add(scannerObject.nextLine());
		System.out.println("Enter the Product_Description");
		arrayListObject.add(scannerObject.nextLine());
		System.out.println("Enter the Qty");
		arrayListObject.add(scannerObject.nextLine());
		System.out.println("Enter the price");
		arrayListObject.add(scannerObject.nextLine());
		System.out.println("Please select option \nPrint Press ---> 1\nStore Press ---> 2 \nRe-enter Press ---> 3");
		int data = scannerObject.nextInt();
		
		switch(data)
		{
			case 1:
			{
			    System.out.println(arrayListObject);
			    break;
			}
			case 2:
				try 
				{
						System.out.println(presenteradmin.addproducts(arrayListObject));
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
					
				}
				break;
		    case 3:
		    	{
		    		arrayListObject.removeAll(arrayListObject);
			    	addproducts();break;
			    	
		    	}
		}
		showdetails();	
	}
	public void removeproducts() throws SQLException
	
	{
		IViewList viewlist = new ViewList();
		viewlist.setPresenter(new PresenterList(viewlist,new ModelList()));
		//System.out.println("Enter the S_No if you want to remove");
		int S_No = viewlist.checkTheS_No();
		System.out.println(presenteradmin.removeProducts(S_No));
		showdetails();	
	}
	public void viewproducts() throws SQLException
	{
		IViewList viewlist = new ViewList();
		viewlist.setPresenter(new PresenterList(viewlist,new ModelList()));
		showdetails();
	}
	
//	public static void main(String args[]) throws SQLException 
//	{
//		IViewAdmin viewadmin = new ViewAdmin();
//		viewadmin.setPresenter(new PresenterAdmin(viewadmin,new ModelAdmin()));
//	}
}
