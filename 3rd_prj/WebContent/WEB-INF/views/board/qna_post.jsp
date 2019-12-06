<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	#th{background-color: #C8C4C1; width: 150px; text-align: center;}
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
<style type="text/css">
.alert-danger{color: #000000; background-color: #E3C6C2; }
</style>
<script type="text/javascript">
$(function(){
	
	$("#addRp").click(function(){
		var q_answer_flag = $("#q_answer_flag").val();
		
		if(q_answer_flag =="N"){
			var str = $("#q_answer").val();
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			$("#q_answer").val(str);
			
		var formData = new FormData(document.getElementById('rpFrm'));
			$.ajax({
				url:"/3rd_prj/board/addRp.do",
				processData: false,
				contentType: false,
				data:formData,
				type:"post",
				dataType:"json",
				error:function(xhr){
					alert("문제발생\n" + xhr.status + "\n" + xhr.statusText);
				},
				success:function(json){
				location.href="/3rd_prj/board/qna_post.do?q_num="+$("#q_num").val();	
				}//success
			});//ajax 	
			
		}else{
			alert("댓글을 이미 작성하셨습니다.");
			
		}//end else
		
	});//click
	
	$("#modifyPost").click(function(){
		
	$("#modify_frm").submit();
	
	});//click
	
	$("#modifyRp").click(function(){
		var obj = document.repFrm;
		$("#replyPre").toggle();
		$("#replyNext").toggle();
		
		var q_answer = $("#c_answer").val().trim();
		var n_answer = $("#n_answer").val().trim();
		
		var str = $("#n_answer").val();

		str = str.split('<br/>').join("\r\n");

		$("#n_answer").val(str);
				
		if(q_answer != n_answer){
			if(confirm("변경내용을 저장하시겠습니까??")){		
				var str = $("#n_answer").val();
				str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
				$("#n_answer").val(str);	
				
	var formData = new FormData(document.getElementById('repFrm'));
			$.ajax({
				url:"/3rd_prj/board/rp_modify.do",
				processData: false,
				contentType: false,
				data:formData,
				type:"post",
				dataType:"json",
				error:function(xhr){
					alert("문제발생\n" + xhr.status + "\n" + xhr.statusText);
				},
				success:function(json){
				location.href="/3rd_prj/board/qna_post.do?q_num="+$("#q_num").val();	
				}//success
			});//ajax 	
			
			
			
			
			}//end if
		}//end if
	});//click
});//ready
function del_process(q_num){
	if(confirm("정말 삭제하시겠습니까?")){
		var q_num = q_num;
		$.ajax({
			url:"/3rd_prj/board/delete_post.do",
			processData: false,
			contentType: false,
			data:"q_num="+q_num,
			type:"get",
			dataType:"json",
			error:function(xhr){
				alert("문제발생\n" + xhr.status + "\n" + xhr.statusText);
			},
			success:function(json){
				if(json.result == true){
					$("#answer").html();
					location.href="/3rd_prj/board/qna_list.do"
				}else{
					alert("게시글이 삭제되지 않았습니다.");
				}//end if
			}//success
		});//ajax 	
		
			}//end if
	
}//del_process
</script>
</head>
<body>
<div id="class4Wrap">
<div id="naviBar">
 	<!-- MENU 시작 -->
 	<%@include file="../../../common/navbar/nav.jsp" %>
 	<!-- MENU 끝 -->
</div>
<div id="container">
<h2 style="margin-bottom: 40px; text-align: center; font-weight: bold;"> Q & A </h2>
<table class="table" >
  <tbody>

    <tr>
      <th scope="row" id="th">subject</th><td><c:out value="${qbdd.q_subject}"/></td>
    </tr>
    <tr>
      <th scope="row" id="th">name</th><td><c:out value="${qbdd.user_id}"/></td>
    </tr>
    <tr>
      <th scope="row" id="th">Date</th><td><c:out value="${qbdd.q_input_Date}"/></td>
    </tr>
    <tr>
      <td colspan="2" style="height: 600px;">
      <div style="margin: 50px; text-align: left;">
 	 <c:out value="${qbdd.q_content}" escapeXml="false"/>
      </div>
      </td>
   	</tr>
     <c:if test="${qbdd.q_answer_Flag eq 'Y'}">
     <tr id="answer">

   	<th id="th"  style="vertical-align: middle; height:150px; text-align: center;">관리자   </th>
      <td style="background-color: #FFFAF0;">
        <form id="repFrm" name="repFrm" >
      <div style="float:left;" id="reply">
      <div id="replyPre" >
      <c:out value="${qbdd.q_answer}" escapeXml="false"/><span style="font-size: 12px; color: gray; margin-left: 50px;" ><c:out value="${qbdd.q_answer_date}"/></span>
      </div>
      <div id="replyNext" style="display: none">
      <textarea rows="5" style="width: 810px;"   class="form-control" id="n_answer" name="q_answer"> <c:out value="${qbdd.q_answer}" escapeXml="false"/></textarea>
      </div>
      
       </div>
        <c:if test="${admin_id ne null }">
         <div style="float:right;">
         <input type="hidden" name="q_num" value="${qbdd.q_num }"/>
         <input type="hidden" name="c_answer" id="c_answer" value="${qbdd.q_answer}"/>
   		 <input type="button" value="수정" class="btn btn-secondary alert-secondary" id="modifyRp" />
    	</div> 	
    	</c:if>
    	 </form>
      </td>
     
      </tr>
      </c:if>
    <tr>
     <c:if test="${admin_id ne null }">
      <th scope="row" id="th" style="vertical-align: middle;">댓글</th>
      <td>
      <div>
     <form  id="rpFrm" name="rpFrm">
      <div style="float:left;">
      <textarea name="q_answer" id="q_answer" class="form-control" style="width: 810px;" rows="5" 
      <c:if test="${qbdd.q_answer_Flag eq 'Y'}">readonly="readonly" placeholder="답글을 이미 작성 하셨습니다."</c:if>></textarea>
      </div>
      <div style="float:right;">
	<input type="hidden" name="q_num" id="q_num" value="<c:out value="${qbdd.q_num}"/>"/>
	<input type="hidden" id="q_answer_flag" name="q_answer_flag" value="<c:out value="${qbdd.q_answer_Flag}"/>"/>
    <input type="button" value="입력" class="btn btn-secondary alert-danger" id="addRp" name="addRp" style="width: 110px; height: 135px;"/>
    	</div>
    </form>
    	</div>
    </td>
    </c:if>
    </tr>
  </tbody>
</table>
<div >
<div style="float: left;">
	<input type="button" value="목록" class="btn btn-secondary alert-danger btn-sm" id="golist" onclick="location.href='/3rd_prj/board/qna_list.do'"/>
</div>
<form action="/3rd_prj/board/modify_form.do" method="post" name="modify_frm" id="modify_frm">
<input type="hidden" name="q_num" value="<c:out value="${qbdd.q_num}"/>"/>
<input type="hidden" name="q_subject" value="${qbdd.q_subject}"/>
<input type="hidden" name="q_content" value="${qbdd.q_content}"/>
<div style="float:right;">
	<c:if test="${qbdd.q_answer_Flag != 'Y'}">
	<input type="button" value="수정" class="btn btn-secondary alert-secondary" id="modifyPost"  >
	</c:if>
	<input type="button" value="삭제" class="btn btn-secondary alert-secondary" id="deletePost" onclick="del_process('${qbdd.q_num}')" />
</div>
</form>
</div>

</div>
<div id="footer">
	<a href="#"><img src="http://localhost:8080/3rd_prj/common/images/arrow.png" width="50" height="50" style="position:fixed; left: 93%; top:85%;  "/></a> 
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