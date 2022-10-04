package com.example.ERegister.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Major {

    @Id
    @GeneratedValue
    private int id ;

    @Column(unique = true)
    private String code;
    private String name ;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "major")
    List<Student> students ;

    @Override
    public String toString() {
        return "Major{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
