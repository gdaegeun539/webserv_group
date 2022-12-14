<%--
  Created by IntelliJ IDEA.
  User: gdaegeun539
  Date: 2022-11-30
  Time: 오전 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>아고라</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link href="css/postlist.css" rel="stylesheet" />
  </head>
  <body>
    <jsp:include page="navbar.jsp"/>
    <%--  페이지 컨텐츠  --%>
    <div class="container">
      <div class="row d-flex align-items-center justify-content-between my-5 mx-1 px-1 py-1 category-bar">
        <div class="col-md-auto">
          <div class="btn-group">
            <button
                    class="btn btn-outline-secondary btn-lg dropdown-toggle"
                    type="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
            >
              카테고리 제목
            </button>
            <ul class="dropdown-menu">
              <li>카테고리1</li>
              <li>카테고리2</li>
              <li>카테고리3</li>
              <li>카테고리4</li>
              <li>카테고리5</li>
            </ul>
          </div>
        </div>
        <div class="col">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="제목을 입력해 검색" aria-label="search input" aria-describedby="btn-search" id="search-value">
            <button class="btn btn-outline-secondary" type="button" id="btn-search" onclick="onclick_link_innerval('post', 'search', 'pname', 'search-value');">검색</button>
          </div>
        </div>
        <div class="col-md-auto">
          <button type="button" class="btn btn-outline-secondary" onclick="location.href = 'post_register.jsp'">글쓰기</button>
        </div>


      </div>

      <div class="row px-1 py-1 mt-2">
        <div class="col">
          <div class="card mb-4 clickable-div" onclick="onclick_link('post', 'detail', 'pid', 'el로 삽입예정');">
            <div class="card-header d-flex align-items-end">
              <h4 class="px-1" >모집중</h4>
              <h3 class="ms-3 px-1" >모임 제목</h3>
            </div>
            <div class="card-body">
<%--              <p class="me-1 list_detail"><span class="me-3">모집종료날짜</span><span class="ms-5">지역</span></p>--%>
                <p class="me-1 list_detail"><span>지역</span></p>
              <p class="px-5 py-3">본문 나가주세요</p>
              <p class="d-flex justify-content-between list_detail"><span>?/??명</span><span>??년??월??일</span></p>
            </div>
          </div>
        </div>
      </div>

<%--      <div class="row px-1 py-1 mt-2">--%>
<%--        <div class="col">--%>
<%--          <div class="card mb-4">--%>
<%--            <div class="card-header d-flex align-items-end">--%>
<%--              <h4 class="px-1" >모집중</h4>--%>
<%--              <h3 class="ms-3 px-1" >모임 제목</h3>--%>
<%--            </div>--%>
<%--            <div class="card-body">--%>
<%--&lt;%&ndash;              <p class="me-1 list_detail"><span class="me-3">모집종료날짜</span><span class="ms-5">지역</span></p>&ndash;%&gt;--%>
<%--                <p class="me-1 list_detail"><span>지역</span></p>--%>
<%--              <p class="px-5 py-3">본문 나가주세요</p>--%>
<%--              <p class="d-flex justify-content-between list_detail"><span>?/??명</span><span>??년??월??일</span></p>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>

      <%-- Pagination --%>
      <nav aria-label="Pagination">
        <hr class="my-0" />
        <ul class="pagination justify-content-center my-4">
          <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">&lt;&lt;</a></li>
          <li class="page-item active" aria-current="page"><a class="page-link" href="#!">1</a></li>
          <li class="page-item"><a class="page-link" href="#!">2</a></li>
          <li class="page-item"><a class="page-link" href="#!">3</a></li>
          <li class="page-item disabled"><a class="page-link" href="#!">번호 동적 생성</a></li>
          <li class="page-item"><a class="page-link" href="#!">15</a></li>
          <li class="page-item"><a class="page-link" href="#!">&gt;&gt;</a></li>
        </ul>
      </nav>

    </div>

    <jsp:include page="footer.jsp"/>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/postlist.js?ver=1"></script>
  </body>
</html>
