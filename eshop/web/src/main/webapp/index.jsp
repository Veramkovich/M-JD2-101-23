<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<h1>A random number generator</h1>
<%! final String key_value_separator = ": "; %>
<%
String key = "Random number";
key = key + key_value_separator + Math.random();
%>
<%=key %>
<c:out value="Hello JSTL"/>
<%@include file="footer.jsp"%>


