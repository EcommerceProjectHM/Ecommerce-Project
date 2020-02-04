package list;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ModelList implements IModelList 
{
	 public Object category() throws SQLException
	 {
		Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63;databaseName={fresher_ecom_task};","ecomfresher","Change@Fresher");
		Statement s1 = c.createStatement();
		ResultSet ss = s1.executeQuery("select * from Category_List");
		return ss;
	 }
	 
	 public Object productlist(String i) throws SQLException 
	 {
		Connection c = DriverManager.getConnection("jdbc:sqlserver://106.51.1.63;databaseName={fresher_ecom_task};","ecomfresher","Change@Fresher");
		Statement s1 = c.createStatement();
		ResultSet ss = s1.executeQuery("select * from ProductsDetails where Category_Name='"+i+"'");
		return ss;
	 }
}
