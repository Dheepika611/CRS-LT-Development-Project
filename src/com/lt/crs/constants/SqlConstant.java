package com.lt.crs.constants;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class contains all the SQL queries used in the CRS application
 */
public class SqlConstant {
	
//User DAO Queries
	public static final String VIEW_USERS = "select * from user where username=?";
	public static final String SELECT_MAX_USER_ID = "SELECT MAX(user_id) as user_id from user";
	public static final String ADD_USER="insert into user vales()";
	public static final String DROP_USER="delete from user where user_id=?";
	public static final String UPDATE_PASSWORD = "update user set password=? where role_id=? and username=? and password=?";
//Student DAO Queries
	public static final String SELF_REGISTER = "insert into student(stud_id, stud_name, email, dob, user_id) values(?,?,?,?,?)";
	public static final String ADD_USER_BY_STUDENT = "insert into user(user_id,username, password,role_id) values(?,?,?,2)";
	public static final String UPDATE_USER_ID_IN_STUDENT = "update student set user_id = ? where stud_id =?";
	public static final String SELECT_MAX_STUD_ID = "SELECT MAX(stud_id) as stud_id from student";
	public static final String VIEW_REPORT_CARD = "select * from reportcard where stud_id=?";
	public static final String VIEW_PAYMENT = "select * from payment where stud_id=?";
//Professor DAO Queries
	//public static final String ADD_PROFESSOR = "insert into professor(prof_id, prof_name) values(?,?)";
	//public static final String VIEW_PROFESSOR = "delete from professor where prof_id= ?";
	public static final String ADD_MARKS_FOR_STUDENT = "insert into reportcard values ()";
//Admin DAO Queries
	public static final String ADD_COURSE="";
	public static final String DROP_COURSE="";
	public static final String ADD_STUDENT="";
	public static final String DROP_STUDENT="";
//Payment DAO Queries
	public static final String FETCH_COURSE_FEE = "select sum(course_fee) from course_catalogue where course_id in (select course_id from course where stud_id=?)";
	//public static final String FETCH_COURSES = "select course_id from course where stud_id=?";
	public static final String FETCH_USER_ID = "select user_id from user where username=?";
	public static final String SELECT_MAX_BILL_ID = "select MAX(bill_id) from payment";
	public static final String INSERT_IN_PAYMENT = "insert into payment(bill_id, stud_id, mode_of_pay, bill_amount) values (?,?,?,?)";
	public static final String VIEW_BILL = "select s.stud_id, stud_name, course_name, course_fee from student s inner join course c on s.stud_id=c.stud_id inner join course_catalogue cc on c.course_id = cc.course_id where s.stud_id=?";
//Course DAO Queries
	public static final String FETCH_STUDENT_ID = "select stud_id from student where user_id=?";
	public static final String VIEW_COURSE_CATALOGUE = "select course_id, course_name, course_fee from course_catalogue";
	//public static final String ADD_COURSE_TO_STUDENT = "update student set course_id = ? where user_id = ?"; //insrt into course
	public static final String ADD_COURSE_TO_STUDENT1 = "insert into course(course_id,stud_id,sem) values(?,?,1)";
	public static final String DROP_COURSE_FROM_STUDENT = "delete from course where course_id=? and stud_id=?";
	public static final String SELECT_COURSE_FOR_STUDENT = "SELECT c.course_id, course_name, course_fee from course c inner join course_catalogue cc on c.course_id = cc.course_id and stud_id=?";
//Reportcard DAO Queries
    public static final String SELECT_MAX_REPORT_ID = "SELECT MAX(report_id) as report_id from reportcard";
    public static final String STUDENT_COURSE_LIST ="select u.user_id,u.username,r.course_id as course_id ,r.marks,r.status from user u  left join reportcard r on r.stud_id=u.user_id where u.role_id=2";
    public static final String REPORT_BY_STUDENT_ID="select u.user_id,u.username,r.course_id as course_id ,r.marks,r.status from user u  left join reportcard r on r.stud_id=u.user_id where u.role_id=2 and u.user_id=?";
    
    
    
    public static final String student_login_query="select * from student where student_id=? and student_password=?";
	public static final String user_role_student="select * from user_role where user_id=? and role_id=3";
	public static final String user_role_professor="select * from user_role where user_id=? and role_id=2";
	public static final String professor_login_query="select * from professor where professor_id=? and professor_password=?";
	public static final String user_role_admin="select * from user_role where user_id=? and role_id=1";
	public static final String admin_login_query="select * from admin where admin_id=? and admin_password=?";
	public static final String admin_password_update="update admin set admin_password=? where admin_id=?";
	public static final String professor_password_update="update professor set professor_password=? where professor_id=?";
	public static final String student_password_update="update student set student_password=? where student_id=?";
	public static final String student_registeration="insert into student (student_name,student_password,student_department) values (?,?,?)";
	public static final String student_course_check="select * from course_professor_student where student_id=? and course_id=?";
	public static final String get_course_cost="select course_cost from course where course_id=?";
	public static final String payment_details = "insert into payment (student_id,course_id,payment_status,amount) values(?,?,?,?)";
}