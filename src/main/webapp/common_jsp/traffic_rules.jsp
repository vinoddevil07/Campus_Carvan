<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Traffic Rules</title>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<%@include file="/common/common_header.html"%>



   

	<div class="container mt-5">
		<h1 class="text-center mb-4">Indian Traffic Rules</h1>

		<!-- Example traffic rules -->
		<div class="rule">
			<h3>Wearing Seat Belts</h3>
			<p>It is mandatory for all occupants of a vehicle to wear seat
				belts while the vehicle is in motion.</p>
		</div>

		<div class="rule">
			<h3>Using Helmets</h3>
			<p>Motorcycle riders and pillion riders must wear helmets
				conforming to the standards prescribed by the Bureau of Indian
				Standards.</p>
		</div>

		<div class="rule">
			<h3>Obeying Traffic Signals</h3>
			<p>Drivers must obey traffic signals, including red lights, green
				lights, and other traffic control devices.</p>
		</div>




	</div>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Indian Traffic Signal Signs</h1>


		<div class="traffic-signal">
			<h3>Red Signal</h3>
			<img src="/CampusCarvan/images/red.jpeg" alt="Red Signal"
				style="height: 5%; width: 5%">
			<p>This signal indicates to stop. All vehicles must come to a
				complete halt.</p>
		</div>

		<div class="traffic-signal">
			<h3>Green Signal</h3>
			<img src="/CampusCarvan/images/green.jpeg" alt="Green Signal"
				style="height: 5%; width: 5%">
			<p>This signal indicates to proceed. Vehicles can move forward.</p>
		</div>

		<div class="traffic-signal">
			<h3>Yellow Signal</h3>
			<img src="/CampusCarvan/images/yellow.jpeg" alt="Yellow Signal"
				style="height: 5%; width: 5%">
			<p>This signal indicates to prepare to stop. Vehicles should slow
				down and stop if it is safe to do so.</p>
		</div>

	</div>


	<%@include file="/common/common_footer.html"%>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>