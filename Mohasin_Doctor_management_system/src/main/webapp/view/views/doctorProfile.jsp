<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.doctor_management_system.entity.Doctor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Profile</title>
<!-- All CDN's -->
<jsp:include page="../common/common.jsp" />


</head>
<body>

	<jsp:include page="../common/doctorNavbar.jsp"></jsp:include>

	<!-- dynamic message -->
	<div class="doctor-home-main">
	<jsp:include page="../common/message.jsp"></jsp:include>
	</div>
	

	<div class="container mt-3 mb-5">

		<%
		Doctor doctor = (Doctor) session.getAttribute("doctor");

		%>

		<div
			class="container w-75 border border-2 border-primary rounded p-3 shadow-lg bg-body-tertiary">
			<div class="position-relative">
				<h2 class="form-lable text-center">Doctor Profile</h2>
				<a href="/doctorHome" type="button"
					class="btn-close position-absolute end-0 top-0" aria-label="Close"></a>
			</div>

			<hr class="border border-primary opacity-75" />

			<form class="row g-3" action="/doctorProfileUpdate" method="post">

				<div hidden=true>
					<label for="doctorId" class="form-label">Id</label> <input
						type="text" class="form-control" id="doctorId" name="doctorId"
						value="<%=doctor.getId()%>" disabled>
				</div>

				<div class="col-md-12">
					<label for="doctorName" class="form-label">Name</label> <input
						type="text" class="form-control" id="doctorName" name="doctorName"
						value="<%=doctor.getName()%>" disabled>
				</div>

				<div class="col-md-6">
					<label for="doctorEmail" class="form-label">Email</label> <input
						type="email" class="form-control" id="doctorEmail"
						name="doctorEmail" value="<%=doctor.getEmail()%>" disabled>
				</div>
				<div class="col-md-6">
					<label for="doctorPassword" class="form-label">Password</label> <input
						type="text" class="form-control" name="doctorPassword"
						id="doctorPassword" value="<%=doctor.getPassword()%>" disabled>
				</div>


				<div class="col-md-6">
					<label for="doctorAvailability" class="form-label">Availability</label>
					<input type="text" class="form-control" id="doctorAvailability"
						name="doctorAvailability" value="<%=doctor.getAvailability()%>"
						disabled>
				</div>

				<div class="col-md-6">
					<label for="doctorSpecialty" class="form-label">Specialization</label>
					<input type="text" class="form-control" id="doctorSpecialty"
						name="doctorSpecialty" value="<%=doctor.getSpecialization()%>"
						disabled>
				</div>

				<div class="col-md-6">
					<label for="doctorMobile" class="form-label">Mobile No.</label> <input
						type="text" class="form-control" id="doctorMobile"
						name="doctorMobile" value="<%=doctor.getMobileNo()%>" disabled>
				</div>


				<div class="d-flex justify-content-evenly">
					<button id="editBtn" type="button" class="btn col-4 btn-primary"
						onClick="editDoctorDetails()">Edit</button>
					<button id="updateBtn" type="submit"
						class="btn col-4 btn-secondary" disabled>Update</button>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
	
		const inputFields = document.getElementsByTagName("input");
		const editBtn = document.getElementById("editBtn");
		const updateBtn = document.getElementById("updateBtn");
		
		const editDoctorDetails = ()=>{
			
			
			
			editBtn.classList.remove("btn-primary");
			editBtn.classList.add("btn-secondary");
			
			updateBtn.classList.remove("btn-secondary");
			updateBtn.classList.add("btn-primary");
			
			updateBtn.disabled=false;
			
			for(let i = 0; i<inputFields.length; i++){
				
				if(inputFields[i].name !== "doctorPassword")
				{
					inputFields[i].disabled=false;
				}
				
			}
			
		} 
	</script>

</body>
</html>