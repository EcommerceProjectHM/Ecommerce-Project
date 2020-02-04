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
		try {
			Object ss = presenterlist.category();
			ArrayList<String> al = new ArrayList<String>();
			System.out.println("S_No " + "Category_Name ");
			while (((ResultSet) ss).next()) {
				String S_No = ((ResultSet) ss).getString("S_No");
				String Category_Name = ((ResultSet) ss).getString("Category_Name");
				al.add(Category_Name);
				System.out.println(S_No + " " + Category_Name);
			}

			System.out.println("Please select the S_no if you interest");
			Scanner scannerObject = new Scanner(System.in);
			int category = scannerObject.nextInt();
			Object productlist = presenterlist.categoryS_No(al.get(category - 1).toString());
			System.out.println("S_No " + "Product_Name " + "Product_Description " + "Price ");
			while (((ResultSet) productlist).next()) {
				String S_No = ((ResultSet) productlist).getString("S_No");

				String Product_Name = ((ResultSet) productlist).getString("Product_Name");

				String Product_Description = ((ResultSet) productlist).getString("Product_Description");

				String Price = ((ResultSet) productlist).getString("Price");

				System.out.println(S_No + " " + Product_Name + " " + Product_Description + " " + Price);

			}
			al = null;
		} catch (SQLException e) 
		{
			// TODimport ecom.list.view.IViewList;O Auto-generated catch block
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
