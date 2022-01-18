/**
 * 
 */
package com.lt.crs.service;


import com.lt.crs.dao.LoginDto;
import com.lt.crs.dao.PasswordDto;
import com.lt.crs.dao.StudentDto;
import com.lt.crs.entity.Student;
import com.lt.crs.entity.User;

/**
 * @author G1
 *
 */

public interface UserService {

	/**
	 * @param student
	 * @return
	 */
	Student saveStudent(StudentDto student);

	/**
	 * @param loginDto
	 * @return
	 */
	User userLogin(LoginDto loginDto);

	/**
	 * @param passwordDto
	 * @return
	 */
	User chnagePassword(PasswordDto passwordDto);
	

}
