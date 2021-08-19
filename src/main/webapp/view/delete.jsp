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
<body>
<p><font color="red">${errorMessage}</font></p>
<form action="/delete" method="post">
    <p>
        <label>
            <SELECT name="record_type">
                <OPTION Value="anime">Anime</OPTION>
                <OPTION Value="studio">Studio</OPTION>
            </SELECT>
        </label>
    </p>
    <label>
        <input type="text" name="id">
    </label>

    <input type="submit" value="delete">

</form>

</body>
