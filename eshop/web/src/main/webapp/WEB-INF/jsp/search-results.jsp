<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>

<div class="container-fluid">
    <c:choose>
    <c:when test="${requestScope.results.size() > 0}">
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Product</th>
          <th scope="col">Price</th>
          <th scope="col">&nbsp;</th>
        </tr>
      </thead>
      <tbody>
        <c:set value="0" var="count" scope="page"/>
        <c:forEach var="result" items="${requestScope.results}">
        <tr>
            <c:set value="${pageScope.count + 1}" var="count" scope="page"/>
            <td><a><c:out value="${count}"/></a></td>
            <td><a>${result.productName}</a></td>
            <td><a>${result.productPrice}</a></td>
            <td><a class="btn btn-primary" href="/web/product/${result.id}" role="button">View</a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    </c:when>
    <c:otherwise>
        <a>Products not found</a>
    </c:otherwise>
    </c:choose>
</div>

<%@include file="footer.jsp"%>