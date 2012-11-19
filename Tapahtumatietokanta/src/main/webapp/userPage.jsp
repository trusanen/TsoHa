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
        Events created by you:<br>
        <c:choose>
            <c:when test="${empty user.createdEvents}">
                You haven't created any events!
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="event" items="${user.createdEvents}">
                        <li>${event.name}</li>
                    </c:forEach>
                </ul><br>
            </c:otherwise>
        </c:choose>
                
        Events you are attending:
        
        <c:choose>
            <c:when test="${empty user.attendedEvents}">
                You aren't attending any events!
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="event" items="${user.attendedEvents}">
                        <li>${event.name}</li>
                    </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>

        <%@include file="bottom.jspf" %>