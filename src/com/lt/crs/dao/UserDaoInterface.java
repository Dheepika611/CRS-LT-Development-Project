package com.lt.crs.dao;

import java.util.List;

public interface UserDaoInterface {
	public void checkUser(String username, String password);
	public void updatePassword(List inpList);
	public void checkPassword(String usernameinp, String oldpassinp, String newpassinp);
}
