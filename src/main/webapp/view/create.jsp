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
<form action="/create" method="POST" >
    <SELECT name="operationMediator" id="operationMediator" onchange="this.form.submit();">
        <option value="null">Select option please</option>
        <option value="anime">Anime</option>
        <option value="studio">Studio</option>
    </SELECT>
</form>

<jsp:include page="forms/${formView}"/>

</body>
