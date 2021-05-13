<%@ page import="model.Researcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Researchers Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>

</head>
<body>

<div class="container"> 
		<div class="row">  
		
			<div class="col-8">       
				<h1 class="m-3">Researchers Management</h1>        
				
				<form id="formResearcher" name="formResearcher" method="post" action="researcher.jsp">  
					Researcher Code:  
					<input id="code" name="code" type="text" class="form-control form-control-sm">  
					
					<br> 
					Researcher Name:  
					<input id="rname" name="rname" type="text" class="form-control form-control-sm">  
					
					<br>
					 Email:  
					 <input id="email" name="email" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					 Contact Number:  
					 <input id="phoneNo" name="phoneNo" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					 Project Category:  
					 <input id="category" name="category" type="text" class="form-control form-control-sm">  
					 

					 
					 <br>  
					 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					 <input type="hidden" id="hidresearcherIDSave" name="hidresearcherIDSave" value=""> 
					 
				</form> 
				
				<div id="alertSuccess" class="alert alert-success"></div>  
				<div id="alertError" class="alert alert-danger"></div> 
				
				<br>  
				<div id="divresearcherGrid">   
					<%    
						Researcher researcherObj = new Researcher();
						out.print(researcherObj.readResearcher());   
					%>  
					
				</div>
				  
 			</div>
 		 
 		</div>    
 		
 
	</div> 


</body>
</html>