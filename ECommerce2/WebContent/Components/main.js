$(document).ready(function() 
{  
	if ($("#alertSuccess").text().trim() == "")  
	{   
		$("#alertSuccess").hide();  
	} 
	$("#alertError").hide(); 
}); 

//SAVE ============================================ 
$(document).on("click", "#btnSave", function(event) 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 

	// Form validation-------------------  
	var status = validateResearcherForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 

	// If valid------------------------  
	var t = ($("#hidresearcherIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
	{
		url : "ResearcherAPI",
		type : t,
		data : $("#formResearcher").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onResearcherSaveComplete(response.responseText, status);
		}
	});
}); 

function onResearcherSaveComplete(response, status){
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Saved.");
			$("#alertSuccess").show();
					
			$("#divresearcherGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Saving.");
		$("#slertError").show();
	}else{
		$("#alertError").text("Unknown Error while Saving.");
		$("#alertError").show();
	}
	$("#hidresearcherIDSave").val("");
	$("#formResearcher")[0].reset();
}

//UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) 
		{     
	$("#hidresearcherIDSave").val($(this).closest("tr").find('#hidresearcherIDUpdate').val());     
	$("#researcherCode").val($(this).closest("tr").find('td:eq(0)').text());    
	$("#researcherName").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#Email").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#contactNo").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#projectCategory").val($(this).closest("tr").find('td:eq(4)').text()); 
	

});


//Remove Operation
$(document).on("click", ".btnRemove", function(event){
	$.ajax(
	{
		url : "ResearcherAPI",
		type : "DELETE",
		data : "researcher_ID=" + $(this).data("resID"),
		//data : "reseacherID=17",   
		dataType : "text",
		complete : function(response, status)
		{
			onResearcherDeletedComplete(response.responseText, status);
		}
	});
});

function onResearcherDeletedComplete(response, status)
{
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Deleted.");
			$("#alertSuccess").show();
					
			$("#divresearcherGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Deleting.");
		$("#alertError").show();
	}else{
		$("#alertError").text("Unknown Error While Deleting.");
		$("#alertError").show();
	}
}

//CLIENTMODEL
function validateResearcherForm() {  
	// RESEARCHER CODE  
	if ($("#researcherCode").val().trim() == "")  {   
		return "Insert researcher code.";  
		
	} 
	
	 // RESEARCHER NAME  
	if ($("#researcherName").val().trim() == "")  {   
		return "Insert researcher name.";  
		
	} 
	
	 // Email 
	if ($("#Email").val().trim() == "")  {   
		return "Insert Email.";  
		
	} 
	 
	 // is numerical value  
	var tmpMobile = $("#contactNo").val().trim();  
	if (!$.isNumeric(tmpMobile))  {   
		return "Insert a numerical value for Contact Number.";  
		
	}
	 
	
	
	// PROJECT CATEGORY 
	if ($("#projectCategory").val().trim() == "")  {   
		return "Insert Project Category.";  
		
	} 
	 
	 
	
	 
	 return true; 
	 
}
