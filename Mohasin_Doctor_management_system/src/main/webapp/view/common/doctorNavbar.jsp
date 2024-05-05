<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>

<style>

.d-spec {
	cursor: grab;
}

.c-link:hover {
	font-size: 21px;
	background-color: #3b8bf9;
	border-radius: 20px;
}

.main{
    margin-top:120px;
}

.doctor-home-main {
	margin-top:90px;
}
</style>

</head>

<body>
	
		<nav class="navbar bg-primary navbar-expand-lg fixed-top" data-bs-theme="dark">
		<div class="container-fluid">

			<a class="c-link fs-2 navbar-brand p-2" href="/doctorHome"><%=session.getAttribute("doctorFirstName") %></a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse fs-5"
				id="navbarSupportedContent">

				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

					<li class="nav-item pe-3"><a class="c-link nav-link active"
						aria-current="page" href="/doctorHome">Home</a></li>
					<li class="nav-item pe-3"><a class="c-link nav-link active"
						aria-current="page" href="#">Add Appointment</a></li>
					<li class="nav-item pe-3"><a class="c-link nav-link active"
						aria-current="page" href="#">View Appointment</a></li>

					<li class="nav-item pe-3"><a class="c-link nav-link active"
						aria-current="page" href="/doctorProfile">Profile</a></li>

					<li class="nav-item pe-3">
						<button type="button" class="btn btn-lg btn-danger" data-bs-toggle="modal"
							data-bs-target="#exampleModal">Logout</button>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Logout Modal -->

	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Logout</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <strong>Are you sure, you want to logout?</strong>
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <a href="/logout" type="button" class="btn btn-danger">Logout</a>
      </div>
    </div>
  </div>
</div>
  </body>
</body>
</html>



