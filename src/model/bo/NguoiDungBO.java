package model.bo;

import model.dao.NguoiDungDAO;

public class NguoiDungBO {

	public boolean checkLogin(String username, String password) {
		if(username.equals("")||password.equals(""))
		{
			return false;
		}
		return NguoiDungDAO.checkLogin(username,password);
	}
}
