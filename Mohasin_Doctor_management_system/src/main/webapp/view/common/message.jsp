<% 
String status = (String)request.getAttribute("status");
String m = request.getParameter("status");
if (status != null) { 
%>  

<% out.println(m);
out.println(status);
%>

  <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
        <p><strong><%=status %></strong></p>
        <p><strong><%=m %></strong></p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
        </button>
   </div>
   
<% 
} 
%>

