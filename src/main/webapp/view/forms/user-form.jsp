<form method="post" action="/admin">
    <p>ID: <input type="number" name="id" value="0"></p>
    <p>Location<input type="text" name="password" value=""></p>
    <SELECT>
        <p>
            <label>
                <SELECT name="userType">
                    <OPTION Value="user">User</OPTION>
                    <OPTION Value="admin">Admin</OPTION>
                </SELECT>
            </label>
        </p>
    </SELECT>
    <input type="submit" value="create">
</form>
