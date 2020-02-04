package Login;

import java.sql.SQLException;

public interface IViewLogin
{
	void userlogin();
	void signup() throws SQLException;
	void delete_account() throws SQLException;
	void setPresenter(IPresenterLogin presenter);
	void updateStatusLabel(String result);
}