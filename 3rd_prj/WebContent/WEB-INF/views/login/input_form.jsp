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
	#class4Wrap{ width:1300px ; height: 1100px; margin: 0px auto; }
	/* 헤더 시작 */
	#header{ width:1100px; height: 150px; position:relative; font-size: 20px;}
	#hContent{ width:700px; height: 90px; padding-top :10px; position:absolute; top:0px; left:200px;}
	#naviBar{ width:1100px; height: 50px;position:absolute;top:100px;}
	/* 헤더 끝 */
	/* 컨테이너 시작 */
	#container{ width:1100px; height: 0px auto; position:relative; margin: 0px auto; margin-top:70px; margin-bottom: 10%;}
	/* { width:1300px ; height: 1800px; }	 */	
	/* 컨테이너 끝 */
	/* footer 시작 */
	#footer{ width:1300px ; height: 150px; background-color: #6A95C8  }
	#fLogo{ width:180px ; height: 130px; padding-top: 20px; padding-left: 20px ; float: left; }
	#fContent{ width:670px ; height: 110px; padding-top: 20px; padding-left: 20px; float: right; }
	/* footer 끝 */
	#hTitle{ font-family: '고딕' ; font-size: 30px ; font-weight: bold; color: #FFB344}
	
	td{ padding: 10px}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Amaranth&display=swap" rel="stylesheet">
<script type="text/javascript">
$(function(){

	
	$("#goBtn").click(function(){
		$("#cardInfoFrm").submit();
		<%-- <%
	   request.getAttribute("signUpVO");
		%> --%>
	});//click
	$("#nextBtn").click(function(){
		location.href="finish_signUp_noCard.do";
	});//click
	
	
});
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
<form id="cardInfoFrm" action="finish_signUp.do" method="post" >
	<div align="center" style="border: 1px solid #333; width: 550px; height: 700px; padding-top: 20px ; margin-left: auto; margin-right: auto;">
		<div><img src="http://localhost:8080/3rd_prj/common/images/credit-card3.png">&nbsp;&nbsp;&nbsp;&nbsp;<strong>결제정보 입력</strong></div><br/>
			
			<table>
				<tr>
					<td>카드번호1</td><td><input type="text" class="form-control" id="inputPassword2" name="cardNum1" maxlength="4"></td>
				</tr>
				<tr>
					<td>카드번호2</td><td><input type="text" class="form-control" id="inputPassword2" name="cardNum2" maxlength="4"></td>
				</tr>
				<tr>
					<td>카드번호3</td><td><input type="text" class="form-control" id="inputPassword2" name="cardNum3" maxlength="4"></td>
				</tr>
				<tr>
					<td>카드번호4</td><td><input type="text" class="form-control" id="inputPassword2" name="cardNum4" maxlength="4"></td>
				</tr>
				<tr>
					<td>카드유형</td>
					<td>
		 	   <div class="col-sm-3">
  
    
      <select class="form-control" name="cardTypeCode">
  		  <c:forEach var="cardTypeList" items="${cardTypeList }">
			<option value="${ cardTypeList.cardTypeCode }"><c:out value="${ cardTypeList.cardType }"/></option>
		  </c:forEach>
    
	  </select></td>
				</tr>
				<tr>
					<td>만료일</td><td><input type="text" class="form-control" id="expireDate" name="exDate" maxlength="5"></td>
				</tr>
				<tr>
					<td>보안코드</td><td><input type="text" class="form-control" id="CVV" name="cvv" maxlength="3"></td>
				</tr>
		<!-- 		<tr>
					<td>청구주소</td>
					<td>
						<div class="form-inline"><input type="text" class="form-control" id="zipcode1" style="width: 80px">&nbsp;-&nbsp;<input type="text" class="form-control" id="zipcode2" style="width: 80px">
						&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-outline-secondary">우편번호 찾기</button>
						</div><br/>
						<div><input type="text" class="form-control" id="addr1"></div><br/>
						<div><input type="text" class="form-control" id="addr2"></div>
					</td>
				</tr>			 -->
				</table>
				<br/><br/>
				<button type="button" class="btn btn-outline-secondary" id="goBtn">가입하기</button>
				<button type="button" class="btn btn-outline-secondary" id="nextBtn">다음에 하기</button>
			</div>
</form>		
	 
	 </div>
	</div>	 



</body>
</html>