<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Hommie - Find roomate App</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&family=Montserrat:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<!-- Image template from W3.school-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
/* Add custom styles here */
.carousel {
	max-width: 500px; /* Adjust the maximum width as desired */
	margin: auto;
}

.carousel-inner .item img {
	max-height: 500px; /* Adjust the maximum height as desired */
	width: auto;
	margin: 0 auto;
}
</style>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/tempusdominus/js/moment.min.js"></script>
<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>

<!-- Image template from w3-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>
	<div class="container-xxl bg-white p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->

		<!-- Header Start -->
		<div class="container-fluid bg-dark px-0">
			<div class="row gx-0 justify-content-between p-4">
				<div class="col-lg-3 bg-dark d-none d-lg-block">
					<a href="home"
						class="navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center">
						<h1 class="m-0 text-primary text-uppercase">Hommie</h1>
					</a>
				</div>
				<div class="col-lg-5 px-5 text-end">
					<nav class="navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0">
						<a href="home" class="navbar-brand d-block d-lg-none">
							<h1 class="m-0 text-primary text-uppercase">Hommie</h1>
						</a>
						<button type="button" class="navbar-toggler"
							data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse justify-content-between"
							id="navbarCollapse">
							<div class="navbar-nav mr-auto py-0">
								<a href="home" class="nav-item nav-link active">Home</a> <a
									href="roomList" class="nav-item nav-link">Rooms</a> <a
									href="login.jsp" class="nav-item nav-link">Landlord</a>
								<div class="nav-item dropdown">
									<a href="#" class="nav-link dropdown-toggle"
										data-bs-toggle="dropdown">Account</a>
									<div class="dropdown-menu rounded-0 m-0">
										<a href="register.jsp" class="dropdown-item">Register</a> <a
											href="login.jsp" class="dropdown-item">Login</a> <a
											href="logout.jsp" class="dropdown-item">Logout</a> <a
											href="wish-list.jsp" class="dropdown-item">Wish-list</a>
									</div>
								</div>
							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<!-- Header End -->


		<!-- Room Image Start -->

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 d-flex align-items-center justify-content-center" style="background-color: rgb(240, 244, 248);">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img class="img-fluid" src="${room.image1Url}"
									style="width: 100%;">
							</div>

							<div class="item">
								<img class="img-fluid  src="${room.image2Url}"
									style="width: 100%;">
							</div>

							<div class="item">
								<img class="img-fluid" src="${room.image3Url}"
									style="width: 100%;">
							</div>

						</div>
						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
				<div class="col-sm-6" style="background-color: rgb(240, 244, 248);">
					<div class="d-flex justify-content-between mb-3">
						<h3 class="mb-0">${room.address}
							<br>${room.state} ${room.postcode}
						</h3>

						<div class="ps-2"></div>
					</div>
					<div class="d-flex mb-3">
						<small class="border-end me-3 pe-3"><i
							class="fa fa-bed text-primary me-2"></i>${room.countBed} Bed</small> <small
							class="border-end me-3 pe-3"><i
							class="fa fa-bath text-primary me-2"></i>${room.countBath} Bath</small> <small><i
							class="fa fa-wifi text-primary me-2"></i>Wifi</small>
					</div>
					<div>
						<h4>
							<strong>$${room.price} Weekly</strong>
						</h4>
						<p>
							<strong>Bond </strong>$${room.bond}
						</p>
						<p>
							<strong>Available </strong>${room.availableDate}
						</p>
					</div>
					<div data-wow-delay="0.1s">
						<iframe class="position-relative rounded w-100 h-100"
							src="${room.mapUrl}"
							frameborder="0" style="min-height: 350px; border: 0;"
							allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
					</div>
				</div>
			</div>
		</div>

		<!-- Room Image End -->


		<!-- Booking Start -->
		<div class="container-xxl py-5">
			<div class="container">
				<div class="text-center wow fadeInUp pb-5" data-wow-delay="0.1s">
					<h1 class="mb-5">
						Get In Touch, <span class="text-primary text-uppercase">Hommie</span>
					</h1>
				</div>
				<div class="row g-5">
					<div class="col-lg-6">
						<div class="row g-3">
							<h3>${room.title}</h3>
							<p>${room.description}</p>
							<h3>Property features</h3>
							<p>Room size: ${room.squareArea} m2</p>
							<p>Suitable for ${room.capacity} person(s)</p>


						</div>
					</div>
					<div class="col-lg-6">
						<div class="wow fadeInUp" data-wow-delay="0.2s">
							<form action="">
								<div class="row g-3">
									<h3 class="text-center">Book your inspection</h3>
									<div class="col-6">
										<div class="form-floating">
											<input type="text" class="form-control" id="name"
												placeholder="Your Name"> <label for="name">Your
												Name</label>
										</div>
									</div>
									<div class="col-6">
										<div class="form-floating">
											<input type="email" class="form-control" id="email"
												placeholder="Your Email"> <label for="email">Your
												Email</label>
										</div>
									</div>
									<div class="col-6">
										<div class="form-floating date" id="date3">
											<input type="text" class="form-control datetimepicker-input"
												id="checkin" placeholder="Move In" data-target="#date3"
												data-toggle="datetimepicker" /> <label for="checkin">Contact
												Number</label>
										</div>
									</div>
									<div class="col-6">
										<div class="form-floating date" id="date4"
											data-target-input="nearest">
											<input type="text" class="form-control datetimepicker-input"
												id="checkout" placeholder="Check Out" data-target="#date4"
												data-toggle="datetimepicker" /> <label for="checkout">Available
												Date</label>
										</div>
									</div>
									<div class="col-12">
										<div class="form-floating">
											<select class="form-select" id="select3">
												<option value="1">Length of lease</option>
												<option value="2">Arrange private inspection</option>
												<option value="3">Rental application</option>
											</select> <label for="select3">What's your enquiry about?</label>
										</div>
									</div>
									<div class="col-12">
										<div class="form-floating">
											<textarea class="form-control" placeholder="Special Request"
												id="message" style="height: 100px"></textarea>
											<label for="message">Message</label>
										</div>
									</div>
									<div class="col-12">
										<button class="btn btn-primary w-100 py-3" type="submit">Send</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Booking End -->
		<br>
		<br>

		<!-- Footer Start -->
		<div
			class="container-fluid bg-dark text-light footer wow fadeIn mt-lg-5"
			data-wow-delay="0.1s">
			<div class="container pb-5">
				<div class="row g-5">
					<div class="col-md-6 col-lg-4">
						<div class="bg-primary rounded p-4">
							<a href="index.html"><h1
									class="text-white text-uppercase mb-3">Hotelier</h1></a>
							<p class="text-white mb-0">
								Download <a class="text-dark fw-medium"
									href="https://htmlcodex.com/hotel-html-template-pro">Hommie</a>,
								ultimate platform for students in search of their ideal living
								companion. Find harmony in shared living and unlock the doors to
								lifelong friendships.
							</p>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<h6
							class="section-title text-start text-primary text-uppercase mb-4">Contact</h6>
						<p class="mb-2">
							<i class="fa fa-map-marker-alt me-3"></i>123 Beauty Street,
							Sydney, NSW
						</p>
						<p class="mb-2">
							<i class="fa fa-phone-alt me-3"></i>+61 2 8123 4567
						</p>
						<p class="mb-2">
							<i class="fa fa-envelope me-3"></i>info@hommie.com
						</p>
						<div class="d-flex pt-2">
							<a class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-twitter"></i></a> <a
								class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-facebook-f"></i></a> <a
								class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-youtube"></i></a> <a
								class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-linkedin-in"></i></a>
						</div>
					</div>
					<div class="col-lg-5 col-md-12">
						<div class="row gy-5 g-4">
							<div class="col-md-6">
								<h6
									class="section-title text-start text-primary text-uppercase mb-4">Company</h6>
								<a class="btn btn-link" href="">About Us</a> <a
									class="btn btn-link" href="">Contact Us</a> <a
									class="btn btn-link" href="">Privacy Policy</a> <a
									class="btn btn-link" href="">Terms & Condition</a> <a
									class="btn btn-link" href="">Support</a>
							</div>
							<div class="col-md-6">
								<h6
									class="section-title text-start text-primary text-uppercase mb-4">Services</h6>
								<a class="btn btn-link" href="">Food & Restaurant</a> <a
									class="btn btn-link" href="">Spa & Fitness</a> <a
									class="btn btn-link" href="">Sports & Gaming</a> <a
									class="btn btn-link" href="">Event & Party</a> <a
									class="btn btn-link" href="">GYM & Yoga</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="copyright">
					<div class="row">
						<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
							&copy; <a class="border-bottom" href="#">Your Site Name</a>, All
							Right Reserved.

							<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
							Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML
								Codex</a>
						</div>
						<div class="col-md-6 text-center text-md-end">
							<div class="footer-menu">
								<a href="">Home</a> <a href="">Cookies</a> <a href="">Help</a> <a
									href="">FQAs</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer End -->


		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>