<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>구인글 등록 페이지</title>
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="css/post_register.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="row px-1 py-1 mt-2">
  <div class="col">
    <div class="card mb-4">
      <div class="card-header d-flex align-items-end">
        <textarea cols="50" rows="1" name="title" class="form-control" placeholder="모임 제목 입력"></textarea>
      </div>
      <div class="card-body">
        <textarea cols="50" rows="10" name="content" class="form-control" placeholder="내용 입력"></textarea>
        <textarea cols="50" rows="1" name="capacity" class="form-control" placeholder="인원 수 입력"></textarea>
      </div>
    </div>
  </div>
</div>

<div class="d-flex justify-content-end">
  <form style="float:right;" action="detail_page.jsp">
    <button class="btn" style="font-size: 18px" type="submit">등록</button>
  </form>
  <form style="float:right;" action="javascript:history.back()">
    <button class="btn" style="font-size: 18px">취소</button>
  </form>
</div>

<jsp:include page="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>