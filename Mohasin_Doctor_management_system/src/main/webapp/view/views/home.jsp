<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

     <head>
          <jsp:include page="../common/common.jsp"/>

          <style>

               #main{
                    background-image:url("view/assets/home.jpg");
                    background-size:cover;
                    background-position:center;
                    height:100vh;
               }

               .inner{
                    height:100vh;
               }

          </style>
     </head>

     <body id="main">
          <jsp:include page="../common/navbar.jsp"/>
          
          <div class="inner d-flex flex-row justify-content-center align-items-center">

               <h1 class="bg-primary-subtle text-success p-4 rounded">Welcome to doctor management system</h1>
          </div>

          <button>Doctor</button>

     </body>

</html>