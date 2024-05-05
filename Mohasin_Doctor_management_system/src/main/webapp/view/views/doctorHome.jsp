<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.doctor_management_system.entity.Doctor"%>
<html>
<head>
<title>Doctor Home</title>
<!-- All CDN's -->
<jsp:include page="../common/common.jsp" />

</head>

<body class="h-100">
	<jsp:include page="../common/doctorNavbar.jsp"></jsp:include>

	<!-- dynamic message -->
	<div class="doctor-home-main">
		<jsp:include page="../common/message.jsp"></jsp:include>
	</div>
	
	<div class="h-75 d-flex flex-row justify-content-center align-items-center">
               <h1 class="bg-primary-subtle text-success p-4 rounded">Dr. <%=session.getAttribute("doctorFirstName") %></h1>
          </div>

</body>

</html>