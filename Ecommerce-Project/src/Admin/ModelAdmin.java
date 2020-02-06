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
		ArrayList arrayListObject = new ArrayList();
		arrayListObject = (ArrayList) details;
		
		Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
		Statement s1 = c.createStatement();
		s1.execute("insert into ProductsDetails (Product_Name,Category_Name,Product_Description,Qty,Price) values ('"+arrayListObject.get(0).toString()+"','"+arrayListObject.get(1).toString()+"','"+arrayListObject.get(2).toString()+"',"+arrayListObject.get(3).toString()+","+arrayListObject.get(4).toString()+")");
		return "product added successfully";	
	}
	
	public String removefromtable(int S_No) throws SQLException
	{
		Connection connectionObject = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
		Statement statementObject = connectionObject.createStatement();
		statementObject.executeUpdate("delete from ProductsDetails where S_No="+S_No);
		return "Product removed successfully";
		
	}
}
