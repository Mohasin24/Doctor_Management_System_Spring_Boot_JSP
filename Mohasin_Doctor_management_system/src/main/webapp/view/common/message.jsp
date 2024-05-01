<html>

<body>
	<%
	String status = (String) session.getAttribute("status");

	if (status != null) {
	%>


	<div
		class="alert alert-success alert-dismissible fade show text-center"
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