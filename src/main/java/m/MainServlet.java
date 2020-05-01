package m;

import m.s.Student;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {

    CRUDImpl crud=null;
    RequestDispatcher dispatcher = null;

    public MainServlet(){
        crud=new CRUD();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            action = "LIST";
        }

        switch(action) {

            case "LIST":
                listStudent(request, response);
                break;

            case "EDIT":
                getStudentEdit(request, response);
                break;

            case "DELETE":
                deleteStudent(request, response);
                break;

            default:
                listStudent(request, response);
                break;

        }

    }
    private void getStudentEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");
        Student student = crud.get(Integer.parseInt(id));
        request.setAttribute("student", student);
        dispatcher = request.getRequestDispatcher("/jsp/add.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteStudent (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");
        crud.delete(Integer.parseInt(id));
        listStudent(request, response);
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> stud=crud.get();
        request.setAttribute("stud", stud);
        dispatcher=request.getRequestDispatcher("/jsp/page.jsp");
        dispatcher.forward(request,response);
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Student s= new Student();
        String studentName,studentLastName,address,specialty,course;
        studentName=request.getParameter("studentName");
        studentLastName=request.getParameter("studentLastName");
        address=request.getParameter("address");
        specialty=request.getParameter("specialty");
        course=request.getParameter("course");
        if (studentName.isEmpty() || studentName == null||studentLastName.isEmpty() || studentLastName == null||address.isEmpty() || address == null
                ||specialty.isEmpty() || specialty == null||course.isEmpty() || course == null){
            request.setAttribute("message", "Заполните все поля!");
            dispatcher=request.getRequestDispatcher("/jsp/add.jsp");
            dispatcher.forward(request,response);
        }
        else {
            s.setStudentName(request.getParameter("studentName"));
            s.setStudentLastName(request.getParameter("studentLastName"));
            s.setAddress(request.getParameter("address"));
            s.setSpecialty(request.getParameter("specialty"));
            s.setCourse(Integer.parseInt(request.getParameter("course")));
            if (id.isEmpty() || id == null) {
                crud.save(s);
            } else {
                s.setStudentId(Integer.parseInt(id));
                crud.update(s);
            }

            listStudent(request, response);
        }
    }

}