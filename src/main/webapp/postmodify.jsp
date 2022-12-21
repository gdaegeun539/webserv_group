<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>구인글 수정 페이지</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="css/postmodify.css">
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
        <ul>
          <p class="me-1 list_detail"><span class="ms-5">${post.location}</span></p>
          <textarea cols="50" rows="10" name="content" class="form-control" placeholder="내용 입력">${post.content}</textarea>
          <p class="d-flex justify-content-between align-self-end list_detail"><span>${post.people.size}/${post.capacity}명</span><span>${post.updated_at}</span></p>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="d-flex justify-content-end">
  <form style="float:right;" action="<c:url value="/post?action=edit"/>">
    <button class="btn" style="font-size: 18px" type="submit">완료</button>
  </form>
  <form style="float:right;" action="javascript:history.back()">
    <button class="btn" style="font-size: 18px">취소</button>
  </form>
</div>

<jsp:include page="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>