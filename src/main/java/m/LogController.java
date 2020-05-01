package m;

import m.s.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogController extends HttpServlet {

    RequestDispatcher dispatcher = null;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory1();
        Session session = sessionFactory.openSession();
        HttpSession session1 = request.getSession();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        Query query = session.createQuery("from Users u  where u.login=:login and u.password=:password");
        query.setParameter("login", email);
        query.setParameter("password", password);
        List listS = query.list();
        Iterator it = listS.iterator();
        if (it.hasNext()) {
            session1.setAttribute("email",email);
            session.close();
            response.sendRedirect("MainServlet?action=LIST");
        }
        else {

            dispatcher=request.getRequestDispatcher("/log.jsp");
            dispatcher.forward(request,response);}



    }

}
