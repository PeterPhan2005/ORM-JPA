package com.peter.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Student") // neu ko co khai bao name thi mac dinh lay ten class la table
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)") // neu ko co khai bao nay thi mac dinh lay ten field lam ten cot
    private String id; //camelCase (id tu nhap, id tu tang tinh sau)

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    // Khai báo để gõ tiếng Việt có dấu, nvarchar, neu ko tieng Viet se ra dấu ?
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    //Bat buoc phai co constructor rong, constructor full tham so
    // boiler plate - lombok
    // them dependency lombok sau
}
