<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
       <title>Добавление студента</title>
</head>

<body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<%
        String email=(String)session.getAttribute("email");

        if (email==null) {

                response.sendRedirect("log.jsp");
        }
%>
<br/><br/>
        <div class = "container" style="width: 450px">
        <div class="text-center ">
                <h1 >Студент</h1>
        </div>

        <hr/>
        <div class="card-body">
        <form action = "${pageContext.request.contextPath}/MainServlet" method="POST">
                <div class = "form-group">
                        <input type="text" name="studentName" class = "form-control" placeholder = "Введите имя" value = "${student.studentName}"/>
                </div>
                <div class = "form-group">
                        <input type="text" name="studentLastName" class = "form-control" placeholder = "Введите фамилию"  value = "${student.studentLastName}"/>
                </div>
                <div class = "form-group">
                        <input type="text" name="specialty" class = "form-control" placeholder = "Введите специальность" value = "${student.specialty}" />
                </div>
                <div class = "form-group">
                        <input type="number" name="course" class = "form-control" placeholder = "Введите курс" value = "${student.course}"/>
                </div>
                <div class = "form-group">
                <input type="text" name="address"  class = "form-control"placeholder = "Введите адрес" value = "${student.address}"/>
                </div>
                <input type = "hidden" name = "id" value = "${student.studentId}"/>
                <div class="text-center">
                <button type = "submit" class = "btn btn-primary">Сохранить</button>
                </div>
        </form>
        </div>
                <div class="text-center">
                <p>${message}</p>
                </div>
         </div>
</body>
</html>
