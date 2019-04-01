<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Veteriner Bilgi Sistemi Test 1.0</title>
		<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
	<style>
	body {	
	    margin:0;
	    padding:0;
	    font-family:verdana;
	    background:#262626;
	}
	/* **********************Opening Main Page Loader********************************** */
	#ring {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%); 
		width: 150px;
		height: 150px;
		background: transparent;
		border: 3px solid #3c3c3c;
		border-radius: 50%;
		text-align: center;
		line-height: 150px;
		font-family: sans-serif;
		font-size: 20px;
		color: #fff000;
		letter-spacing:4px;
		text-transform: uppercase;
		text-shadow:0 0 10px #fff000;
		box-shadow: 0 0 20px rgba(0,0,0,.5);
	}
	#ring:before {
		content: '';
		position: absolute;
		top: -3px;
		left: -3px;
		width: 100%;
		height: 100%;
		border: 3px solid transparent;
		border-top: 3px solid #fff000;
		border-right: 3px solid #fff000;
		border-radius: 50%;
		animation: animateCircle 2s linear infinite;
	}
	#span {
		display: block;
		position: absolute;
		top: calc(50% - 2px);
		left: 50%;
		width: 50%;
		height: 4px;
		background: transparent;
		transform-origin:left;
		animation: animate 2s linear infinite;
	}
	#span:before {
		content:'';
		position: absolute;
		width: 16px;
		height: 16px;
		border-radius: 50%;
		background-color: #fff000;
		top: -6px;
		right: -8px;
		box-shadow: 0 0 20px #fff000;
	}
	
	 @keyframes animateCircle
	{
		0%
		{
			transform: rotate(0deg);
		}
		100%
		{
			transform: rotate(360deg);
		}
	}
	@keyframes animate
	{
		0%
		{
			transform: rotate(45deg);
		}
		100%
		{
			transform: rotate(405deg);
		}
	}
	/* **********************Opening Main Page Loader**************FINISHED******************** */

	
	/* **********************Mune Sidebar********************************** */

	@import url('https://fonts.googleapis.com/css?family=Numans');
	
	html,body{
	background-image: url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100%;
	font-family: 'Numans', sans-serif;
	}
	
	.container{
	height: 100%;
	align-content: center;
	}
	
	.card{
	height: 250px;
	margin-top: auto;
	margin-bottom: auto;
	width: 400px;
	background-color: rgba(0,0,0,0.5) !important;
	}
	
	.social_icon span{
	font-size: 60px;
	margin-left: 10px;
	color: #FFC312;
	}
	
	.social_icon span:hover{
	color: white;
	cursor: pointer;
	}
	
	.card-header h3{
	color: white;
	}
	
	.social_icon{
	position: absolute;
	right: 20px;
	top: -45px;
	}
	
	.input-group-prepend span{
	width: 50px;
	background-color: #FFC312;
	color: black;
	border:0 !important;
	}
	
	input:focus{
	outline: 0 0 0 0  !important;
	box-shadow: 0 0 0 0 !important;
	
	}
	
	.remember{
	color: white;
	}
	
	.remember input
	{
	width: 20px;
	height: 20px;
	margin-left: 15px;
	margin-right: 5px;
	}
	
	.login_btn{
	color: black;
	background-color: #FFC312;
	width: 100px;
	}
	
	.login_btn:hover{
	color: black;
	background-color: white;
	}
	
	.links{
	color: white;
	}
	
	.links a{
	margin-left: 4px;
	}

	/* **********************Mune Sidebar*************FINISHED********************* */
	</style>


<body onload="myFunction()" style="margin:0;">
	<div class="container">
		<div id="ring">
			LOADING.
			<span></span>
		</div>
		<div style="display:none; color:white; " id="myDiv" class="animate-bottom">
		
		
		<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>VBS GİRİŞ PANELİ</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-google-plus-square"></i></span>
				</div>
			</div>
			<div class="card-body">
				<form name='login' action="${context}/login" method='POST'>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" name="username" class="form-control" placeholder="Kullanıcı Adı">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name="password" class="form-control" placeholder="Parola">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Beni Hatırla</input>
					</div>
					<div class="form-group">
						<input type="submit" value="Giriş" class="btn float-right login_btn">
					</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
					<c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold;
					 margin: 30px 0px;">${errorMessge}</div></c:if>
			</div>
		</div>
	</div>
		
		
		
		
		
		</div>
	</div>

	<script>
		var myVar;
		
		function myFunction() {
		  myVar = setTimeout(showPage, 1500);
		}
		
		function showPage() {
		  document.getElementById("ring").style.display = "none";
		  document.getElementById("myDiv").style.display = "block";
		}
	</script>

</body>
</html>
