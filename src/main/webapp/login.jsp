<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Hommie - Where you find your best roommie</title>
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
<script src="lib/md5/md5.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/blueimp-md5/2.18.0/js/md5.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>

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
			<div class="row gx-0 justify-content-between p-3">
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
											href="logout" class="dropdown-item">Logout</a> <a
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


		<!-- Page Header Start -->
		<div class="container-fluid page-header mb-5 p-0"
			style="background-image: url(https://i.pinimg.com/236x/09/80/52/09805251e8b42816ec721609d0e1c263.jpg);">
			<div class="container-fluid page-header-inner py-5">
				<div class="container text-center pb-5">
					<h1 class="display-3 text-white mb-3 animated slideInDown">Login</h1>
				</div>
			</div>
		</div>
		<!-- Page Header End -->


		<!-- Login Start -->

		<c:if test="${not empty errorMessage}">
			<p
				style="color: red; font-weight: bold; text-align: center; margin-top: 20px;">${errorMessage}</p>
		</c:if>

	</div>

	<div class="container-xxl py-5 w-50">
		<div class="container">
			<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
				<h1 class="mb-5">
					<span class="text-primary text-uppercase">Login</span> To Explore
					Our Services
				</h1>
			</div>
			<div class="center-form">
				<script>
					function encryptThenSubmitForm() {
					    var password = document.getElementById("password").value;
					    var encryptedPassword = md5(password);
					    document.getElementById("password").value = encryptedPassword;
					    var form = document.getElementById("loginForm");
						form.submit();
					}
				</script>

				<form action ="login" id="loginForm" method="post" style="align-content: center">
					<div class="col-md-6 w-100">
						<div class="form-floating">
							<input type="email" name="email" value="${param.email}"
								class="form-control" id="email" placeholder="email"> <label
								for="email"><i class="fa fa-user-circle m-2"
								aria-hidden="true"></i>Email</label>
						</div>
					</div>
					<br>
					<div class="col-md-6 w-100">
						<div class="form-floating">
							<input type="password" name="password" value="${param.password}"
								class="form-control" id="password" placeholder="password">
							<label for="password"><i class="fa fa-key m-2"
								aria-hidden="true"></i>Password</label>
						</div>
					</div>
					<br>
					<div class="col-md-6 w-100">
						<button class="btn btn-primary w-100 py-3" type="submit"
							onClick="encryptThenSubmitForm()">Login</button>
					</div>
				</form>

				<br>
				<h5>
					Don't have an account? Click <a href="register.jsp">
						here </a> to register
				</h5>
			</div>
			
			
		</div>
	</div>

	<!-- Login End -->


	<!-- Newsletter Start -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- Newsletter Start -->


	<!-- Footer Start -->
	<div class="container-fluid bg-dark text-light footer wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container pb-5">
			<div class="row g-5">
				<div class="col-md-6 col-lg-4">
					<div class="bg-primary rounded p-4">
						<a href="index.html"><h1
								class="text-white text-uppercase mb-3">Hommie</h1></a>
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
						<i class="fa fa-envelope me-3"></i>info@hommie.com.au
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
							<a class="btn btn-link" href="">Landlords</a> <a
								class="btn btn-link" href="">Students</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="copyright">
				<div class="row">
					<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
						&copy; <a class="border-bottom" href="#">Hommie Australia</a>, All
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
	</div>


</body>

</html>