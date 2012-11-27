<%-- 
    Document   : events
    Created on : 27-Nov-2012, 17:38:52
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="top.jspf" %>
        <h1>All Events:</h1>
        <c:choose>
            <c:when test="${empty events}">
                <br>There are no events at the moment.<br><br>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="event" items="${events}">
                        <li><a href="eventPage?event=${event.id}">${event.name}</a></li>
                    </c:forEach>
                </ul><br>
            </c:otherwise>
        </c:choose><br>
<%@include file="bottom.jspf" %>
