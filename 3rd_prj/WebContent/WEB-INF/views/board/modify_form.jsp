<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
    %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/3rd_pprj/common/css/main.css"/>
<style type="text/css">
	#class4Wrap{ min-width:1100px; min-height: 1100px; margin: 0px auto;}
	/* 헤더 시작*/
	#naviBar{ min-width:1100px; min-height: 130px; position:relative; font-size: 20px;}
	/* 헤더 끝 */
	/* 컨테이너 시작  */
	#container{ width:1100px; height: 0px auto; position:relative; margin: 0px auto; margin-top:70px; margin-bottom: 10%;}
	.btn{width: 100px;height: 40px;}
	.nav-item{margin: 10px;}
	#sub-menuItem{font-family:"고딕";}
	#ex{padding-bottom: 20px; width: 150px; font-size: 15px;}
	/* 컨테이너 끝  */
	/* 푸터 시작  */
	#footer{  min-width:1100px;min-height: 250px;position:relative;  background-color: #E3C6C2;}
	#fContent{ width: 1100px;height: 110px; padding-top: 30px; margin-right: auto; margin-left: auto }
	/* 푸터 끝  */
	#hTitle{font-family: '고딕'; font-size: 30px; font-weight: bold;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Amaranth&display=swap" rel="stylesheet">
<script type="text/javascript">
$(function(){
	$("#goBtn").click(function() {
	
		if($("#q_subject").val()==""){
			alert("게시글 제목을 입력해주세요.");
			return;
		}//end if
	
		if($("#q_content").val().trim()==""){
			alert("내용을 작성해주세요.");
			return
		}//end if
	 if(confirm("변경사항을 수정하시겠습니까?")){
		$("#modify_process").submit();
	 }
	});//click
	$("#backBtn").click(function(){
		if(confirm('작성하지 않고 돌아가시겠습니까?')){
		history.back();
		}//end if
	});//click
});//ready
</script>
</head>
<body>
<div id="class4Wrap">
<div id="naviBar">
 	<!-- MENU 시작 -->
 	<%@ include file="../../../common/navbar/nav.jsp" %>
 	<!-- MENU 끝 -->
</div>
<div id="container">   
   <form action="/3rd_prj/board/modify_process.do" id="modify_process" method="post">
   <div style="margin-left: 50px;">
         <table>
           
            <tr>
               <td id="ex">제목</td>
               <td>
         			<input class="form-control form-control-sm" type="text" name="q_subject" id="q_subject" autofocus="autofocus" value='${param.q_subject}' style="width: 734px;"/>
        			<br/>
        		</td>
            </tr>
           
           
            <tr>
               <td colspan="2" style="padding-left:150px;">
                  <textarea class="form-control form-control-sm" name="q_content" id="q_content" rows="15" cols="100" ><c:out value="${param.q_content}"/></textarea>
               </td>
            </tr>         
            </table>
             
            </div>
           <div id="btnClass"style="position: relative; margin-top: 50px;" align="center">
				<input type="button" value="수정" class="btn btn-outline-secondary alert-danger" id="goBtn" style="margin-right: 25px;" >
				<input type="button" value="돌아가기" class="btn btn-outline-secondary alert-secondary" id="backBtn">
				
			</div>
			<input type="hidden" id="q_num" name="q_num" value="<c:out value="${param.q_num}"/>"/>
         </form>
</div>
<div id="footer">
	<a href="#"><img src="http://localhost:8080/3rd_pprj/view/images/arrow.png" width="50" height="50" style="position:fixed; left: 93%; top:85%; "/></a> 
	<div id="fLogo">
		
	</div>
	<div id="fContent">
	<div style="float: left; margin-left:150px; margin-right:8%; font-size:14px;">
		<h4><strong>[;P]</strong></h4>
		사업자명 : (주)Baek's company<br/>
		 대표이사 : 윤태식   <br/> 
		이메일 : wo2015@naver.com<br/>
		대표전화 : 02-336-0562<br/>
		사업자등록번호 : 138-87-00193<br/>
		<br/>
		</div>
		<div style="float: left; margin-right:8%; font-size:14px;">
		<strong>LOCATION</strong><br/><br/>
		서울시 강남구 역삼동 409-7 3F, 4F<br/><br/>
		 <strong>OPEN</strong><br/><br/>
		MON-FRI 10:00 ~ 19:00<br/>
		</div>
		<div style="float: left; font-size:14px;">
		<strong>BANK ACCOUNT</strong><br/><br/>
		기업은행 015-074953-04-018<br/>
		​예금주 : 백승규<br/><br/><br/>
			&copy;CopyRight. AllRight Reserved.<br/>
		</div>
	
		
	</div>
</div>
</div>

</body>
</html>