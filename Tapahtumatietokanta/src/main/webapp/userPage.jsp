<%-- 
    Document   : userPage
    Created on : 13-Nov-2012, 17:30:45
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="top.jspf" %>
        <h1>Hello ${user.name}!</h1>
        Your user id is ${user.id}!<br>
        <a href="create">Create a new event</a><br>
        Events created by you:<br>
        <c:choose>
            <c:when test="${empty user.createdEvents}">
                <br>You haven't created any events!<br><br>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="event" items="${user.createdEvents}">
                        <li><a href="eventPage?event=${event.id}">${event.name}</a></li>
                    </c:forEach>
                </ul><br>
            </c:otherwise>
        </c:choose>
                
        Events you are attending:
        
        <c:choose>
            <c:when test="${empty user.attendedEvents}">
                <br>You aren't attending any events!<br><br>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="event" items="${user.attendedEvents}">
                        <li><a href="eventPage?event=${event.id}">${event.name}</a></li>
                    </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>

        <%@include file="bottom.jspf" %>