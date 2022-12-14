<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: gdaegeun539
Date: 2022-11-30
Time: 오전 10:00
To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 폰트 적용 css--%>
<link rel="stylesheet" href="css/navbar.css" />

<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
  <div class="container">
    <a class="navbar-brand" href="<c:url value="/"/>">아고라</a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown">
          <a
                  class="nav-link dropdown-toggle"
                  id="navbarDropdown"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
          >카테고리</a>
          <ul
                  class="dropdown-menu dropdown-menu-end"
                  aria-labelledby="navbarDropdown"
          >
            <li><a class="dropdown-item" href="#">카테고리1</a></li>
            <li><a class="dropdown-item" href="#">카테고리2</a></li>
<%--            <li><hr class="dropdown-divider" /></li>--%>
            <li><a class="dropdown-item" href="#">카테고리3</a></li>
            <li><a class="dropdown-item" href="#">카테고리4</a></li>
            <li><a class="dropdown-item" href="#">카테고리5</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<c:url value="/login.jsp"/>">로그인</a>
        </li>
        <li class="nav-item"><a class="nav-link" href="">마이페이지</a></li>
      </ul>
    </div>
  </div>
</nav>
