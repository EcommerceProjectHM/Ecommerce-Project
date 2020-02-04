package Admin;

import java.sql.SQLException;

public class PresenterAdmin implements IPresenterAdmin
{
	private IModelAdmin modeladmin;
	private IViewAdmin viewadmin;
	
	public PresenterAdmin(IViewAdmin view, IModelAdmin model) 
	{
		this.modeladmin = model;
		this.viewadmin = view;
	}
	
	public String addproducts(Object details) throws SQLException
	{
		return modeladmin.adddetails(details);
	}
	
	public String removeProducts(int S_No) throws SQLException
	{
		return modeladmin.removefromtable(S_No);
	}
}
