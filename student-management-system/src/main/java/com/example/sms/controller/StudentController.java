package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list students and return mode and view
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// Create student object to hold student form data
		Student s1=new Student();
		model.addAttribute("student",s1);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable long id, Model model) {
		
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable long id,@ModelAttribute("student") Student student, Model model) {
		//get student from database from ID
		
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	// handler method to handle student delete request
	@GetMapping("students/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
}
