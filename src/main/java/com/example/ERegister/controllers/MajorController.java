package com.example.ERegister.controllers;

import com.example.ERegister.model.Major;
import com.example.ERegister.model.Student;
import com.example.ERegister.repository.MajorRepo;
import com.example.ERegister.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MajorController {

    @Autowired
    MajorRepo majorRepo ;
    @Autowired
    StudentRepo studentRepo;
//    Major CRUD operations
//    create -> done
    @PostMapping("/major/create")
    public ResponseEntity<?> createMajor (@RequestBody Major newMajor ){
        majorRepo.save(newMajor);
        return new ResponseEntity<>(newMajor.toString(), HttpStatus.OK);
    }
//    read -> done
    @GetMapping("/major/{id}")
    public ResponseEntity<?> readMajor (@PathVariable int id)
    {
        Major major = majorRepo.findMajorById(id);
        return new ResponseEntity<>(major.toString(),HttpStatus.OK );
    }
//    update -> done
    @PostMapping("/major/update/{id}")
    public ResponseEntity<?> updateMajor (@PathVariable int id ,@RequestBody Major updatedMajor){
        Major major=majorRepo.findMajorById(id);
        if(updatedMajor.getName()!=null)
            major.setName(updatedMajor.getName());

        if(updatedMajor.getCode()!=null)
            major.setCode(updatedMajor.getCode());

        majorRepo.save(major);
        return new ResponseEntity<>(major.toString(),HttpStatus.OK);
    }

//    delete -> done
    @DeleteMapping("/major/delete/{id}")
    public ResponseEntity<?> deleteMajor (@PathVariable int id){
        majorRepo.deleteById(id);
        return new ResponseEntity<>("Major deleted successfully",HttpStatus.OK);
    }

//    Get Major by Code -> done
    @GetMapping("/major/code/{code}")
    public ResponseEntity<?> getMajorByCode (@PathVariable String code)
    {
        Major major = majorRepo.findMajorByCode(code);
        return new ResponseEntity<>(major.toString(),HttpStatus.OK );
    }
//    Get Major By Student -> done
    @GetMapping("/major/student/{sId}")
    public ResponseEntity<?> getMajorByStudentId (@PathVariable int sId)
    {
        Student student = studentRepo.getStudentById(sId);
        Major major = majorRepo.findMajorByStudents(student);
        return new ResponseEntity<>(major.toString(),HttpStatus.OK );
    }
}

