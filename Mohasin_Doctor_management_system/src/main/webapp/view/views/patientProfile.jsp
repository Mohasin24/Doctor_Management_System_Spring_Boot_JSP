<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.doctor_management_system.entity.Patient"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Profile</title>
<!-- All CDN's -->
<jsp:include page="../common/common.jsp" />
</head>
<body>

	<jsp:include page="../common/patientNavbar.jsp"></jsp:include>

	<!-- dynamic message -->
	<div class="patient-home-main">
	<jsp:include page="../common/message.jsp"></jsp:include>
	</div>

	<div class="container mt-3 mb-5">

		<%
		Patient patient = (Patient) session.getAttribute("patient");

		%>

		<div
			class="container w-75 border border-2 border-primary rounded p-3 shadow-lg bg-body-tertiary">
			<div class="position-relative">
				<h2 class="form-lable text-center">Patient Profile</h2>
				<a href="/patientHome" type="button"
					class="btn-close position-absolute end-0 top-0" aria-label="Close"></a>
			</div>

			<hr class="border border-primary opacity-75" />

			<form class="row g-3" action="/patientProfileUpdate" method="post">

				<div hidden=true>
					<label for="patientId" class="form-label">Id</label> <input
						type="text" class="form-control" id="patientId" name="patientId"
						value="<%=patient.getId()%>">
				</div>

				<div class="col-md-12">
					<label for="patientName" class="form-label">Name</label> <input
						type="text" class="form-control" id="patientName" name="patientName"
						value="<%=patient.getName()%>" disabled>
				</div>

				<div class="col-md-6">
					<label for="patientEmail" class="form-label">Email</label> <input
						type="email" class="form-control" id="patientEmail"
						name="patientEmail" value="<%=patient.getEmail()%>" disabled>
				</div>
				<div class="col-md-6">
					<label for="patientPassword" class="form-label">Password</label> <input
						type="text" class="form-control" name="patientPassword"
						id="patientPassword" value="<%=patient.getPassword()%>" disabled>
				</div>


				<div class="col-md-6">
					<label for="patientGender" class="form-label">Gender</label>
					<input type="text" class="form-control" id="patientGender"
						name="patientGender" value="<%=patient.getGender()%>"
						disabled>
				</div>


				<div class="col-md-6">
					<label for="patientMobile" class="form-label">Mobile No.</label> <input
						type="text" class="form-control" id="patientMobile"
						name="patientMobile" value="<%=patient.getMobileNo()%>" disabled>
				</div>


				<div class="d-flex justify-content-evenly">
					<button id="editBtn" type="button" class="btn col-4 btn-primary"
						onClick="editpatientDetails()">Edit</button>
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
		
		const editpatientDetails = ()=>{
			
			
			
			editBtn.classList.remove("btn-primary");
			editBtn.classList.add("btn-secondary");
			
			updateBtn.classList.remove("btn-secondary");
			updateBtn.classList.add("btn-primary");
			
			updateBtn.disabled=false;
			
			for(let i = 0; i<inputFields.length; i++){
				
				if(inputFields[i].name !== "patientPassword" && inputFields[i].name !== "patientGender")
				{
					inputFields[i].disabled=false;
				}
				
			}
			
		} 
	</script>
</body>
</html>