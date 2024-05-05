<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Patient Registration</title>
    <!-- All CDN's -->
          <jsp:include page="../common/common.jsp" />
    <%-- Common content from the home page --%>
    <jsp:include page="../common/commonHome.jsp" />
</head>
<body>
    <div class="outer">
		<div class="inner">
			<!-- Dynamic Message -->
			<jsp:include page="../common/message.jsp"></jsp:include>
		</div>
	</div>
    <div class="container main">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h1 class="text-center">Patient Registration</h1>
                    </div>
                    <div class="card-body">
                        <%-- Add message here --%>
                        <%-- Form --%>
                        <form id="registrationForm" action="/validate-patientRegistration" method="post">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="patientName" name="patientName" placeholder="Name" required>
                            </div>
                            <div class="mb-3">
                                <input type="email" class="form-control" id="patientEmail" name="patientEmail" placeholder="Email" required>
                            </div>
                            <div class="mb-3">
                                <input type="tel" class="form-control" id="patientMobile" name="patientMobile" placeholder="Mobile Number" required>
                            </div>
                            <div class="mb-3">
                                <select class="form-control" id="patientGender" name="patientGender" required>
                                    <option value="">Select Gender</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="Other">Other</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" id="patientPassword" name="patientPassword" placeholder="Enter password" required>
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" id="confirmPatientPassword" name="confirmPatientPassword" placeholder="Confirm Password" required>

                                <p id="passwordMessage" class="text-danger ps-1"></p>   

                            </div>
                            <div class="d-grid">
                                <button type="submit" onClick="submitForm(event)" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>



<%--########################################################################################### 
                            Javascript Logic
###########################################################################################--%>
<script type="text/javascript">
        const patientPassword = document.getElementById("patientPassword")
        const confirmPatientPassword = document.getElementById("confirmPatientPassword")
        const passwordMessage = document.getElementById("passwordMessage")

        const submitForm = (event) => {
            
        if (patientPassword.value !== confirmPatientPassword.value) {

            passwordMessage.textContent = "Password does not match";
            event.preventDefault();
       
        } else {
            passwordMessage.style.display = "hidden";
            document.getElementById("registrationForm").submit()
            alert("Registration Successful! Please login.")
        }
    };
    </script>


</body>
</html>
