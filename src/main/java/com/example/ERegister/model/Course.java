package com.example.ERegister.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id ;
    private int creditHours;
    private String name ;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(mappedBy = "courses")
    List<Student> students ;

    @Override
    public String toString() {
        return "Course{" +
                "creditHours=" + creditHours +
                ", name='" + name + '\'' +
                '}';
    }
}
