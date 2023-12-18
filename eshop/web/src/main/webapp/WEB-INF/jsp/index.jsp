<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>

<h1>A random number generator</h1>
<%! final String key_value_separator = ": "; %>
<%
String key = "Random number";
key = key + key_value_separator + Math.random();
%>
<%=key %>
<c:out value="Hello JSTL"/>

<%@include file="footer.jsp"%>


