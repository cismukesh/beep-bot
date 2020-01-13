<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
div.contant {
	margin: 4px, 4px;
	padding: 4px;
	height: 320px;
	overflow: scroll;
	text-align: justify;
}

.meet-the-team {
	font-family: 'Roboto Condensed', sans-serif;
	text-align: left;
	color: black;
	font-weight: bold;
	font-size: 20px;
	align-content: center;
}

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
	margin-top: 20px;
	margin-bottom: 0px;
	background-color: white;
}

.backbutton {
	width: 87%;
    padding: 10px 10px;
    margin-top: 10px;  
}
</style>
<title>News Information</title>
</head>
<body style="background-color:#d9edf7">
	<div class="sec-container">
		<!-- <div style="height: 600px;" class="contant"> -->

		<div style="height: 180px;" class="contant">
			<h3 class="meet-the-team">News 1</h3>
			<h4>
				<span style="color: blue;">Source : </span>${newsobj.articles[0].source.name}<br>
			</h4>
			<h4>
				<span style="color: blue;">Title : </span>${newsobj.articles[0].title}<br>
			</h4>
			<h4>
				<span style="color: blue;">Content : </span>${newsobj.articles[0].description}</h4>
		</div>

		<div style="height: 180px;" class="contant">
			<h3 class="meet-the-team">News 2</h3>
			<h4>
				<span style="color: blue;">Source : </span>${newsobj.articles[1].source.name}<br>
			</h4>
			<h4>
				<span style="color: blue;">Title : </span>${newsobj.articles[1].title}<br>
			</h4>
			<h4>
				<span style="color: blue;">Content : </span>${newsobj.articles[1].description}</h4>
		</div>


		<div style="height: 180px;" class="contant">
			<h3 class="meet-the-team">News 3</h3>
			<h4>
				<span style="color: blue;">Source : </span>${newsobj.articles[2].source.name}<br>
			</h4>
			<h4>
				<span style="color: blue;">Title : </span>${newsobj.articles[2].title}<br>
			</h4>
			<h4>
				<span style="color: blue;">Content : </span>${newsobj.articles[2].description}</h4>
		</div>
		
		<div class="backbutton">
		<a href="/beep-bot-home"><button type="button"
			class="btn btn-warning">Back</button></a>
		</div>
		<!-- </div> -->
	</div>

</body>
</html>