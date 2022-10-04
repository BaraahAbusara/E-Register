package com.example.ERegister.repository;

import com.example.ERegister.model.Major;
import com.example.ERegister.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> getAllStudentsByMajor(Major major);
    Student getStudentById (int id);

    @Query(value = "select * from student where creation_date between :start and :end" ,
            nativeQuery = true)
    List<Student> getAllStudentsByCreationDate (
            @Param("start") LocalDate start ,
            @Param("end") LocalDate End);


}
