<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>

<h1><c:out value="${product.productName}"/></h1>

<img src="/web/product/image/${product.id}" alt="no image"/>

<h2><c:out value="${product.productPrice}"/></h2>

<%@include file="footer.jsp"%>
