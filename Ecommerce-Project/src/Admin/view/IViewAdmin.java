package Admin.view;

import java.sql.SQLException;

import Admin.presenter.IPresenterAdmin;

public interface IViewAdmin 
{
	public void setPresenter(IPresenterAdmin prese) throws SQLException;
	void addproducts() throws SQLException;
	void removeproducts() throws SQLException;
	void viewproducts() throws SQLException;
}
