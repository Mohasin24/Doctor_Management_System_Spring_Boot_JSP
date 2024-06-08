<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.doctor_management_system.entity.Patient"%>
<%@ page import="com.doctor_management_system.entity.Doctor"%>
<%@ page import=" com.doctor_management_system.service.DoctorDao"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Appointment Patient</title>
<jsp:include page="../common/common.jsp"></jsp:include>
</head>
<body>

	<%
	Patient patient = (Patient) session.getAttribute("patient");

	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
	DoctorDao doctorDao = context.getBean(DoctorDao.class);

	List<Doctor> list = doctorDao.getAllDoctors();
	Set<String> specializationList = doctorDao.getAllDoctorSpecialization();

	String[] genderOptions = {"Male","Female","Other"};
	%>

	<jsp:include page="../common/patientNavbar.jsp"></jsp:include>

	<!-- dynamic message -->
	<div class="patient-home-main">
		<jsp:include page="../common/message.jsp"></jsp:include>
	</div>

	<div class="container mt-3 mb-5">

		<div
			class="container w-75 border border-2 border-primary rounded p-3 shadow-lg bg-body-tertiary">
			<div class="position-relative">
				<h2 class="form-lable text-center">Add Appointment</h2>
				<a href="" type="button"
					class="btn-close position-absolute end-0 top-0" aria-label="Close"></a>
			</div>

			<hr class="border border-primary opacity-75" />

<%-- ##################################################################################### 
								Appointment Form
##################################################################################### --%>
			<form class="row g-3" id="appointmentForm" action="#">

				<div hidden=true>
					<label for="patientId" class="form-label">Id</label> <input
						type="text" class="form-control" id="patientId" name="patientId"
						value="<%=patient.getId()%>" required>
				</div>

				<div class="col-md-12">
					<label for="patientName" class="form-label">Name</label> <input
						type="text" class="form-control" id="patientName"
						name="patientName" value="<%=patient.getName()%>" required>
				</div>

				<div class="col-md-6">
					<label for="patientEmail" class="form-label">Email</label> <input
						type="email" class="form-control" id="patientEmail"
						name="patientEmail" value="<%=patient.getEmail()%>" required>
				</div>



				<div class="col-md-6">
					<label for="patientGender" class="form-label">Gender</label>

						<select id="patientGender" class="form-select">
							<option disabled>Choose...</option>
							
							<%
								for(String gen : genderOptions)
								{
									if(gen.equals(patient.getGender())){

									
							%>

								<option selected><%=gen%></option>
							<%	
							}else
							{
							%>
								<option><%=gen%></option>		
								<%
							}								
								}
							%>	

						</select>
				</div>


				<div class="col-md-6">
					<label for="patientMobile" class="form-label">Mobile No.</label> <input
						type="text" class="form-control" id="patientMobile"
						name="patientMobile" value="<%=patient.getMobileNo()%>" required>
				</div>

				<div class="col-md-6">
					<label for="patientMobile" class="form-label">Appointment
						Date</label> <input type="date" class="form-control" id="appointmentDate"
						name="appointmentDate" required>
				</div>

				<div class="col-md-6">
					<label for="patientMobile" class="form-label">Select Doctor</label>
					<select id="doctorSpecialization" class="form-select">
						<option selected disabled>Choose...</option>
						<%
						for (Doctor doctor : list) {
						%>
						<option value="<%=doctor.getId()%>" data-avalability="<%=doctor.getAvailability()%>" required>
							<%=doctor.getName()%> ||
							<%=doctor.getSpecialization()%>
						</option>
						<%
						}
						%>
					</select>
				</div>


				<div id="doctorAvalability" class="col-md-6" style="display: none">
					<label for="doctorAvalabilityText" class="form-label">Doctor
						Availability</label> 
						<input type="text" id="doctorAvalabilityText" class="form-control" disabled required>
				</div>

				<div class="d-flex justify-content-evenly">
					<button id="editBtn" type="submit" class="btn col-4 btn-primary">Add
						Appointment</button>
				</div>
			</form>
			
<%-- ##################################################################################### 
								Appointment Form End
##################################################################################### --%>
		</div>
	</div>


	<script type="text/javascript">

		const appointmentForm = document.getElementById("appointmentForm")
		const doctorSpecialization = document.getElementById("doctorSpecialization")
		const doctorAvalability = document.getElementById("doctorAvalability")
		const doctorAvalabilityText = document.getElementById("doctorAvalabilityText")

		let index=0;

		doctorSpecialization.addEventListener('change',()=>{
			index = doctorSpecialization.options.selectedIndex
			let availability = doctorSpecialization.options[index].dataset.avalability
				doctorAvalabilityText.value = availability
				doctorAvalability.style.display="block"
		})

		appointmentForm.addEventListener('submit', (event)=>{

			if(index===0){
				event.preventDefault();
				alert("Please select the doctor!")
			}
		})
		
	</script>
</body>
</html>

