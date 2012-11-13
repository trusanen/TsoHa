<%-- 
    Document   : kirjautumissivu
    Created on : 05-Nov-2012, 12:17:46
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Kirjaudu sisään...</title>
    </head>
    <body>
        <c:if test="${errormsg != null}">
            <p class="virhe">${errormsg}</p>
        </c:if>
        <form id="loginForm" action="login" method="POST">
            <fieldset>
                <legend>Kirjaudu sisään</legend>
                <label for="userId">Käyttäjätunnus:</label>
                <input type="text" name="un" /><br>
                <label for="password">Salasana:</label>
                <input type="password" name="pw" /><br>
                <input type="submit" value="Kirjaudu" />
            </fieldset>
        </form>
<%@include file="bottom.jspf" %>
