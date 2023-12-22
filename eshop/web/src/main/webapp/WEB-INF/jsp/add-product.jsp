<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>

<form method="post" action="/web/add" enctype="multipart/form-data">
<div class="mb-3">
    <label for="photo" class="form-label">Photo</label>
    <input type="file" name="photo" class="form-control" id="photo">
</div>
<div class="mb-3">
    <label for="productName" class="form-label">Product Name</label>
    <input type="text" name="productName" class="form-control" id="productName" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter product name</div>
</div>
<div class="mb-3">
    <label for="productPrice" class="form-label">Product Price</label>
    <input type="text" name="productPrice" class="form-control" id="productPrice" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter product price in USD</div>
</div>
<button class="btn btn-primary" type="submit">Add</button>
</form>

<%@include file="footer.jsp"%>