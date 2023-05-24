# 커뮤니티버전 프로젝트 JDK 연결

1. File -> Project Structure
2. Project Settings SDK 17 버전으로 맞추기
3. File -> Settings 들어가기
4. gradle 검색 -> tamurine.. 로 맞추기
5. 코끼리 아이콘 누르기

# VS CODE에서 연결하는 방법
1. vscode 좌측 하단 톱니바퀴 클릭
2. 사용자 코드 조각 (user snipets) 클릭 후 html 입력
3. html.json 파일에 아래 코드 붙여놓고 저장
4. .jsp 파일 생성 후 !jsp 입력하면 템플릿이 자동완성 됨.

```
"JSP template": {
"prefix": "!jsp",
"body": [
"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>",
"<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>",
"<!DOCTYPE html>",
"<html>",
"<head>",
"<meta charset=\"UTF-8\">",
"<title>Insert title here</title>",
"</head>",
"<body>",
"</body>",
"</html>",
],
"description": "make jsp template"
}
```
