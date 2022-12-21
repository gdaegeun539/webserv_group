<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>구인글 상세 페이지</title>
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="css/detail_page.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="row px-1 py-1 mt-2">
  <div class="col">
    <div class="card mb-4">
      <div class="card-header d-flex align-items-end">
        <h4 class="px-1" >모집중</h4>
        <h3 class="ms-3 px-1" >${post.title}</h3>
      </div>
      <div class="card-body">
        <p class="me-1 list_detail"><span class="ms-5">${post.location}</span></p>
        <p class="px-5 py-3">${post.content}</p>
        <p class="d-flex justify-content-between align-self-end list_detail"><span>${post.people.size()}/${post.capacity}명</span><span>${post.updated_at}</span></p>
      </div>
    </div>
  </div>
</div>

<div class="d-flex justify-content-end">
  <form style="float:right;" action="<c:url value="/post?action=editbtn&pid=${post.pid}"/>">
    <%--   수정 후 제목, 내용,    --%>
    <button class="btn" style="font-size: 18px" >수정</button>
  </form>
  <form style="float:right;" action="<c:url value="/post?action=delete"/>">
    <%--   삭제 후 목록 페이지   --%>
    <button class="btn" style="font-size: 18px">삭제</button>
  </form>
  <form style="float:right;" action="<c:url value="/post?action=close"/>">
    <%--   종료 시 모집 중 -> 모집 종료 표시   --%>
    <button class="btn" style="font-size: 18px">종료</button>
  </form>
</div>

<jsp:include page="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>