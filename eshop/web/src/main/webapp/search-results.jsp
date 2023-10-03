<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>

<nav class="nav">
    <a class="nav-link" href="/web">Home</a>
    <a class="nav-link active" aria-current="page" href="/web/search.jsp">Search for Product</a>
    <a class="nav-link disabled" aria-disabled="true">Help</a>
</nav>
<div class="container-fluid">
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Product</th>
          <th scope="col">Price</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="result" items="${requestScope.results}">
        <tr>
            <td><a>${result}</a></td>
            <td><a>${result.productName}</a></td>
            <td><a>${result.productPrice}</a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
</div>


<%@include file="footer.jsp"%>