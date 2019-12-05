<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type = "text/javascript">
$(function(){
var q_num = $("#q_num").val();
	location.href="/3rd_prj/board/qna_post.do?q_num="+q_num;
});//ready
</script>
</head>
<body>
<input type="hidden" id="q_num" name="q_num" value='<c:out value="${q_num}"/>'/>
</body>
</html>