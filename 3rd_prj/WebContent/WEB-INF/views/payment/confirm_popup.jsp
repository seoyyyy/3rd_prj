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
	#class4Wrap{ width:1100px; height: 1100px; margin: 0px auto;}
	/* 헤더 시작 */
	#header{ width:1100px; height: 150px; position:relative; font-size: 20px;}
	#hContent{ width:700px; height: 90px; padding-top :10px; position:absolute; top:0px; left:200px;}
	#naviBar{ width:1100px; height: 50px;position:absolute;top:100px;}
	/* 헤더 끝 */
	/* 컨테이너 시작 */
	#container{ width:900px ; height: 800px; }
	.trTable{ width:30px ; height:40px; }
	.tdTable{ padding-right: 20px; font-size: 15px;}
	.tdTable2{ font-size: 15px; }
	/* 컨테이너 끝 */
	/* footer 시작 */
	#footer{ width:900px ; height: 150px; background-color: #6A95C8  }
	#fLogo{ width:180px ; height: 130px; padding-top: 20px; padding-left: 20px ; float: left; }
	#fContent{ width:670px ; height: 110px; padding-top: 20px; padding-left: 20px; float: right; }
	/* footer 끝 */
	#hTitle{ font-family: '고딕' ; font-size: 30px ; font-weight: bold; color: #FFB344}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script type="text/javascript">
$(function(){

});
</script>
</head>
<body>
<div id="class4Wrap">
<!-- 	900(w) x 1100(h) -->
<div id="header">
		<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white"  >
	<!-- HOME Logo -->
  <a class="navbar-brand" href="#" style="margin-left: 30px;"><img src="http://localhost:8080/3rd_pprj/kr.co.sist.user.view/images/home.png"/> </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown" style="margin-left: 1050px;">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Introduce</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Reservation</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contact</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         	Board
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="notice_list.jsp">공지사항</a>
          <a class="dropdown-item" href="qna_list.jsp">문의게시판</a>
        </div>
      </li>
      <li class="nav-item" style="margin-left: 30px;">
      <form class="form-inline">
        <a class="nav-link" href="#">Login</a>&nbsp;|&nbsp;<a class="nav-link" href="#"><font color="#000000">Sign UP</font></a>
      </form>
      </li>
    </ul>
  </div>
</nav>
	<div id="naviBar">
	</div>
</div>
<div id="container">
	
	<div id="container" align="center"> 
	<div style="border: 1px solid #333; width:400px ; height: 450px; background-color: #FCEFCF;">
	<br/><br/>
		<table>
			<tr class="trTable">
				<td class="tdTable">예약날짜</td><td class="tdTable2">2019-11-07</td>
			</tr>
			<tr class="trTable">
				<td class="tdTable">예약시간</td><td class="tdTable2">8:00AM - 16:00PM</td>
			</tr>
			<tr class="trTable">
				<td class="tdTable">이름</td><td class="tdTable2">백승규</td>
			</tr>
			<tr class="trTable">
				<td class="tdTable">연락처</td><td class="tdTable2">010-1111-1111</td>
			</tr>
			<tr class="trTable">
				<td class="tdTable">이메일</td><td class="tdTable2">back@naver.com</td>				
			</tr>			
			<tr class="trTable">
				<td class="tdTable"><strong>결제요금</strong></td><td class="tdTable"2><strong>160,000원</strong></td>			
			</tr>
		</table>
		<br/><br/>
		<div>
		<button type="button" class="btn btn-outline-secondary">확인</button>
		<button type="button" class="btn btn-outline-secondary">결제</button>

		</div>
		<br/><br/>
	</div>
	
</div>
	
	
</div>
<div id="footer">
	<div id="fLogo">
	<img src="http://localhost:8080/3rd_pprj/common/images/f_logo.png" title="댕댕이네 놀러오신 환경합닏낭~~~~~~~"/></div>
	<div id="fContent">
		&copy; CopyRight. AllRight Reserved. class4<br/>
		서울시 강남구 역삼동 한독빌딩 8층 4강의실
	
	</div>
</div>

</div>


</body>
</html>