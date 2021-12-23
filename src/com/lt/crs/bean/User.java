package com.lt.crs.bean;

public class User {
	
private static int userId;
private static String username;
private static String password;
private static int role_id;

public static int getUserId() {
	return userId;
}
public static void setUserId(int userId) {
	User.userId = userId;
}
public static String getUsername() {
	return username;
}
public static void setUsername(String username) {
	User.username = username;
}
public static String getPassword() {
	return password;
}
public static void setPassword(String password) {
	User.password = password;
}
public static int getRole_id() {
	return role_id;
}
public static void setRole_id(int role_id) {
	User.role_id = role_id;
}
}
