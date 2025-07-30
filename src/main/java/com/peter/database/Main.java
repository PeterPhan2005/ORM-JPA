package com.peter.database;

import com.peter.database.entity.Lecturer;
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
        insertLecturers();
        getAllLecturers();
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
        List<Student> students = em.createQuery("Select stu from Student stu", Student.class).getResultList();
        System.out.println("Students list:");
        students.forEach(student -> System.out.println(student));
        em.close();
    }

    public static void insertLecturers() {
        EntityManager em = emf.createEntityManager();
        Lecturer nguyen = new Lecturer("Nguyễn Văn A", 1980, 50000);
        Lecturer tran = new Lecturer("Trần Thị B", 1985, 60000);
        Lecturer le = new Lecturer("Lê Văn C", 1990, 55000);
// Lecturer  - option XML create, hay update deu okay.
// Đi làm thật cấm create trên máy khách hàng vì nếu ta fix bug, update code thì sẽ mất dữ liệu của khách hàng.
        em.getTransaction().begin();
        em.persist(nguyen);
        em.persist(tran);
        em.persist(le);
        em.getTransaction().commit();
        em.close();
    }

    public static void getAllLecturers() {
        EntityManager em = emf.createEntityManager();
        List<Lecturer> lecturers = em.createQuery("Select lec from Lecturer lec", Lecturer.class).getResultList();
        System.out.println("Lecturers list:");
        lecturers.forEach(lecturer -> System.out.println(lecturer));
        em.close();
    }
}