package com.spring.data.jpa.SpringDataJPA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.jpa.SpringDataJPA.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByFeesLessThan(double fees); 
}
