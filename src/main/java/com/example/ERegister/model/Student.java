package com.example.ERegister.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {


    @GeneratedValue
    @Id
    private int id ;

    private String firstName ;
    private String lastName ;

    private LocalDate creationDate ;


    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Major major ;


    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses ;


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate=LocalDate.now();
    }

    public Student() {
        this.creationDate=LocalDate.now();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creationDate=" + creationDate +
                ", major=" + major +
                ", courses=" + courses +
                '}';
    }
}
