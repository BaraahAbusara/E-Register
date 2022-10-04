package com.example.ERegister.repository;

import com.example.ERegister.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    Course findCourseById (int id );
}
