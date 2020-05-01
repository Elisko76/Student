package m.s;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="studentId")
    private int studentId;

    @Column(name="studentName", length=50)
    private String studentName;

    @Column(name="studentLastName", length=50)
    private String studentLastName;

    @Column(name="specialty", length=50)
    private String specialty;

    @Column(name="course")
    private Integer course;

    @Column(name="address", length=50)
    private String address;

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }

    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


}
