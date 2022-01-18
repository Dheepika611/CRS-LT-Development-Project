package com.lt.crs.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.crs.dao.CourseProfessorDto;
import com.lt.crs.dao.EnrolledCourseDto;
import com.lt.crs.dao.PaymentDto;
import com.lt.crs.entity.Course;
import com.lt.crs.entity.CourseProfessor;
import com.lt.crs.entity.Payment;
import com.lt.crs.entity.Professor;
import com.lt.crs.entity.Student;
import com.lt.crs.entity.StudentCourse;
import com.lt.crs.entity.StudentGrade;
import com.lt.crs.exception.CourseDuplicationException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.InsufficientCardDetailsException;
import com.lt.crs.exception.MaxCourseRegistered;
import com.lt.crs.exception.NoCourseRegisterException;
import com.lt.crs.exception.NoReportCardException;
import com.lt.crs.exception.ProfessorNotFoundException;
import com.lt.crs.exception.ProfessorNotMappedToCourseException;
import com.lt.crs.exception.StudentNotFoundException;
import com.lt.crs.repository.CourseProfessorRepository;
import com.lt.crs.repository.CourseRepository;
import com.lt.crs.repository.PaymentRepository;
import com.lt.crs.repository.ProfessorRepository;
import com.lt.crs.repository.StudentCourseRepository;
import com.lt.crs.repository.StudentGradeRepository;
import com.lt.crs.repository.StundentRepository;

/**
 * 
 * @author G1
 * This class contains all the method implementations for student operations
 */
