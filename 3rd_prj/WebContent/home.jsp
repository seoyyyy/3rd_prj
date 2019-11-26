<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>
<style type="text/css">
	#class4Wrap{ min-width:1100px; min-height: 1100px; margin: 0px auto;}
	/* 헤더 시작*/
	#naviBar{ min-width:1100px; min-height: 130px; position:relative; font-size: 20px;}
	/* 헤더 끝 */
	/* 컨테이너 시작  */
	#container{ width:1100px; height: 0px auto; position:relative; margin: 0px auto; margin-top:70px; margin-bottom: 10%; }
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
<style type="text/css">
.alert-danger{color: #000000; background-color: #E3C6C2}
</style>
<script type="text/javascript">
$(function(){
	
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
          

<div style="margin: auto;">
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
  </ol>
  <div class="carousel-inner" style="width:1100px; height:600px; ">
    <div class="carousel-item active">
      <img src="http://localhost:8080/3rd_prj/common/images/15.png" class="d-block w-100" alt="1">
    </div>
    <div class="carousel-item">
      <img src="http://localhost:8080/3rd_prj/common/images/2-4.jpg" class="d-block w-100" alt="2">
    </div>
    <div class="carousel-item">
      <img src="http://localhost:8080/3rd_prj/common/images/4-5.jpg" class="d-block w-100" alt="3">
    </div>
    <div class="carousel-item">
      <img src="http://localhost:8080/3rd_prj/common/images/7-5.png" class="d-block w-100" alt="4">
    </div>
    <div class="carousel-item">
      <img src="http://localhost:8080/3rd_prj/common/images/16.png" class="d-block w-100" alt="5">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div><br/><br/>

<div>
<ul class="list-unstyled">
 <div class="media">
  <div class="media-body">
    <h5 class="mt-0 mb-1">Media object</h5>
   프로포즈
나의 연인에게 진심을 담아 전하는 사랑고백.

인생의 한번 뿐인 중요한 순간이다보니 설레기도하고 많은 분들이 긴장을 하신답니다.

저희는 완벽한 프로포즈 준비를 위해 한분한분 친절하게 상담을 진행하고 있으며 또 그에 맞는 준비를 도와드립니다.

  </div>
  <img src="http://localhost:8080/3rd_pprj/view/images/8-2.jpg" class="ml-3" style="width:450px; height:300px" >
</div>
  <li class="media my-4">
   <img src="http://localhost:8080/3rd_pprj/view/images/4-1.jpg" class="mr-3" style="width:450px; height:300px" >
    <div class="media-body">
      <h5 class="mt-0 mb-1">List-based media object</h5>
      가게 내부는 초록초록한 식물과 화이트톤의 인테리어로 구성되어있으며, 전문 플로리스트가 직접 테이블 꽃장식과 포토테이블의 꽃을 세팅해드리기 때문에 고급스럽고 유니크한 공간을 연출해드리고 있습니다. 그리고 사전에 예비신부와 신랑의 사진을 받아 보정하고 출력하여 이름과 함께 공간 곳곳을 데코해드립니다. 
    </div>
  </li>
</ul>
<div class="media">
  <div class="media-body">
    <h5 class="mt-0 mb-1">Media object</h5>
   한 팀만을 위한 원테이블 레스토랑 아름다운 공간과 꽃, 맛있는 음식이 제공됩니다. 조용하고 프라이빗한 공간에서 여러분의 소중한 추억을 정성스럽게 담아드립니다. 프로포즈, 소규모돌잔치, 웨딩, 각종파티 준비해드리고 있습니다. 상세페이지를 참조하시거나 모바일메신저 혹은 전화로 예약해주시면 친절히 상담해드릴게요. 
  </div>
  <img src="http://localhost:8080/3rd_pprj/view/images/2-5.jpg" class="ml-3" style="width:450px; height:300px" >
</div>
</div>

</div>
</div>

<div id="footer">
  <div id="fContent">
	<div style="float: left; margin-left:150px; margin-right:8%; font-size:14px;">
		<h4><strong>[:P]</strong></h4>
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