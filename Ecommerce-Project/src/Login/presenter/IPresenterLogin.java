package Login.presenter;

import java.sql.SQLException;

public interface IPresenterLogin 
{
	void login();
	void pass(String username,String password);
	void signup(String username, String password) throws SQLException;
	String delete_account(String username, String password) throws SQLException;
}