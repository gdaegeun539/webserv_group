<%--<!--<%&#45;&#45;-->--%>
<%--<!--  Created by IntelliJ IDEA.-->--%>
<%--<!--  User: hukum-->--%>
<%--<!--  Date: 2022-11-30-->--%>
<%--<!--  Time: 오전 10:32-->--%>
<%--<!--  To change this template use File | Settings | File Templates.-->--%>
<%--<!--&#45;&#45;%>-->--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>템플릿테스트</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container" style="padding-top: 150px;">
    <div class="d-grid gap-2 col-6 mx-auto">
        <figure class="text-center">
            <h2>로그인</h2>
            <div class="d-grid gap-2 col-6 mx-auto">
            <hr>
            </div>
        </figure>
    </div>
    <div>
        <div>
            <div class="d-grid gap-2 col-6 mx-auto">
            <div class="d-grid gap-2 col-6 mx-auto">
                <div class="form-group mb-2">
                    <input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
                </div>
                <div class="form-group mb-3">
                    <input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
                </div>
                <button type="button" class="btn btn-dark">로그인</button>
                <div style="text-align: center;">
                    <button type="button" class="btn btn-link">아이디찾기</button>
                    <button type="button" class="btn btn-link">비밀번호찾기</button>
                </div>
            </div>
            <div class="d-grid gap-2 col-6 mx-auto">
                <hr>
                <button type="button" class="btn btn-dark">회원가입</button>
            </div>
            </div>
        </div>
    </div>
<br/>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
