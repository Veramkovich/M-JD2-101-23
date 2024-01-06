<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
<nav class="nav">
    <a class="nav-link" href="/web">Home</a>
    <a class="nav-link active" aria-current="page" href="/web/search">Search for Product</a>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a class="nav-link active" aria-current="page" href="/web/add">Add a New Product</a>
</sec:authorize>
    <a class="nav-link disabled" aria-disabled="true">Help</a>
<sec:authorize access="isAuthenticated()">
    <a class="nav-link" href="/web/logout">Logout</a>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <a class="nav-link" href="/web/login">Login</a>
</sec:authorize>
</nav>
