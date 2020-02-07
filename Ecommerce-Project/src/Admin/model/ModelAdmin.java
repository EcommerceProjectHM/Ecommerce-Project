package Admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Login.model.ModelLogin;

public class ModelAdmin implements IModelAdmin
{
	
	
	public  static Object connection() throws SQLException
	{

		Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63; database = {fresher_ecom_task}","ecomfresher","Change@Fresher");
		Statement statementObject = c.createStatement();
		 return statementObject;
	}
	@SuppressWarnings("rawtypes")
	public String adddetails(Object details) throws SQLException
	{
		ArrayList arrayListObject = new ArrayList();
		arrayListObject = (ArrayList) details;
		 Object statementObject=ModelAdmin.connection();
		

		Statement statementObject1 = ModelLogin.connection();
		statementObject1.execute("insert into ProductsDetails (Product_Name,Category_Name,Product_Description,Qty,Price) values ('"+arrayListObject.get(0).toString()+"','"+arrayListObject.get(1).toString()+"','"+arrayListObject.get(2).toString()+"',"+arrayListObject.get(3).toString()+","+arrayListObject.get(4).toString()+")");

		((Statement) statementObject).execute("insert into ProductsDetails (Product_Name,Category_Name,Product_Description,Qty,Price) values ('"+arrayListObject.get(0).toString()+"','"+arrayListObject.get(1).toString()+"','"+arrayListObject.get(2).toString()+"',"+arrayListObject.get(3).toString()+","+arrayListObject.get(4).toString()+")");
		return "product added successfully";	
	}
	
	public String removefromtable(int S_No) throws SQLException
	{
		Statement statementObject1 = ModelLogin.connection();
		statementObject1.executeUpdate("delete from ProductsDetails where S_No="+S_No);
		
		 Object statementObject=ModelAdmin.connection();
		
		((Statement) statementObject).executeUpdate("delete from ProductsDetails where S_No="+S_No);
		return "Product removed successfully";
		
		
	}
}
