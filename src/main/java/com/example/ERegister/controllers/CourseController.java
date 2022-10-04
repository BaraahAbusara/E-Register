package com.example.ERegister.controllers;

import com.example.ERegister.model.Course;
import com.example.ERegister.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    @Autowired
    CourseRepo courseRepo;
//    Get Course with count of registration -> done
    @GetMapping("/course/count/{id}")
    public ResponseEntity<?> readCourseWithCountOfRegistration (@PathVariable int id) {
        Course course = courseRepo.findCourseById(id);
        return new ResponseEntity<>(course + "count of registrations : "+course.getStudents().size(),HttpStatus.OK);
    }
//    Course CRUD operations
//    create -> done
    @PostMapping("/course/create")
    public ResponseEntity<?> createCourse (@RequestBody Course course){
        courseRepo.save(course);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
//    read -> done
    @GetMapping("/course/{id}")
    public ResponseEntity<?> readCourse (@PathVariable int id) {
        Course course = courseRepo.findCourseById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
//    update -> done
    @PostMapping("/course/update/{id}")
    public ResponseEntity<?> updateCourse (@PathVariable int id ,@RequestBody Course updatedCourse){
        Course course = courseRepo.findCourseById(id);

        if(updatedCourse.getName()!=null)
            course.setName(updatedCourse.getName());

        if(updatedCourse.getCreditHours()!=course.getCreditHours())
            course.setCreditHours(updatedCourse.getCreditHours());

        courseRepo.save(course);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

//    delete -> done
    @DeleteMapping("/course/delete/{id}")
    public ResponseEntity<?> deleteCourse (@PathVariable int id){
        courseRepo.deleteById(id);
        return new ResponseEntity<>("Course was deleted successfully", HttpStatus.OK);
    }
}
