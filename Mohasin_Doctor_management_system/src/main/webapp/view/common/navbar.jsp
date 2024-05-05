<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 

<%@ page import="com.doctor_management_system.service.DoctorDao" %>
<%@ page import="com.doctor_management_system.entity.*" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.*" %>

<%
  ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
  DoctorDao doctorDao = context.getBean(DoctorDao.class);

  Set<String> doctorList = doctorDao.getAllDoctorSpecialization();
 
%>

<style>
	.d-spec{
		cursor:grab;
	}
	
	.c-link:hover{
		font-weight:bold;
		background-color:#3b8bf9;
		border-radius:20px;
	}
</style>

<nav class="navbar bg-primary navbar-expand-lg fixed-top" data-bs-theme="dark">

  <div class="container-fluid">

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <a class="c-link fs-2 navbar-brand me-auto p-2" href="/home">DocX</a>

    <div class="collapse navbar-collapse fs-5" id="navbarSupportedContent">

      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

        <li class="nav-item pe-2">
          <a class="c-link nav-link active" aria-current="page" href="/home">Home</a>
        </li>

        <li class="nav-item dropdown pe-2">

          <a class="c-link nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Specialization
          </a>
		
        <%-- Add the doctor specialization here --%>
          <ul class="dropdown-menu pe-2 bg-primary">
            <% 
            	for(String specialization : doctorList) {	 
            %>

            <li class="d-spec dropdown-item"><%=specialization %></li>
	         
	        <% 
              }
            %>
          </ul>

        </li>

        <%-- Doctor Modal --%>
        <li class="nav-item pe-2">
          <a class="c-link nav-link active" href="#" data-toggle="modal" data-target="#doctorModal">Doctor</a>
        </li>

        <%-- Add the modal for patient login and registration here --%>
        <li class="nav-item pe-2">
          <a class="c-link nav-link active" href="#" data-toggle="modal" data-target="#patientModal">Patient</a>
        </li>

        <%-- Add the about page or help page with the app detail --%>
        <li class="nav-item pe-2">
          <a class="c-link nav-link active" href="#" data-toggle="modal" data-target="#helpModal">Help</a>
        </li>

      </ul>
    </div>
  </div>
</nav>

<%--#######################################################################################
                                DOCTOR MODAL
###########################################################################################  --%>

<div class="modal fade" id="doctorModal" tabindex="-1" role="dialog" aria-labelledby="doctorModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="doctorModalLabel">Doctor</h5>
      </div>
      <div class="modal-body d-flex flex-row justify-content-evenly align-items-center">
        <a href="/doctorLogin" class="btn btn-primary btn-lg">Login</a>
        <a href="/doctorRegistration" class="btn btn-primary btn-lg">Register</a>
      </div>
    </div>
  </div>
</div>


<%--#######################################################################################
                                PATIENT MODAL
###########################################################################################  --%>
<div class="modal fade" id="patientModal" tabindex="-1" role="dialog" aria-labelledby="doctorModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="doctorModalLabel">Patient</h5>
      </div>
      <div class="modal-body d-flex flex-row justify-content-evenly align-items-center">
        <a href="/patientLogin" class="btn btn-primary btn-lg">Login</a>
        <a href="/patientRegistration" class="btn btn-primary btn-lg">Register</a>
      </div>
    </div>
  </div>
</div>

<%--#######################################################################################
                                HELP MODAL
###########################################################################################  --%>
<div class="modal fade" id="helpModal" tabindex="-1" role="dialog" aria-labelledby="doctorModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="doctorModalLabel">Help</h5>
      </div>
      <div>
        <p>This is testing paragraph for help modal</p>
      </div>
    </div>
  </div>
</div>