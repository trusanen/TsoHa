<%-- 
    Document   : eventPage
    Created on : 19-Nov-2012, 16:09:07
    Author     : trusanen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="top.jspf" %>
        <h1>${event.name}</h1><br>
        ${event.information}<br>        
        Attendees:<br>
<%@include file="bottom.jspf" %>
