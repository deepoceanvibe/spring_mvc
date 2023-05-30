<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form action = "http://localhost:8181/chap03/orderresult" method = "POST">
        <h1> 음식 주문 키오스크 </h1>
        주문자명 : <input type = "text" name = "name"><br/>
        주문테이블번호 : <input type = "number" name = "tableNum"><br/>
        주문할수있는음식 : <input type = "text" name = "orderMenu"><br/>
        <input type = "submit" value = "제출">
    </form>

</body>
</html>
