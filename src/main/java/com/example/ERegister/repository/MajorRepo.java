package com.example.ERegister.repository;

import com.example.ERegister.model.Major;
import com.example.ERegister.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepo extends JpaRepository<Major,Integer> {

    Major findMajorById (int id);

    Major findMajorByCode (String code);

    Major findMajorByStudents (Student student);
}
