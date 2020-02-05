package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelAdmin implements IModelAdmin
{
	@SuppressWarnings("rawtypes")
	public String adddetails(Object details) throws SQLException
	{
		ArrayList al = new ArrayList();
		al = (ArrayList) details;
		
		Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
		Statement s1 = c.createStatement();
		s1.execute("insert into ProductsDetails (Product_Name,Category_Name,Product_Description,Qty,Price) values ('"+al.get(0).toString()+"','"+al.get(1).toString()+"','"+al.get(2).toString()+"',"+al.get(3).toString()+","+al.get(4).toString()+")");
		return "product added successfully";	
	}
	
	public String removefromtable(int S_No) throws SQLException
	{
		Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
		Statement s1 = c.createStatement();
		s1.executeUpdate("delete from ProductsDetails where S_No="+S_No);
		return "Product removed successfully";
		
	}
}
