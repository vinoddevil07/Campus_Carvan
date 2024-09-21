<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ApplyDrivingLicence</title>
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

	<div class="row">

		<div class="col-2"></div>

		<div class="col-8">

			<div class="container mt-5">
				<h1 class="text-center" style="margin-bottom: 2%; color: red">Steps
					to Obtain a New Driving Licence</h1>
				<ol>
					<li><strong>Visit the Website:</strong> Access <a
						href="https://sarathi.parivahan.gov.in/">sarathi.parivahan.gov.in</a>
						using your web browser.</li>
					<li><strong>Select Your State:</strong> Choose your state from
						the options provided on the website.</li>
					<li><strong>Navigate to New Driving Licence Section:</strong>
						Click on "Driving Licence" and select "New Driving Licence".</li>
					<li><strong>Enter Details:</strong> Provide your Learning
						Licence Number and Date of Birth as required.</li>
					<li><strong>Fill Application Form:</strong> Complete the
						application form with accurate information.</li>
					<li><strong>Submit Application:</strong> Click "Next" after
						filling the form to proceed.</li>
					<li><strong>Visit RTO:</strong> Upon successful submission,
						you'll receive information on visiting the Regional Transport
						Office (RTO) with:
					<ul>
						<li><strong>Original documents:</strong> identity, address,
							and age proofs as specified.</li>
						<li><strong>Fee Slip:</strong> Carry the fee slip for
							payment.</li>
					</ul></li>
					<li><strong>Verification and Test:</strong> At the RTO, your
						documents will be verified, and you may undergo a driving test or
						written exam.</li>
					<li><strong>Photograph and Biometric Data:</strong> Provide
						necessary photographs and biometric data for processing.</li>
					<li><strong>Issue of Driving Licence:</strong> If requirements
						are met and tests passed, your new license will be issued.</li>
					<li><strong>Receive Your Driving Licence:</strong> Upon
						approval, you'll receive your license immediately or via postal
						mail.</li>
					<li><strong>Check for Validity:</strong> Verify the validity
						period and other details on your new driving license.</li>
				</ol>
			</div>

		</div>
		<div class="col-2"></div>


	</div>

	<%@include file="/common/common_footer.html"%>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>