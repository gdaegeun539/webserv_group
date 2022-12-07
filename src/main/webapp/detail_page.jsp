<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Title</title>
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="css/detail_page.css">
</head>
<body>
 <jsp:include page="navbar.jsp"/>
  <div class="card writeDetailBox wrap">
    <div class="wrap">
      <p style="font-size: 40px">제목</p>
    </div>
    <div class="card writeContentBox wrap">
      <p style="font-size: 32px">내용</p>
    </div>
  </div>
  <div class="card writeDateBox">
    <div class="row" style="margin-top: auto">
      <h3>수정 날짜: </h3>
      <h3>마감 날짜: </h3>
    </div>
  </div>

  <div class="right">
    <button type="button" class="btn">수정</button>
    <button type="button" class="btn">삭제</button>
    <button type="button" class="btn">종료</button>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>