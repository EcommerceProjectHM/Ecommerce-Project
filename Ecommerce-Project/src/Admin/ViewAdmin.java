package Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import list.IViewList;
import list.ModelList;
import list.PresenterList;
import list.ViewList;

public class ViewAdmin implements IViewAdmin
{
	private IPresenterAdmin presenteradmin; 
	
	public void setPresenter(IPresenterAdmin prese) throws SQLException 
	{
		this.presenteradmin = prese;
		showdetails();
	}
	
	@SuppressWarnings("resource")
	void showdetails() throws SQLException
	{
		Scanner scannerObject=new Scanner(System.in);
		System.out.println("Add products Press ---> 1");
		System.out.println("Remove products Press ---> 2");
		System.out.println("View products Press ---> 3");
		System.out.println("Exit Press ---> 4");
		int option = scannerObject.nextInt();
		
		switch(option)
		{
			case 1:addproducts();break;
			case 2:removeproducts();break;
			case 3:viewproducts();break;
			case 4:System.exit(0);;
		}
	}
	public void addproducts() throws SQLException
	{
		Scanner scannerObject = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<String>();
		
		System.out.println("Enter the Product_Name");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the Category_Name");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the Product_Description");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the Qty");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the price");
		al.add(scannerObject.nextLine());
		System.out.println("Please select option \nPrint Press ---> 1\nStore Press ---> 2 \nRe-enter Press ---> 3");
		int data = scannerObject.nextInt();
		
		switch(data)
		{
			case 1:
			{
			    System.out.println(al);
			    break;
			}
			case 2:
				try 
				{
						System.out.println(presenteradmin.addproducts(al));
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				break;
		    case 3:
		    	{
			    	al.removeAll(al);al.clear();
			    	addproducts();break;
		    	}
		}
		scannerObject.close();showdetails();	
	}
	public void removeproducts() throws SQLException
	{
		IViewList viewlist = new ViewList();
		viewlist.setPresenter(new PresenterList(viewlist,new ModelList()));
		System.out.println("Enter the S_No if you want to remove");
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
