<html>
<head>
	<!-- All CDN's -->
          <jsp:include page="../common/common.jsp" />
          
          <style type="text/css">
          .outer{
          		position:relative;
          		
          	}
          	
          	.inner{
          		position:absolute;
          		width:100%;
          		top:-80px;
          	}
          </style>
</head>
<body>
	<%
	String status = (String) session.getAttribute("status");

	if (status!=null) {
	%>


	<div
		class="w-75 m-auto alert alert-success alert-dismissible fade show text-center border border-success shadow shadow-lg"
		role="alert">

		<p>
			<strong><%=status%></strong>
		</p>

		<button id="message-button" type="button" class="close d-none"
			data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

	<script type="text/javascript">
   
	let messageButton = document.getElementById("message-button");
	
	setTimeout(()=>{
		messageButton.click();
	},3000)
	
</script>
	<%
	session.removeAttribute("status");
	
	}
	%>

</body>

</html>