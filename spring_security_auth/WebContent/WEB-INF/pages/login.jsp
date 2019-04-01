<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Veteriner Bilgi Sistemi Test 1.0</title>
</head>
<body>
	<div>
		<div>
			<h3>VBS GİRİŞ PANELİ</h3>
		</div>
		<div>
			<form name='login' action="${context}/login" method='POST'>
				<div>
					<input type="text" name="username" class="form-control"
						placeholder="Kullanıcı Adı">
				</div>
				<div>
					<input type="password" name="password" class="form-control"
						placeholder="Parola">
				</div>
				<div>
					<input type="submit" value="Giriş">
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
	</div>
</body>
</html>
