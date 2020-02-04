package Login;

import java.sql.SQLException;

public interface IModelLogin 
{
	void set(String username,String password);
	String login() throws Exception;
	void signup(String username, String password) throws SQLException;
	String delete_account(String username, String password) throws SQLException;
}