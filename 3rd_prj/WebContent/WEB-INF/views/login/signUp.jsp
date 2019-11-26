<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
    %>
  
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
	$("#id").focusout(function(){
		 if($("#id").val()!=""){
			$("#id").attr('class','form-control is-valid');
			$("#id_div").attr('class','valid-feedback');
			$("#id_div").text("");
		}else{
			$("#id").attr('class','form-control is-invalid');
			$("#id_div").attr('class','invalid-feedback');
			$("#id_div").text("아이디를 입력해주세요.");
			
		}//아이디 값 존재 여부
		
	});//focusout - id
	
	$("#userName").focusout(function(){
		 if($("#userName").val()!=""){
				$("#userName").attr('class','form-control is-valid');
				$("#userName_div").attr('class','valid-feedback');
				$("#userName_div").text("");
			}else{
				$("#userName").attr('class','form-control is-invalid');
				$("#userName_div").attr('class','invalid-feedback');
				$("#userName_div").text("이름 입력해주세요.");
				
			}//이름 존재 여부
	});//focusout - name
	
	$("#inputPassword").focusout(function(){
		 if($("#inputPassword").val()!=""){
				$("#inputPassword").attr('class','form-control is-valid');
				$("#inputPassword_div").attr('class','valid-feedback');
				$("#inputPassword_div").text("");
			}else{
				$("#inputPassword").attr('class','form-control is-invalid');
				$("#inputPassword_div").attr('class','invalid-feedback');
				$("#inputPassword_div").text("비밀번호를 입력해주세요.");
				
			}//비밀번호 존재여부 
	});//focusout - pass
	$("#inputPasswordCheck").focusout(function(){
		 if($("#inputPasswordCheck").val()!=""){
			if($("#inputPassword").val()!=$("#inputPasswordCheck").val()){
				alert("값이 다름");
			}//end if
			 
			 $("#inputPasswordCheck").attr('class','form-control is-valid');
				$("#inputPasswordCheck_div").attr('class','valid-feedback');
				$("#inputPasswordCheck_div").text("");
			
		 	}else{
				$("#inputPasswordCheck").attr('class','form-control is-invalid');
				$("#inputPasswordCheck_div").attr('class','invalid-feedback');
				$("#inputPasswordCheck_div").text("비밀번호 확인을 입력해주세요.");
				
			}//비밀번호 확인 존재여부 
	});//focusout - pass
	
	$("#hintAw").focusout(function(){
		 if($("#hintAw").val()!=""){
			 
			 $("#hintAw").attr('class','form-control is-valid');
				$("#hintAw_div").attr('class','valid-feedback');
				$("#hintAw_div").text("");
			
		 	}else{
				$("#hintAw").attr('class','form-control is-invalid');
				$("#hintAw_div").attr('class','invalid-feedback');
				$("#hintAw_div").text("비밀번호 힌트 답을 작성해주세요.");
				
			}//비밀번호 힌트 정답 존재 여부
	});//focusout - hintAw
	$("#phone2").focusout(function(){
		 if($("#phone1").val()!=""&& $("#phone2").val()!=""){
			 
			 $("#phone1").attr('class','form-control is-valid');
			 $("#phone2").attr('class','form-control is-valid');
				$("#phone_div").attr('class','valid-feedback');
				$("#phone_div").text("");
			
		 	}else{
				$("#phone1").attr('class','form-control is-invalid');
				$("#phone2").attr('class','form-control is-invalid');
				$("#phone_div").attr('class','invalid-feedback');
				$("#phone_div").text("핸드폰 번호를 입력해주세요.");
				
			}//비밀번호 확인 존재여부 
	});//focusout - pass
	
	$("#email2").focusout(function(){
		 if($("#email").val()!=""&& $("#email2").val()!=""){
			 
			 $("#email").attr('class','form-control is-valid');
			 $("#email2").attr('class','form-control is-valid');
				$("#email_div").attr('class','valid-feedback');
				$("#email_div").text("");
			
		 	}else{
				$("#email").attr('class','form-control is-invalid');
				$("#email2").attr('class','form-control is-invalid');
				$("#email_div").attr('class','invalid-feedback');
				$("#email_div").text("핸드폰 번호를 입력해주세요.");
				
			}//이메일 존재 여부
	});//focusout - pass
	
});//ready
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

<form id="signUpFrm">
 <h2 align="center"><strong>Register</strong></h2>
<div style="margin-left: 200px;">
 
  <br/>
  
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-3">
       <input type="text" class="form-control " id="id" placeholder="아이디 입력"  required/>
      <div  id="id_div"> </div> 
      
    </div>
  </div>
  
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="userName" value="">
      <div  id="userName_div"> </div> 
    </div>
  </div> 
  
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-3" >
      <input type="password" class="form-control" id="inputPassword" placeholder="Password">
      <div  id="inputPassword_div"> </div> 
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 확인</label>
    <div class="col-sm-3">
      <input type="password" class="form-control" id="inputPasswordCheck" placeholder="Password">
      <div  id="inputPasswordCheck_div"> </div> 
    </div>
  </div>
  
 <div class="form-group row">
  <label for="staticEmail" class="col-sm-2 col-form-label">비밀번호 힌트</label>
    <div class="col-sm-3">
      <select class="form-control">
  		<option>나의 보물 1호는?</option>
  		<option>강아지</option>
  		<option>고양이</option>
	  </select>
    </div>
  </div>
  
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">힌트 정답</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="hintAw" >
      <div  id="hintAw_div"> </div> 
    </div>
  </div> 
  
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">휴대전화</label>
    <div class="col-sm-1" >
      <select class="form-control" style="width:80px">
  		<option>010</option>
  		<option>011</option>
  		<option>012</option>
	  </select>
    </div>
    <div class="col-sm-3" align="left">
     <input type="text" class="form-control" id="phone1" style="margin-left: 15px;">
    </div><span style="margin-top: 10px; margin-left: 10px;" >-</span>
    <div class="col-sm-3">
     <input type="text" class="form-control" id="phone2">
      <div  id="phone_div"> </div> 
    </div>
  </div>
  
 <div class="form-group row">
  <label for="staticEmail" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" placeholder="mail" id="email">
    </div>
    @
    <div class="col-sm-3">
      <select class="form-control">
  		<option>직접입력</option>
  		<option>naver.com</option>
  		<option>hanmail.co.kr</option>
	  </select>
    </div>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="email2"/>
  </div>
      <div  id="email_div"></div> 
  </div>
    <div id="btnClass"style="position: relative; margin-top: 50px; margin-left: 250px; margin-bottom: 100px;" >
				<input type="button" value="취소" class="btn btn-outline-secondary alert-danger" id="goBtn" style="margin-right: 25px;" >
				<input type="button" value="다음" class="btn btn-outline-secondary alert-secondary" id="backBtn">
				
			</div>
    
    
  </div>
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