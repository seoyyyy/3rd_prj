<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
    trimDirectiveWhitespaces="true"
    %>
		<nav class="navbar fixed-top navbar-expand-lg navbar-light"  style="background: rgba(176,171,167,0.7); height: 130px;">
	<!-- HOME Logo 시작-->
  <a class="navbar-brand" href="http://localhost:8080/3rd_prj/home.jsp" style="margin-left: 30px; font-size: 40px;  font-family:'Yeseva One', cursive ; color: #FFFFFF;" id="nav-link" >[:P]</a>
	<!-- HOME Logo 끝-->
	
 	<!-- MENU 시작 -->
   <div class="collapse navbar-collapse" id="navbarNavDropdown" style="margin-left: 55%; font-family:'Amaranth','Yeseva One', cursive ; font-size: 22px;">
    <ul class="navbar-nav ">
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Introduce
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
           <a class="dropdown-item" href="http://localhost:8080/3rd_pprj/view/introduce/about.jsp" id="sub-menuItem">introduce</a>
            <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="http://localhost:8080/3rd_pprj/view/introduce/about1.jsp" id="sub-menuItem" >party & bride</a>
          <a class="dropdown-item" href="http://localhost:8080/3rd_pprj/view/introduce/about2.jsp" id="sub-menuItem" >meeting & conference</a>
        </div>
      </li>
      <li class="nav-item"> 
        <a class="nav-link" href="http://localhost:8080/3rd_pprj/view/reservation/rsv_main.jsp" id="nav-link">Reservation</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/3rd_pprj/view/contact/location.jsp" id="nav-link">Contact</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button"  id="nav-link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
         	Board
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="notice_list.do" id="sub-menuItem">공지사항</a>
          <a class="dropdown-item" href="qna_list.do" id="sub-menuItem">문의게시판</a>
        </div>
      </li>
      <li class="nav-item" style="margin-left: 20px;" id="nav-link">
      <form class="form-inline" >
        <a class="nav-link" href="http://localhost:8080/3rd_pprj/view/login/login.jsp"  id="nav-link">Login</a>&nbsp;|&nbsp;<a href="http://localhost:8080/3rd_pprj//view/login/signUp.jsp" class="nav-link" id="nav-link">sign up</a>
      </form>
      </li>
    </ul>
  </div>
</nav>
 	<!-- MENU 끝 -->