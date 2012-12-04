<%-- 
    Document   : kirjautumissivu
    Created on : 05-Nov-2012, 12:17:46
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Please login</title>
    </head>
    <body>
        <c:if test="${errormsg != null}">
            <p class="error">${errormsg}</p>
        </c:if>
        <form id="loginForm" action="login" method="POST">
            <fieldset>
                <legend>Login</legend>
                <label for="userId">Username:</label>
                <input type="text" name="un" /><br>
                <label for="password">Password:</label>
                <input type="password" name="pw" /><br>
                <input type="submit" value="Kirjaudu" />
            </fieldset>
        </form>
<%@include file="bottom.jspf" %>
