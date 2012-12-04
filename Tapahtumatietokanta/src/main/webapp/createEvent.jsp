<%-- 
    Document   : createEvent
    Created on : 04-Dec-2012, 12:26:39
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="top.jspf" %>
        <h1>Create a new event</h1>
        <c:if test="${errormsg != null}">
            <p class="virhe">${errormsg}</p>
        </c:if>
        <form id="createForm" action="create" method="POST">
            <fieldset>
                <legend>Please give a name and some information about the event</legend>
                <label for="name">Event name:</label>
                <input type="text" name="name" /><br>
                <label for="information">Event information:</label>
                <input type="text" name="information" /><br>
                <input type="submit" value="Create" />
            </fieldset>
        </form>
<%@include file="bottom.jspf" %>
