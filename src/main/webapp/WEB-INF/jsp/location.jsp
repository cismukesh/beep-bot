<!DOCTYPE html>
<%@page import="org.springframework.beans.factory.annotation.Value"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Location Information</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- google api key -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGWZq59wqQIvFnsmTJynyJf8_XTfYYJUY&sensor=false">
	
</script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">

<style>
#myMap {
	height: 350px;
	width: 680px;
}

.meet-the-team{
	font-family: 'Roboto Condensed', sans-serif;
   	text-align: center;
    color: black;
    font-weight: bold;
    font-size: 20px;
    align-content: center;
}

.label-font{
	/*text-align: center;*/
	font-size: 15px;
	color: black;
	font-family: 'Roboto Condensed', sans-serif;
	
}

.sec-container {
	display: flex;
	justify-content: space-evenly;
	background-color: #d9edf7;
	/* #efeeee, #d9edf7  */
	align-items: center;
	flex-wrap: wrap;
}

.w3-allerta {
  font-family: "Allerta Stencil", Sans-serif;
}
</style>
<script type="text/javascript">
	var map;
	var marker;
	var myLatlng = new google.maps.LatLng(22.754221317920024, 75.86651623648368);
	var geocoder = new google.maps.Geocoder();
	var infowindow = new google.maps.InfoWindow();
	function initialize() {
		var mapOptions = {
			zoom : 18,
			center : myLatlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		map = new google.maps.Map(document.getElementById("myMap"), mapOptions);

		marker = new google.maps.Marker({
			map : map,
			position : myLatlng,
			draggable : true
		});

		geocoder.geocode({
			'latLng' : myLatlng
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					$('#latitude,#longitude').show();
					$('#address').val(results[0].formatted_address);
					$('#latitude').val(marker.getPosition().lat());
					$('#longitude').val(marker.getPosition().lng());
					infowindow.setContent(results[0].formatted_address);
					infowindow.open(map, marker);
				}
			}
		});

		google.maps.event.addListener(marker, 'dragend', function() {

			geocoder.geocode({
				'latLng' : marker.getPosition()
			}, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					if (results[0]) {
						$('#address').val(results[0].formatted_address);
						$('#latitude').val(marker.getPosition().lat());
						$('#longitude').val(marker.getPosition().lng());
						infowindow.setContent(results[0].formatted_address);
						infowindow.open(map, marker);
					}
				}
			});
		});

	}
	google.maps.event.addDomListener(window, 'load', initialize);
	
	$(function() {
		$('.alert-danger').delay(5000).show().fadeOut('slow');
	})
</script>

</head>
<body style="background-color:#d9edf7">
	<div class="w3-container w3-teal">
  		<div class="w3-container w3-center w3-allerta">
  		<!-- <h1 class="w3-jumbo" style="text-align: center">Beep Bot</h1> -->
		<p class="w3-xxxlarge">Beep Bot</p>
		</div>
	</div>
	<div class="sec-container">
	<div align="center" class="container">
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
		<div
			style="background-color: #d9edf7; width: 400px; text-align: center;"
			class="contant">
			<h4 class="meet-the-team">Pick-Up
				Location on Google-Map</h4>
			<div id="myMap" style="width: 400px; height: 250px;"></div>
			<div class="formdiv" style="margin: opx;">
				<form action="/show-user-info" method="post">
					<div class="form-group">
						<label class="label-font" for="name">Name</label> <input style="width: 400px;"
							type="text" class="form-control" id="name" name="name"
							required="required" />
					</div>
					<div class="form-group">
						<label class="label-font" for="location">Location</label> <input id="address"
							name="address" class="form-control" type="text"
							style="width: 400px;" required="required" /><br />
					</div>
					<div class="form-group">
						<label class="label-font" for="location">Latitude</label> <input type="text"
							name="latitude" class="form-control" id="latitude"
							style="width: 400px;" placeholder="Latitude" /><br />
					</div>
					<div class="form-group">
						<label class="label-font" for="location">Longitude</label> <input type="text"
							name="longitude" class="form-control" id="longitude"
							style="width: 400px;" placeholder="Longitude" />
					</div>
					<p align="center">
						<button style="margin: auto; background-color: #5bc0de; color: white ;display: block" type="submit"
							class="btn ">Submit</button>
					</p>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>