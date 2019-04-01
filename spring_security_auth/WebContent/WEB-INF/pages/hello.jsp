<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html ng-app>
<head>
<title>SpringMVC AngularJS DENEME</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script>
function Hello($scope, $http) {
$scope.getUserDetails = function()
{
$http.get('http://localhost:8484/VeterinerBilgiSistemi/restapi/userdetails').
success(function(data) {
$scope.user = data;
});
}
}
</script>
</head>
<body>
<div ng-controller="Hello">
<h2>SpringMVC AngularJS DENEME</h2>
<button ng-click="getUserDetails()">Kullanıcı Detaylarını Getir</button>
<p>İsim : {{user.adi}}</p>
<p>Soyisim : {{user.soyadi}}</p>
</div>
</body>
</html>