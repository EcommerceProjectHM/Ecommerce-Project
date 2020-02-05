package Admin;

import java.sql.SQLException;

public interface IModelAdmin 
{
	public String adddetails(Object details) throws SQLException;
	public String removefromtable(int S_No) throws SQLException;
}
