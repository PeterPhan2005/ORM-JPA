package com.peter.database;

import com.peter.database.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.peter.database-PU");

    public static void main(String[] args) {
        insertStudents();
        getAllStudents();
        emf.close();
    }

    public static void insertStudents() {
        EntityManager em = emf.createEntityManager();
        Student an = new Student("SE1", "An Nguyễn", 2004, 8.6);
        Student binh = new Student("SE2", "Bình Lê", 2004, 8.7);
        Student cuong = new Student("SE3", "Cường Võ", 2004, 8.6);

        em.getTransaction().begin();
        em.persist(an);
        em.persist(binh);
        em.persist(cuong);
        em.getTransaction().commit();
        em.close();
    }

    public static void getAllStudents() {
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("From Student", Student.class).getResultList();
        System.out.println("Students list:");
        students.forEach(student -> System.out.println(student));
        em.close();
    }
}