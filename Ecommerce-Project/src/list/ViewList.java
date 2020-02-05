package list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewList implements IViewList 
{
	private IPresenterList presenterlist;

	public void category() throws SQLException 
	{
		try 
		{
			Object ss = presenterlist.category();
			ArrayList<String> al = new ArrayList<String>();
			System.out.println("-----------------------");
			System.out.println("S_No " + "Category_Name ");
			System.out.println("-----------------------");
			
			while (((ResultSet) ss).next()) 
			{
				String S_No = ((ResultSet) ss).getString("S_No");
				String Category_Name = ((ResultSet) ss).getString("Category_Name");
				al.add(Category_Name);
				System.out.println(S_No + "    " + Category_Name);
			}
			System.out.println("-----------------------");
			
			System.out.println("\nPlease select the S_no if you interest");
			@SuppressWarnings("resource")
			Scanner scannerObject = new Scanner(System.in);
			int category = scannerObject.nextInt();
			if(al.size() >= category);
			else
			{
				System.err.println("Please select correct S_no");
				category();
			}
			Object productlist = presenterlist.categoryS_No(al.get(category - 1).toString());
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
			}
			System.out.println("------------------------------------------------");
			al = null;
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
