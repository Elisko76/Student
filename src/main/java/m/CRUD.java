package m;

import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import m.s.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUD implements CRUDImpl{



    @Override
    public List<Student> get() {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory1();
        Session session = sessionFactory.openSession();
        String qryString = "from Student";
        Query qry = session.createQuery(qryString);
        List list = qry.list();
        Iterator it = list.iterator();
        List<Student> stud = new ArrayList<>();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            stud.add(student);
        }
        return stud;
    }

    @Override
    public Student get(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory1();
        Session session = sessionFactory.openSession();
        String get = "from Student s  where s.studentId=:sId";
        Query getS= session.createQuery(get);
        getS.setParameter("sId", id);
         Student student=null;
        List listS = getS.list();

        Iterator it = listS.iterator();
        List<Student> stud = new ArrayList<>();
        while (it.hasNext()) {
            student = (Student) it.next();
        }
        session.close();
        return student;
    }

    @Override
    public boolean save(Student s) {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory1();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setStudentName(s.getStudentName());
        student.setStudentLastName(s.getStudentLastName());
        student.setAddress(s.getAddress());
        student.setCourse(s.getCourse());
        student.setSpecialty(s.getSpecialty());
        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory1();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String qryString = "delete from Student s where s.studentId="+id;
        Query query = session.createQuery(qryString);
        query.executeUpdate();
        transaction.commit();
        session.flush();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory1();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String get = "update Student s set s.studentName=:studentName, s.studentLastName=:studentLastName, s.specialty=:specialty, s.course=:course, s.address=:address where s.studentId=:sId";;
        Query getS= session.createQuery(get);
        getS.setParameter("sId", student.getStudentId());
        getS.setParameter("studentName", student.getStudentName());
        getS.setParameter("studentLastName", student.getStudentLastName());
        getS.setParameter("address", student.getAddress());
        getS.setParameter("specialty", student.getSpecialty());
        getS.setParameter("course", student.getCourse());
        getS.executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }



}
