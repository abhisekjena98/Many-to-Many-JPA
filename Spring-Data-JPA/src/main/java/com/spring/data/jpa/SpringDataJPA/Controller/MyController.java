package com.spring.data.jpa.SpringDataJPA.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.jpa.SpringDataJPA.Entity.Course;
import com.spring.data.jpa.SpringDataJPA.Entity.Student;
import com.spring.data.jpa.SpringDataJPA.Repository.CourseRepository;
import com.spring.data.jpa.SpringDataJPA.Repository.StudentRepository;

@RestController
@RequestMapping("/student/courses")
public class MyController {

	StudentRepository studentRepository;
	
	CourseRepository courseRespository;
	
	public MyController(StudentRepository studentRepository, CourseRepository courseRespository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRespository = courseRespository;
	}
	
	

	@PostMapping("/addstudent")
	public Student saveStudentWithCourse (@RequestBody Student student) {
		
		
		//Student s = new Student();
		//s.getClass().get
		
		return studentRepository.save(student);
	}
	
	@GetMapping("/studentlist")
	public List<Student> findAllStudents (){
		
		return studentRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Student findStudent(@PathVariable long id) {
		
		return studentRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/find/{name}")
	public List<Student> findStudentsContainingName(@PathVariable String name) {
		
		return studentRepository.findByNameContaining(name);
	}
	
	@GetMapping("search/{price}")
	public List<Course> findCourseLessThanPrice(@PathVariable double price){
		
		return courseRespository.findByFeesLessThan(price);
	}
	
	
}
