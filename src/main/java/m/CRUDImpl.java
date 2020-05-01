package m;

import m.s.Student;

import java.util.List;

public interface CRUDImpl {
    List<Student> get();

    Student get(int id);

    boolean save(Student student);

    boolean delete(int id);

    boolean update(Student student);
}
