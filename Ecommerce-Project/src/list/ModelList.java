package list;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelList implements IModelList 
{
	 //This method is used to view the category list
	 public Object category() throws SQLException
	 {
		Connection connectionObject = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63;databaseName={fresher_ecom_task};","ecomfresher","Change@Fresher");
		Statement statementObject = connectionObject.createStatement();
		ResultSet resultSetObject = statementObject.executeQuery("select * from Category_List");
		return resultSetObject;
	 }
	 
	 //This method is used to view the product list
	 public Object productlist(String i) throws SQLException 
	 {
		Connection connectionObject = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63;databaseName={fresher_ecom_task};","ecomfresher","Change@Fresher");
		Statement statementObject = connectionObject.createStatement();
		ResultSet resultSetObject = statementObject.executeQuery("select * from ProductsDetails where Category_Name='"+i+"'");
		return resultSetObject;
	 }
}
