<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/signin.css"
	rel="stylesheet">

<script src="<%=request.getContextPath()%>/js/js.cookie.js"></script>

<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>

	<script>
$(document).ready(function(){
		
		var userId = Cookies.get("userId");
		if(userId != undefined){
			$("#userId").val(userId);
			//remember me checkbox 체크
			$("#rememberMe").prop("checked", true);
			$("#pass").focus();
		}
		
		//signin btn 클릭 이벤트 핸들러
		$("#signinBtn").on("click", function(){
			/* if($("#rememberMe").prop("checked")){
				Cookies.set("userId", $("#userId").val(), {expires : 30});
			}
			else{
				Cookies.remove("userId");
			} */
			
			//로그인 요청
			$("#frm").submit();
			
			//remember me check box가 체크가 되었는지??
			//체크되어있으면
			//	userId 쿠키를 생성하고 값은 userId input의 값을 쿠키 값으로 설정
			//체크되어있지 않으면
			//	기존에 사용자가 아이디를 쿠키에 저장하는 기능을 사용하다가 더 이상 사용하지 않는 경우
			//  처음부터 아이디 쿠키 저장 기능을 사용하지 않는 경우
			//	==> userId 쿠키를 삭제
		});
	});

// 	     function getCookie(cookieString, cookieId){
// 	         var cookies = cookieString.split("; ");
// 	         for(var i = 0; i < cookies.length; i++){
// 	            var cookieNmVal = cookies[i].split("=");
	            
// 	            if(cookieId == cookieNmVal[0])
// 	               return cookieNmVal[1];
// 	         }
// 	         return "brown";
// 	      }
	     
// 	     function setCookie(cookieNm, cookieValue, expires){
// 	    	var dt = new Date();
// 	 		dt.setDate( dt.getDate() + Number(expires));
	 		
// 	 		document.cookie = cookieNm + "=" + cookieValue + "; path=/; expires=" +
// 	 							dt.toGMTString();
// 	     }
	     
// 	     function deleteCookie(cookieNm){
// 	    	 setCookie(cookieNm, "", -1);
// 	     }
     </script>

</head>

<body>
	<div class="container">
		<%
			HttpSession httpSession = request.getSession();
				       	    		User userVo = (User)httpSession.getAttribute("S_USERVO");
				       	    		String userName = "";
				       	    		userName = userVo == null ? "" : userVo.getUserName();
		%>

		사용자 이름 :
		<%=userName %>

		<form class="form-signin"
			action="<%=request.getContextPath() %>/login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>

			<label for="userId" class="sr-only">userId</label>
			<%
        	String userId = request.getParameter("userId");
//         	String userId = (String)request.getAttribute("userId");
        	userId = userId == null ? "id1" : userId;
        %>
			<input name="userId" type="text" id="userId" class="form-control"
				placeholder="userId" required autofocus> <label for="pass"
				class="sr-only">Password</label> <input name="pass" type="password"
				id="pass" class="form-control" placeholder="Password" required>

			<div class="checkbox">
				<label> 
					<input id="rememberMe" name="rememberMe" type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button id="signinBtn" class="btn btn-lg btn-primary btn-block"
				type="submit">Sign in</button>
		</form>

	</div>
	<!-- /container -->
	
	

</body>
</html>
