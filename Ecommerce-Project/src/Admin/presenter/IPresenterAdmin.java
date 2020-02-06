package Admin.presenter;

import java.sql.SQLException;

public interface IPresenterAdmin 
{
	public String addproducts(Object details) throws SQLException;
	public String removeProducts(int S_No) throws SQLException;
}
