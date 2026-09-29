package com.school.Teacher;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_id")
    private Long teacherId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "subject")
    private String subject;

    @Transient
    public String getFirstName(){
        if(name == null || name.trim().isEmpty()) return "";
        return name.split(" ", 2)[0];
    }

    @Transient
    public String getLastName(){
        if(name == null || name.trim().isEmpty()) return "";
        String[] parts = name.split(" ", 2);
        return parts.length > 1 ? parts[1] : "";
    }

}
