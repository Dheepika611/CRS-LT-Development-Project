/**
 * 
 */
package com.lt.crs.controller;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.dao.LoginDto;
import com.lt.crs.dao.PasswordDto;
import com.lt.crs.dao.StudentDto;
import com.lt.crs.dao.UserDto;
import com.lt.crs.entity.Role;
import com.lt.crs.entity.Student;
import com.lt.crs.entity.User;
import com.lt.crs.service.UserService;

/**
 * @author G1
 *User controller class where login ,register & update password rest endpoints are existed 
 */
@RestController
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	/**
	 * Student self Registration Endpoint where user can send request for  Registration
	 * @param student
	 * @return
	 */
	//@PostMapping("/register")
	@RequestMapping( method = RequestMethod.POST,value = "/register")
	public ResponseEntity<Student> saveStudent(@RequestBody StudentDto studentDto) {
		logger.info("Inside Student Registration method");
		Student student = userService.saveStudent(studentDto);
		logger.info("End of student Registration");
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	
	/**
	 * User login rest endpoint 
	 * @param loginDto
	 * @return
	 */
	//@PostMapping("/login")
	@RequestMapping( method = RequestMethod.POST,value = "/login")
	public ResponseEntity<UserDto> userLogin(@RequestBody LoginDto loginDto) {
		logger.info("Inside  userLogin method");

		User user = userService.userLogin(loginDto);
		Iterator<Role> iterator=user.getRoles().iterator();
		Role role=new Role();
		while(iterator.hasNext()) {
			role=iterator.next();
		}
		
		UserDto userdto=new UserDto();
		userdto.setUserId(user.getId());
		userdto.setRole(role.getName());
		userdto.setUserName(user.getUsername());
		logger.info("End of userLogin method");

		return new ResponseEntity<UserDto>(userdto, HttpStatus.OK);
	}
	/**
	 * Update password rest endpoint
	 * @param passwordDto
	 * @return
	 */
	//@PostMapping("/updatePassword")
	@RequestMapping( method = RequestMethod.POST,value = "/updatePassword")
	public ResponseEntity<String> chnagePassword(@RequestBody PasswordDto passwordDto) {
		logger.info("Inside chnagePassword method");

		User user = userService.chnagePassword(passwordDto);
		logger.info("End of  chnagePassword method");

		return new ResponseEntity<String>("Password has been changed sucessfully For :"+user.getId(), HttpStatus.OK);
	}
	

}
