<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<p><font color="red">${errorMessage}</font></p>
<form action="/read" method="post">
    <p>
        <label>
            <SELECT name="type">
                <OPTION Value="anime">Anime</OPTION>
                <OPTION Value="studio">Studio</OPTION>
            </SELECT>
        </label>
    </p>
    <input type="number" name="id" value="0">
    <input value="read" type="submit" />
</form>
<form action="/readAll" method="post">
    <label>
        <SELECT name="type">
            <OPTION Value="anime">Anime</OPTION>
            <OPTION Value="studio">Studio</OPTION>
        </SELECT>
    </label>
    <input value="readAll" type="submit" />
</form>
<ul>
    <c:forEach items="${anime}" var="anime">
            <div style="display: flex; justify-content: space-evenly;">
                <h1>ID : ${anime.getId()}</h1>
                <h2>Studio ID : ${anime.getCreatorId()}</h2>
                <h3>Name : ${anime.getName()}</h3>
                <h4>Year : ${anime.getYearOfProduction()}</h4>
                <h5>Rating : ${anime.getRating()}</h5>
                <h6>Watch Count : ${anime.getWatchCount()}</h6>
            </div>
    </c:forEach>
    <c:forEach items="${studio}" var="studio">
        <div style="display: flex; justify-content: space-evenly;">
            <h1>ID : ${studio.getId()}</h1>
            <h2>Name : ${studio.getName()}</h2>
            <h3>Location : ${studio.getLocation()}</h3>
            <h4>Start Year : ${studio.getStartYear()}</h4>
        </div>
    </c:forEach>
</ul>
