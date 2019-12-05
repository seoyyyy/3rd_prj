<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">
$(function(){
	location.href="qna_post.do?q_num="+$("#q_num").val();
	alert("#q_num");
});
</script>
<body>
<input type="hidden" id="q_num" name="q_num" value="<c:out value='${q_num}'/>"/>
</body>
</html>