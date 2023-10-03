<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>

<nav class="nav">
    <a class="nav-link active" aria-current="page" href="/web">Home</a>
    <a class="nav-link" href="/web/search.jsp">Search for Product</a>
    <a class="nav-link disabled" aria-disabled="true">Help</a>
</nav>

<h1>A random number generator</h1>
<%! final String key_value_separator = ": "; %>
<%
String key = "Random number";
key = key + key_value_separator + Math.random();
%>
<%=key %>
<c:out value="Hello JSTL"/>

<%@include file="footer.jsp"%>


