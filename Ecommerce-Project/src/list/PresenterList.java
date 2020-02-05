package list;

import java.sql.SQLException;

public class PresenterList implements IPresenterList 
{
	private IModelList modellist;
	@SuppressWarnings("unused")
	private IViewList viewlist;

	public PresenterList(IViewList view, IModelList model) 
	{
		this.modellist = model;
		this.viewlist = view;
	}
	
	public Object category() throws SQLException
	{ 
		return modellist.category();
	}
	
	public Object categoryS_No(String i) throws SQLException
	{
		return modellist.productlist(i);
	}
}
