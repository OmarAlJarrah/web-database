<%--
  Created by IntelliJ IDEA.
  User: omar
  Date: 8/14/21
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <title>Login Page</title>
</head>
<a href="http://localhost:8080/create"> Create </a>
<body>
<p><font color="red">${errorMessage}</font></p>
<form action="/login" method="post">
    <p>
        <label>
            <SELECT name="userType">
                <OPTION Value="user">User</OPTION>
                <OPTION Value="admin">Admin</OPTION>
            </SELECT>
        </label>
    </p>

    ID :
    <label>
        <input name="id" type="text" />
    </label>
    Password :
    <label>
        <input name="password" type="password" />
    </label>
    <input value="Login" type="submit" />

</form>

</body>
