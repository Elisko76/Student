<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
<head>
    <br/><br/>
    <title>Студенты</title>

</head>
<body>

        <h1 class="jumbotron-heading text-center">Студенты</h1>

<%
    String email=(String)session.getAttribute("email");

    if (email==null) {

        response.sendRedirect("log.jsp");
    }
%>
<div class = "container">
     <div class="float-right">
        <a href="${pageContext.request.contextPath}/logout.jsp">Выйти</a>
    </div>
    <p>
        <button class = "btn btn-primary" onclick="window.location.href = 'jsp/add.jsp'">Добавить студента</button>
    </p>
<Table id="datatable" class = "table table-striped table-bordered">
    <thead>
        <tr >
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Специальность</th>
            <th>Курс</th>
            <th>Адрес</th>
            <th>Изменение</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="student" items="${stud}">
        <tr>
            <td>${student.studentName}</td>
            <td>${student.studentLastName}</td>
            <td>${student.specialty}</td>
            <td>${student.course}</td>
            <td>${student.address}</td>
            <td>
            <a href = "${pageContext.request.contextPath}/MainServlet?action=EDIT&id=${student.studentId}">Изменить</a>
                |
                <a href = "${pageContext.request.contextPath}/MainServlet?action=DELETE&id=${student.studentId}">Удалить</a>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</Table>
</div>

<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>

<script>


    $(document).ready(function(){
    $('#datatable').DataTable( {
        language: {
            search: "Поиск:",
            previous: "Предыдущая",
            next: "Следующая",
            lengthMenu: "Показать _MENU_ записей",
            infoEmpty: "Студенты с 0 до 0 из 0 студентов",
            info: "Студенты с _START_ до _END_ из _TOTAL_ студентов",
            zeroRecords: "Записи отсутствуют.",
            emptyTable: "В таблице отсутствуют данные",
            infoFiltered: "(отфильтровано из _MAX_ записей)",
            paginate: {
                first: "Первая",
                previous: "Предыдущая",
                next: "Следующая",
                last: "Последняя"
            },
            select: {
            rows: {
                _: "Выбрано записей: %d",
                0: "Кликните по записи для выбора",
                1: "Выбрана одна запись"
            }
        }
        }
    } );
    })
</script>
</body>
</html>

