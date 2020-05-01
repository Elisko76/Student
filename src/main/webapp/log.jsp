<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>
<br/><br/><br/>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("email",null);
%>
<div class="container" style="width: 400px">
    <form action="login" method="post">
        <div class="card">
            <div class="card-header text-center ">
                Вход
            </div>
            <div class="card-body">

                <div class="form-group">
                    <input type="text" name="email" required class="form-control" placeholder="Введите email"/>
                </div>
                <div class="form-group">
                    <input type="password" name="password" required class="form-control" placeholder="Введите пароль"/>
                </div>

            </div>
            <div class="card-footer text-center style="width: 100px">
                <input type="submit" value="Войти" class="btn btn-primary"/>
            </div>
        </div>
    </form>

</div>
</body>
</html>