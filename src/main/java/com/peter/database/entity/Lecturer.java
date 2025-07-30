package com.peter.database.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Lecturer") // neu ko co khai bao name thi mac dinh lay ten class la table
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tu generate id tu tang
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Salary", nullable = false)
    private double salary;

    public Lecturer(String name, int yob, double salary) {
        this.name = name;
        this.yob = yob;
        this.salary = salary;
    }
}


