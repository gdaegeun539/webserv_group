<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>내 정보 페이지</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="css/mypage.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>
  <div class="wrap" style="margin: 10px">
    <h1>내 정보</h1>
  </div>

  <div class="card myPageBox">
    <ul>
      <li><p style="font-size: 40px">이름: </p></li>
      <li><p style="font-size: 40px">이메일: </p></li>
      <li><p style="font-size: 40px">아이디: </p></li>
      <li>
        <p style="font-size: 40px">관심사:
          <div class="right">
            <button type="button" class="btn">수정</button>
          </div>
        </p>
      </li>
    </ul>
  </div>

  <div class="card writeBox">
    <div class="wrap">
      <p style="font-size: 32px">제목</p><hr>
    </div>
    <div class="wrap">
      <p style="font-size: 24px">간단한 내용</p>
    </div>
  </div>

  <div class="card writeBox">
    <div class="wrap">
      <p style="font-size: 32px">제목</p><hr>
    </div>
    <div class="wrap">
      <p style="font-size: 24px">간단한 내용</p>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>