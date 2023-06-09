package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
//				Student s1=new Student("Anupam","Kumar","anupam3083@gmail.com");
//				Student s2=new Student("Anshu","Barde","anshuBarde@gmail.com");
//				Student s3=new Student("Abc","se","aFSSA@gmail.com");
//				studentRepository.save(s1);
//				studentRepository.save(s2);
//				studentRepository.save(s3);
	}

}
