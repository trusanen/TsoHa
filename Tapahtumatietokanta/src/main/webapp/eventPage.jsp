<%-- 
    Document   : eventPage
    Created on : 19-Nov-2012, 16:09:07
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="top.jspf" %>
        <h1>${event.name}</h1>
        Event created by ${event.creator}<br>
        Event information:<br>
        ${event.information}<br>
        Attendees:<br>
        <c:choose>
            <c:when test="${empty event.attendees}">
                <br>There are no attendees for this event!<br><br>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="user" items="${event.attendees}">
                        <li>${user.name}</li>
                    </c:forEach>
                </ul><br>
            </c:otherwise>
        </c:choose><br>
        Comments:<br>
        <c:choose>
            <c:when test="${empty event.comments}">
                <br>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="comment" items="${event.comments}">
                        <li>${comment.date}, ${comment.commentator}: ${comment.text}</li>
                    </c:forEach>
                </ul><br>
            </c:otherwise>
        </c:choose>
<%@include file="bottom.jspf" %>
