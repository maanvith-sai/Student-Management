package com.studentManagement.service;

import com.studentManagement.entity.Student;
import com.studentManagement.entity.semester.*;
import com.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(String studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(String studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public List<first> getFirstSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromFirstSemester(username);

	}

	@Override
	public List<second> getSecondSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromSecondSemester(username);
	}

	@Override
	public List<third> getThirdSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromThirdSemester(username);
	}

	@Override
	public List<fourth> getFourthSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromFourthSemester(username);
	}

	@Override
	public List<fifth> getFifthSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromFifthSemester(username);
	}

	@Override
	public List<sixth> getSixthSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromSixthSemester(username);
	}

	@Override
	public List<seventh> getSeventhSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromSeventhSemester(username);
	}

	@Override
	public List<eighth> getEighthSemester() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromEighthSemester(username);
	}

	@Override
	public List<Fees> getFees() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();

		return studentRepository.findFromFees(username);
	}

}
