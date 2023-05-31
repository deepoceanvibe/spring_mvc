<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class = "container">
    <h1>${score.studentNumber}번 학생 성적</h1>
    <table class="table table-hover">
    <thead>
        <tr>
            <td>이름</td>
            <td>${score.name}</td>
        </tr>
        <tr>
            <td>국어</td>
            <td>${score.korScore}</td>
        </tr>
        <tr>
            <td>수학</td>
            <td>${score.mathScore}</td>
         </tr>
         <tr>
            <td>영어</td>
            <td>${score.engScore}</td>
        </tr>
        <tr>
             <td>총점</td>
             <td>${score.korScore + score.mathScore + score.engScore}</td>
        </tr>
        <tr>
             <td>평균</td>
             <td>${(score.korScore + score.engScore + score.mathScore) / 3}</td>
        </tr>
    </table>
    <a href = "/score/list" class="btn btn-primary"> 목록으로 돌아가기 </a>
    <form action="/score/remove" method="POST">
        <input type = "hidden" name = "studentNumber" value = "${score.studentNumber}">
        <input type = "submit" name = "btn btn-secondary" value = "삭제하기">
    </form>
    </div>
</body>
</html>
