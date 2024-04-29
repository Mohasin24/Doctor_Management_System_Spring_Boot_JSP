<html>
<head>
    <title>Doctor Registration</title>
    <%-- Common content from the home page --%>
    <jsp:include page="../common/commonHome.jsp" />

    

</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h1 class="text-center">Doctor Registration</h1>
                    </div>
                    <div class="card-body">
                        <%-- Add message here --%>
                        <%-- Form --%>
                        <form id="registrationForm" action="/validate-doctorRegistration" method="post">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="name" name="doctorName" placeholder="Name" required>
                            </div>
                            <div class="mb-3">
                                <input type="email" class="form-control" id="email" name="doctorEmail" placeholder="Email" required>
                            </div>
                            <div class="mb-3">
                                <input type="tel" class="form-control" id="mobile" name="doctorMobile" placeholder="Mobile Number" required>
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="specialty" name="doctorSpecialty" placeholder="Specialty" required>
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="availability" name ="doctorAvailability" placeholder="Availability" required>
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="doctorPassword" name="doctorPassword" placeholder="Enter password" required>
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" id="confirmDoctorPassword" name="confirmDoctorPassword" placeholder="Confirm Password" required>

                                <p id="passwordMessage" class="text-danger ps-1"></p>

                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary" 
                                onClick="submitForm(event)">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    

    
    <script type="text/javascript">
        const doctorPassword = document.getElementById("doctorPassword")
        const confirmDoctorPassword = document.getElementById("confirmDoctorPassword")
        const passwordMessage = document.getElementById("passwordMessage")
        
        const submitForm = (event) => {
            
        if (doctorPassword.value !== confirmDoctorPassword.value) {

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
