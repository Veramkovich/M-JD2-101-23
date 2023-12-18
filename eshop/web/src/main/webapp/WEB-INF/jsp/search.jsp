<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>

<div class="container-fluid">
    <form class="d-flex" role="search" method="post" action="/web/search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search-str"/>
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>


<%@include file="footer.jsp"%>