package com.studentManagement.service;


import com.studentManagement.entity.Student;
import com.studentManagement.entity.semester.*;

import java.util.List;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student saveStudent(Student student);



	Student getStudentById(String studentId);
	Student updateStudent(Student student);

//	List<Student> findAllStudentsOfTeacher();


	void deleteStudent(String studentId);

	List<first> getFirstSemester();
	List<second> getSecondSemester();
	List<third> getThirdSemester();
	List<fourth> getFourthSemester();
	List<fifth> getFifthSemester();
	List<sixth> getSixthSemester();
	List<seventh> getSeventhSemester();
	List<eighth> getEighthSemester();

	List<Fees> getFees();

}
