package com.studentManagement.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;

import com.studentManagement.entity.Student;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studentManagement.entity.User;
import com.studentManagement.repository.UserRepo;

@Controller
@RequestMapping("/user")
public class StudentController
{
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentService studentService;

	private User user;

	@ModelAttribute
	public void commonUser(Principal p, Model m)
	{
		if (p != null) {
			String email = p.getName();
			user = userRepo.findByUserId(email);
			m.addAttribute("user", user);
		}
	}
	@GetMapping("/profile")
	public String profile(Model m)
	{
		Student s = studentRepository.findByUserId(user.getUserId());
		m.addAttribute("student", s);
		System.out.println(s.getFirstName());
		return "user_profile";
	}
//	@GetMapping("/display")
//	public ResponseEntity<byte[]> displayImage(@RequestParam("id") String id) throws IOException, SQLException
//	{
//		Student s = studentRepository.findById(id).get();
//		byte [] imageBytes = s.getImage().getBytes(1,(int) s.getImage().length());
//		System.out.println(imageBytes.length);
//		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//	}
@GetMapping("/firstSemester")
public String listStudents1(Model model, Principal p) {
	model.addAttribute("students", studentService.getFirstSemester());
//		System.out.println(p.getName());
	return "firstMarks";
}

	@GetMapping("/secondSemester")
	public String listStudents2(Model model, Principal p) {
		model.addAttribute("students", studentService.getSecondSemester());
//		System.out.println(p.getName());
		return "firstMarks";
	}

	@GetMapping("/thirdSemester")
	public String listStudents3(Model model, Principal p) {
		model.addAttribute("students", studentService.getThirdSemester());
//		System.out.println(p.getName());
		return "firstMarks";
	}

	@GetMapping("/fourthSemester")
	public String listStudents4(Model model, Principal p) {
		model.addAttribute("students", studentService.getFourthSemester());
//		System.out.println(p.getName());
		return "firstMarks";
	}

	@GetMapping("/fifthSemester")
	public String listStudents5(Model model, Principal p) {
		model.addAttribute("students", studentService.getFifthSemester());
//		System.out.println(p.getName());
		return "firstMarks";
	}

	@GetMapping("/sixthSemester")
	public String listStudents6(Model model, Principal p) {
		model.addAttribute("students", studentService.getSixthSemester());
//		System.out.println(p.getName());
		return "firstMarks";
	}

	@GetMapping("/seventhSemester")
	public String listStudents7(Model model, Principal p) {
		model.addAttribute("students", studentService.getSeventhSemester());
//		System.out.println(p.getName());
		return "firstMarks";
	}

	@GetMapping("/eighthSemester")
	public String listStudents8(Model model, Principal p) {
		model.addAttribute("students", studentService.getEighthSemester());
//		System.out.println(p.getName());
		return "firstMarks";
	}

	//======================================================================================================================================================

	@GetMapping("/firstSemester/attendance")
	public String listStudents11(Model model, Principal p) {
		model.addAttribute("students", studentService.getFirstSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/secondSemester/attendance")
	public String listStudents12(Model model, Principal p) {
		model.addAttribute("students", studentService.getSecondSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/thirdSemester/attendance")
	public String listStudents13(Model model, Principal p) {
		model.addAttribute("students", studentService.getThirdSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/fourthSemester/attendance")
	public String listStudents14(Model model, Principal p) {
		model.addAttribute("students", studentService.getFourthSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/fifthSemester/attendance")
	public String listStudents15(Model model, Principal p) {
		model.addAttribute("students", studentService.getFifthSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/sixthSemester/attendance")
	public String listStudents16(Model model, Principal p) {
		model.addAttribute("students", studentService.getSixthSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/seventhSemester/attendance")
	public String listStudents17(Model model, Principal p) {
		model.addAttribute("students", studentService.getSeventhSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/eighthSemester/attendance")
	public String listStudents18(Model model, Principal p) {
		model.addAttribute("students", studentService.getEighthSemester());
//		System.out.println(p.getName());
		return "attendance";
	}

	@GetMapping("/getFees")
	public String listFees(Model model, Principal p) {
		model.addAttribute("students", studentService.getFees());
//		System.out.println(p.getName());
		return "Fees";
	}
}
