<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="com.doctor_management_system.entity.Patient" %>
	
<html>
     <head>
          <title>Patient Home</title>
          <!-- All CDN's -->
          <jsp:include page="../common/common.jsp" />
     </head>

     <body>
          <%
          	Patient patient = (Patient)session.getAttribute("patient");
          	String patientName = patient.getName();
          %>
          
          <jsp:include page="../common/message.jsp"></jsp:include>
          
          <h1>Welcome <%=patientName %></h1>
     </body>

</html>