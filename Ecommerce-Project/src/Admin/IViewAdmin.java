package Admin;

import java.sql.SQLException;

public interface IViewAdmin 
{
	public void setPresenter(IPresenterAdmin prese) throws SQLException;
	void addproducts() throws SQLException;
	void removeproducts() throws SQLException;
	void viewproducts() throws SQLException;
}
