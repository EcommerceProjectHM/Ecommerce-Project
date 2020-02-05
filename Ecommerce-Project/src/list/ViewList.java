package list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewList implements IViewList 
{
	private IPresenterList presenterlist;
	private ArrayList<String> productS_No = new ArrayList<String>();

	public int checkTheS_No() 
	{
		@SuppressWarnings("resource")
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("Please enter the S_No if You want");
		int number = scannerObject.nextInt();
		for (int i = 0; i < this.productS_No.size(); i++) 
		{
			if (number == (int) Integer.parseInt(this.productS_No.get(i).toString()))
			{
				return number;
			}
		}
		System.err.println("Please enter the vcategory_nameid S_No");
		checkTheS_No();
		return 0;
	}

	public void category() throws SQLException 
	{
		try 
		{
			Object ss = presenterlist.category();
			ArrayList<String> category_name = new ArrayList<String>();
			System.out.println("-----------------------");
			System.out.println("S_No " + "Category_Name ");
			System.out.println("-----------------------");

			while (((ResultSet) ss).next())
			{
				String S_No = ((ResultSet) ss).getString("S_No");
				String Category_Name = ((ResultSet) ss).getString("Category_Name");
				category_name.add(Category_Name);
				System.out.println(S_No + "    " + Category_Name);
			}
			System.out.println("-----------------------");

			System.out.println("\nPlease select the S_no if you interest");
			@SuppressWarnings("resource")
			Scanner scannerObject = new Scanner(System.in);
			int category = scannerObject.nextInt();
			
			int count = 0;
			if (category_name.size() >= category && category > 0)
			{
				count++;
			}
			else 
			{
				System.err.println("Please select correct S_no");
				category();
			}
			
			if(count == 1)
			{
				Object productlist = presenterlist.categoryS_No(category_name.get(category - 1).toString());
				System.out.println("\nProduct Details :");
				System.out.println("------------------------------------------------");
				System.out.println("S_No " + "Product_Name  " + "Product_Description  " + "Price ");
				System.out.println("------------------------------------------------");

				while (((ResultSet) productlist).next()) 
				{
					String S_No = ((ResultSet) productlist).getString("S_No");
					String Product_Name = ((ResultSet) productlist).getString("Product_Name");
					String Product_Description = ((ResultSet) productlist).getString("Product_Description");
					String Price = ((ResultSet) productlist).getString("Price");
					System.out.println(S_No + "   " + Product_Name + "        " + Product_Description + "       " + Price);
					this.productS_No.add(S_No);
				}
				System.out.println("------------------------------------------------");
			}
		}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
	}

	public void setPresenter(IPresenterList prese) throws SQLException
	{
		this.presenterlist = prese;
		category();
	}

	public void updateStatusLabel(String result)
	{
		System.out.println(result);
	}

}
