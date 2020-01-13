<%@page import="org.springframework.beans.factory.annotation.Value"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Information</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<script type="text/javascript">
	$(function() {
		$('.alert-danger').delay(5000).show().fadeOut('slow');
	})
</script>
<style>
.sec-container {
	display: flex;
	justify-content: space-evenly;
	background-color: #d9edf7;
	align-items: center;
	flex-wrap: wrap;
}

.contant {
	width: 87%;
	height: 48%;
	border-radius: 5px;
	border: 0px;
	padding: 10px 10px;
	overflow: hidden;
	margin-top: 10px;
	margin-bottom: 10px;
	background-color: white;
}

.btn {
	margin-bottom: 11px;
	margin-left: 16px;
}

h4 {
	margin-left: 16px;
}
</style>
<body style="background-color: #d9edf7">
	<c:if test="${not empty status}">
		<c:if test="${status eq 'false'}">
			<div class="alert alert-danger" role="alert" id="alertshow">
				${message}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
	</c:if>
	<div class="sec-container">
		<div class="contant" style="height: 350px;">
			<h4>
				<span>Hello </span>${user.name}<br>
			</h4>
			<h4>
				<span>Your Location is :</span>${user.address}<br>
			</h4>
			<h4>
				<span>Location Weather :</span>${user.weather}°C</h4>
			<form action="/get-news-based-on-country" method="get">
				<%-- <select name="countrycode" class="browser-default custom-select"
					required="required">
					<option selected value="">select country news</option>
					<c:forEach items="${country}" var="ctry">
						<option value="${ctry.code}">${ctry.country}</option>
					</c:forEach>
				</select> --%>
				<div class="col-sm-6 col-md-4">
					<select name="countrycode" class="form-control" required="required">
						<option selected value="">select country news</option>
						<c:forEach items="${country}" var="ctry">
							<option value="${ctry.code}">${ctry.country}</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-info">News</button>
			</form>
			<a href="/beep-bot-home"><button type="button"
					class="btn btn-warning">Back</button></a>
		</div>
	</div>

</body>
</html>