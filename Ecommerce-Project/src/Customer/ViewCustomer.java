package Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import list.IViewList;
import list.ModelList;
import list.PresenterList;
import list.ViewList;

public class ViewCustomer implements IViewCustomer
{
	private IPresenterCustomer presentercustomer; 
	private String username;
	
	public void setPresenter(IPresenterCustomer presenetr) throws SQLException 
	{
		this.presentercustomer = presenetr;
		showdetails() ;
	}
	void showdetails() throws SQLException
	{
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("press 1 view product list \n press 2 view cart \n press 3 logout");
		switch(scannerObject.nextInt())
		{
		case 1:{customer();break;}
		case 2:{cartdetails();break;}
		case 3:System.exit(0);break;
		}
	}
	
	public void cartdetails() throws SQLException
	{   
		Scanner scannerObject = new Scanner(System.in);
		String customer = this.username;int S_No=0;
		Object cart = presentercustomer.showcart(customer);
		System.out.println("S_No "+"Customer_name "+"Product_Name "+"Category_name "+" Product_Description "+" Price");
		 
		while(((ResultSet) cart).next())
		{
		        System.out.print(((ResultSet) cart).getString("S_No")+" ");
		        System.out.print(((ResultSet) cart).getString("Customer_Name")+" ");
		        System.out.print(((ResultSet) cart).getString("Product_Name")+" ");
		        System.out.print(((ResultSet) cart).getString("Category_Name")+" ");
		        System.out.print(((ResultSet) cart).getString("Product_Description")+" ");
		        System.out.print(((ResultSet) cart).getString("Price")+" ");
		        System.out.println();
		 }
		
		 System.out.println("Remove from cart press 1 \n Buy press 2");
		 
		 switch(scannerObject.nextInt())
		 {
		 case 1:{
				 System.out.println("Enter the S_No if you want to remove");
				 S_No = scannerObject.nextInt();
				 System.out.println(presentercustomer.removecart(S_No));break;
			    }
		 case 2:{
				 System.out.println("Enter the S_No if you want to buy");
				 S_No = scannerObject.nextInt();
				 buy(S_No);break;}
		        }
		 showdetails();
	}
	
	public ViewCustomer(String username)
	{
		this.username = username;
	}
	public  void customer() throws SQLException
	{   
        System.out.println("The following category products are avilable");
		IViewList viewlist = new ViewList();
		viewlist.setPresenter(new PresenterList(viewlist,new ModelList()));
		
		
			Scanner scannerObject = new Scanner(System.in);
			System.out.println("Enter the product id");
			int product_id = scannerObject.nextInt();
			System.out.println("Buy press 1 \n Add to cart press 2");
			
			switch(scannerObject.nextInt())
			{
				case 1:{buy( product_id);break;}
				case 2:{addToCart(product_id);break;}
			}
			showdetails();
	}
	public  void buy(int product_Id) throws SQLException 
	{
		 Scanner scannerObject=new Scanner(System.in);
		 System.out.println("Please enter the Quantity");
		 int quantity=scannerObject.nextInt();
		 System.out.println("Enter the Amount");
		 int givenPrice=scannerObject.nextInt();
		
		System.out.println(presentercustomer.buy(product_Id, quantity, givenPrice));
        System.out.println("Thank You "+this.username);
        showdetails();
	}
	public void addToCart(int product_id) throws SQLException
	{
		String customer =this.username;
		int S_No=0;
		System.out.println(presentercustomer.addcart(product_id,customer));
		System.out.println("if you want to view categoryList press 1 \n show cart press 2 ");
	    Scanner scannerObject=new Scanner(System.in);

		switch(scannerObject.nextInt())
		{
			case 1:{ customer();break;}
			case 2:{ cartdetails();}
		}	
		showdetails();
	}
}