@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	/**
	 * Injecting the required dependencies using @autowired annotation
	 */
	@Autowired
	StundentRepository stundentRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	StudentCourseRepository studentCourseRepository;
	@Autowired
	StudentGradeRepository studentGradeRepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	CourseProfessorRepository courseProfessorRepository;
	List<Course> courses = null;
	EnrolledCourseDto vs = null;
	List<Professor> professors = null;
	List<CourseProfessorDto> courseProfessorDtos = null;
	List<EnrolledCourseDto> enrolledCourseDtos = null;
	EnrolledCourseDto enrolledCourseDto = null;

	/**
	 * This method adds the course to the student after checking the validations
	 * @param Student
	 */
	public void addCourseToTheStudent(StudentCourse student) {
		Student student1 = stundentRepository.findById(student.getStudentId())
				.orElseThrow(() -> new StudentNotFoundException(
						"ERROR: Student not found for ID# " + student.getStudentId()));
		
		if (!student1.isApproved()) {
			logger.info("Approve the studentId from Admin Controller");
			throw new StudentNotFoundException(
					"ERROR: Admin Approval Pending for Student ID# "+ student.getStudentId());
		}

		Course course = courseRepository.findById(student.getCourseId()).orElseThrow(
				() -> new CourseNotFoundException("ERROR: Course not found for ID# "+ student.getCourseId()));

		Professor professor = professorRepository.findById(student.getProfessorId())
				.orElseThrow(() -> new ProfessorNotFoundException(
						"ERROR: Professor not found for ID# " +student.getProfessorId()));

		List<CourseProfessor> courseProfessorList = courseProfessorRepository
				.findByCourseIdAndProfessorId(student.getCourseId(), student.getProfessorId());

		if (courseProfessorList.isEmpty()) {
			logger.info("Insert values for professor an course");
			throw new ProfessorNotMappedToCourseException(
					"Professor Not Mapped.");
		}

		List<StudentCourse> list = studentCourseRepository.findByStudentId(student.getStudentId());
		if (list.size() >= 4) {
			logger.info("The maximum course count for a student is 4.");
			throw new MaxCourseRegistered("ERROR: Course Limit Exceeded");
		}

		StudentCourse sc = studentCourseRepository.findByCourseIdAndStudentId(student.getCourseId(),
				student.getStudentId());
		if (sc != null) {
			logger.info("Try with different courseId");
			throw new CourseDuplicationException("ERROR: Course ID# " + student.getCourseId()+" already registered.");
		}
		studentCourseRepository.save(student);

	}

	/**
	 *This method drops the mapped course for the student
	 *@param studentId, courseId
	 */

	@Transactional
	public void dropCourse(int studentId, int courseId) {

		Student student1 = stundentRepository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException("ERROR: Student not found for ID# " + student.getStudentId()))));

		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("ERROR: Course not found for ID#" + courseId));

		studentCourseRepository.deleteByStudentIdAndCourseId(studentId, courseId);

	}

	/**
	 * This method displays the
	 * Registered courses ofr the student
	 * @param studentId
	 */

	public List<EnrolledCourseDto> viewEnrolledCourses(int studentId) {
		int i = 0;
		@SuppressWarnings("unused")
		Student student1 = stundentRepository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException(" student is not found with this id" + " " + studentId));
		List<StudentCourse> sc = studentCourseRepository.findByStudentId(studentId);
		if (sc.size() == 0) {
			throw new NoCourseRegisterException("No course registered yet");
		}
		List<Integer> courseIds = sc.stream().map(m -> m.getCourseId()).collect(Collectors.toList());
		List<Integer> professorIds = sc.stream().map(m -> m.getProfessorId()).collect(Collectors.toList());
		enrolledCourseDtos = new ArrayList<EnrolledCourseDto>();
		
		for (int courseId : courseIds) {
			enrolledCourseDto = new EnrolledCourseDto();
			Course course = courseRepository.findById(courseId).orElseThrow(
					() -> new CourseNotFoundException(" course is not found with this id" + " " + courseId+" "+"may be removed by the admin after student adds the course"));
			enrolledCourseDto.setCourseId(course.getCourseId());
			enrolledCourseDto.setCourseName(course.getCourseName());
			Professor professor = professorRepository.findById(professorIds.get(i++)).orElseThrow(
					() -> new ProfessorNotFoundException(" Professor is not found may be romoved by the admin" ));
			enrolledCourseDto.setProfessorId(professor.getProfessorId());
			enrolledCourseDto.setProfessorName(professor.getProfessorName());

			enrolledCourseDtos.add(enrolledCourseDto);
		}
		return enrolledCourseDtos;

	}

	/**
	 * This method displays the report card
	 * for the stduent
	 * @param studentId
	 */

	public List<StudentGrade> viewReportCard(int studentId) {

		@SuppressWarnings("unused")
		Student student1 = stundentRepository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException(" student is not found with this id" + " " + studentId));

		List<StudentGrade> grades = studentGradeRepository.findByStudentId(studentId);
		if (grades.size() == 0) {
			throw new NoReportCardException("Report card not found");
		}
		return grades;
	}

	/**
	 * Payment method checks the basic validations and saves the payment information
	 * in the table
	 */
	public Payment makePayment(PaymentDto paymentDto) {
		if (paymentDto.getCardNo().length() >= 13 && paymentDto.getCardNo().length() <= 16 && paymentDto.getExpiryDate()!=null) {
			if (paymentDto.getCvv().length() == 3) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
				simpleDateFormat.setLenient(false);
				Date expiry = null;
				try {
					expiry = simpleDateFormat.parse(paymentDto.getExpiryDate());
				} catch (ParseException e) {
					e.getMessage();
				}
				boolean expired = expiry.before(new Date());
				if (expired == true) {
					throw new InsufficientCardDetailsException("Card Already has been Expired");
				} else {

					@SuppressWarnings("unused")
					Student student = stundentRepository.findById(paymentDto.getStudentId())
							.orElseThrow(() -> new StudentNotFoundException(
									" student is not found with this id" + " " + paymentDto.getStudentId()));

					Course course = courseRepository.findById(paymentDto.getCourseId())
							.orElseThrow(() -> new CourseNotFoundException(
									"course not found with this id" + " " + paymentDto.getCourseId()));

					Payment payment = new Payment();
					payment.setStatus(true);
					payment.setCourseId(paymentDto.getCourseId());
					payment.setStudentId(paymentDto.getStudentId());
					payment.setAmount(course.getCourseCost());
					return payment = paymentRepository.save(payment);
				}

			} else {
				throw new InsufficientCardDetailsException("Enter the valid CVV number");
			}

		} else {
			throw new InsufficientCardDetailsException("Enter the valid card number");
		}

	}

	/**
	 * Displaying the available courses to the student so that student can
	 * registered for the student
	 */

	@Override
	public List<CourseProfessorDto> getAllCourses() {
		int i = 0;
		courseProfessorDtos = new ArrayList<CourseProfessorDto>();

		List<CourseProfessor> courseProfessorList = courseProfessorRepository.findAll();
		if (courseProfessorList.isEmpty()) {
			throw new CourseNotFoundException("No courses Found");
		}

		List<Integer> courseIds = courseProfessorList.stream().map(m -> m.getCourseId()).collect(Collectors.toList());
		List<Integer> professorIds = courseProfessorList.stream().map(m -> m.getProfessorId())
				.collect(Collectors.toList());

		for (int courseId : courseIds) {
			CourseProfessorDto courseProfessorDto = new CourseProfessorDto();
			Course course = courseRepository.findById(courseId).get();
			courseProfessorDto.setCourseId(course.getCourseId());
			courseProfessorDto.setCourseName(course.getCourseName());
			Professor professor = professorRepository.findById(professorIds.get(i++)).get();
			courseProfessorDto.setProfessorId(professor.getProfessorId());
			courseProfessorDto.setProfessorName(professor.getProfessorName());
			courseProfessorDtos.add(courseProfessorDto);
		}

		return courseProfessorDtos;
	}

}