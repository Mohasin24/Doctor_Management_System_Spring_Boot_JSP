<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.doctor_management_system.entity.Patient"%>

<html>
<head>
<title>Patient Home</title>
<!-- All CDN's -->
<jsp:include page="../common/common.jsp" />

</head>

<body>
	<jsp:include page="../common/patientNavbar.jsp"></jsp:include>
	<!-- dynamic message -->
	<div class="patient-home-main">
	<jsp:include page="../common/message.jsp"></jsp:include>	
	</div>
	
	<div class="h-75 d-flex flex-row justify-content-center align-items-center">
               <h1 class="bg-primary-subtle text-success p-4 rounded">Welcome <%=session.getAttribute("patientFirstName") %></h1>
          </div>
	
</body>

</html>