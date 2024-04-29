<html>
<head>
    <title>Patient Login</title>
    <%-- Common content from the home page --%>
    <jsp:include page="../common/commonHome.jsp" />
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h1 class="text-center">Patient Login</h1>
                    </div>
                    <div class="card-body">
                        <%-- Add message here --%>
                        <%-- Form  --%>
                        <form id="loginForm" action="/validate-patientLogin" method="post">
                            <div class="form-group mb-3">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
                            </div>
                            <div class="form-group mb-3">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
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
