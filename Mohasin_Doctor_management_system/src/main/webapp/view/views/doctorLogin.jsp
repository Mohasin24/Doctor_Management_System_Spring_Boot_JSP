<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Doctor Login</title>

<!-- All CDN's -->
<jsp:include page="../common/common.jsp" />


<%-- Common content from the home page --%>
<jsp:include page="../common/commonHome.jsp" />

</head>
<body>
	<div class="outer">
		<div class="inner">
			<jsp:include page="../common/message.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="container-fluid main">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h1 class="text-center">Doctor Login</h1>
					</div>
					<div class="card-body">
						<%-- Add message here --%>
						<%-- Form  --%>
						<form id="loginForm" action="/validate-doctorLogin" method="post">
							<div class="form-group mb-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="Enter email" required>
							</div>
							<div class="form-group mb-3">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Enter password" required>
							</div>
							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
