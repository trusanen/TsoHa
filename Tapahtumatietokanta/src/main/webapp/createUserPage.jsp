<%-- 
    Document   : createUser
    Created on : 20-Dec-2012, 13:00:25
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create a user</title>
    </head>
    <body>
        <c:if test="${errormsg != null}">
            <p class="error">${errormsg}</p>
        </c:if>
        <form id="loginForm" action="createUser" method="POST">
            <fieldset>
                <legend>Please give all the required information</legend>
                <label for="name">Name:</label>
                <input type="text" name="n" /><br>
                <label for="username">Username:</label>
                <input type="text" name="un" /><br>
                <label for="password">Password:</label>
                <input type="password" name="pw" /><br>
                <input type="submit" value="Submit" />
            </fieldset>
        </form>
<%@include file="bottom.jspf" %>
