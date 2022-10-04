package com.example.ERegister.controllers;

import com.example.ERegister.model.Course;
import com.example.ERegister.model.Major;
import com.example.ERegister.model.Student;
import com.example.ERegister.repository.CourseRepo;
import com.example.ERegister.repository.MajorRepo;
import com.example.ERegister.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentRepo studentRepo ;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    MajorRepo majorRepo;

//    for testing
    @GetMapping("/")
    public String index (){
       return "index" ;
    }
//    Student CRUD operations
//    Create -> done
    @PostMapping("/student/create")
    public ResponseEntity<?>  createStudent (@RequestBody  Student newStudent){
        studentRepo.save(newStudent);
        return new ResponseEntity<>(newStudent.toString(),HttpStatus.OK);
    }

//    Read -> done
    @GetMapping("/student/{id}")
    public ResponseEntity<?> viewStudentDetails (@PathVariable int id ){
        Student student = studentRepo.getStudentById(id);
        return new ResponseEntity<>(student.toString() , HttpStatus.OK);
    }

//    Update -> done
    @PostMapping("student/update/{id}")
    public ResponseEntity<?>  updateStudent (@PathVariable int id, @RequestBody Student updatedStudent){
        Student student = studentRepo.getStudentById(id);
        if(updatedStudent.getFirstName()!=null)
            student.setFirstName(updatedStudent.getFirstName());

        if(updatedStudent.getLastName()!=null)
            student.setLastName(updatedStudent.getLastName());

        if(updatedStudent.getMajor()!=null)
            student.setMajor(updatedStudent.getMajor());

        if(updatedStudent.getCourses()!=null)
            student.setCourses(updatedStudent.getCourses());

        studentRepo.save(student);

        return new ResponseEntity<>(student.toString() , HttpStatus.OK);
    }

//    Delete -> done
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<?> deleteStudent (@PathVariable int id ){
        studentRepo.deleteById(id);
        return new ResponseEntity<>("Student has been deleted" , HttpStatus.OK);
    }


//    Get Students by creation date (from , to) -> done
    @GetMapping("student/date/{from}/{to}")
    public ResponseEntity<?> viewStudentsByMajor (@PathVariable String from , @PathVariable String to){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Student> students = studentRepo.getAllStudentsByCreationDate(LocalDate.parse(from, formatter),LocalDate.parse(to, formatter));
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

//    Get Students by major -> done
    @GetMapping("student/major/{mId}")
    public ResponseEntity<?> viewStudentsByMajor (@PathVariable int mId){
        Major major = majorRepo.findMajorById(mId);
        List<Student> students = studentRepo.getAllStudentsByMajor(major);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
//    Add Course to Student -> done
    @PostMapping("student/{sId}/addCourse/{cId}")
    public ResponseEntity<?>  addCourseToStudent (@PathVariable int sId,@PathVariable int cId){
        Student student = studentRepo.getStudentById(sId);
        Course course = courseRepo.findCourseById(cId);
        List<Course> studentCourses = student.getCourses();
        studentCourses.add(course);
        student.setCourses(studentCourses);

        studentRepo.save(student);

        return new ResponseEntity<>(student.getCourses().toString() , HttpStatus.OK);
    }
//    Remove Course from Student -> done
    @DeleteMapping("student/{sId}/removeCourse/{cId}")
    public ResponseEntity<?>  removeCourseFromStudent (@PathVariable int sId,@PathVariable int cId){
        Student student = studentRepo.getStudentById(sId);
        Course course = courseRepo.findCourseById(cId);
        List<Course> studentCourses = student.getCourses();
        studentCourses.remove(course);
        student.setCourses(studentCourses);

        studentRepo.save(student);

        return new ResponseEntity<>(student.getCourses().toString() , HttpStatus.OK);
    }

//    add major to student -> done
    @PostMapping("student/{sId}/addMajor/{mId}")
    public ResponseEntity<?>  addMajorToStudent (@PathVariable int sId,@PathVariable int mId){
        Student student = studentRepo.getStudentById(sId);
        Major major = majorRepo.findMajorById(mId);
        student.setMajor(major);

        studentRepo.save(student);

        return new ResponseEntity<>(student.toString() , HttpStatus.OK);
    }

}
