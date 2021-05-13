package model;

import java.sql.*; 

public class Researcher {

	private Connection connect() 
	 { 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
	 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paflab6", "root", ""); 
			System.out.println("Successfully connected");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return con; 
	 }
	
	
	public String insertResearcher(String code, String name, String email, int phoneNo, String category) 
	 { 
			String output = ""; 
			try
			{ 
				Connection con = connect(); 
				if (con == null) 
				{
					return "Error while connecting to the database for inserting.";
				} 
				
				
				//System.out.println("1");
				
				// create a prepared statement
				String query = " insert into researcher(`reseacherID`,`researcherCode`,`researcherName`,`Email`,`contactNo`,`projectCategory`)"
	 + " values (?, ?, ?, ?, ?, ?)"; 
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				//System.out.println("2");
				
				// binding values
				preparedStmt.setInt(1, 0); 
				preparedStmt.setString(2, code); 
				preparedStmt.setString(3, name); 
				preparedStmt.setString(4, email); 
				preparedStmt.setInt(5, phoneNo); 
				preparedStmt.setString(6, category);
				
				
				//System.out.println(code);
				//System.out.println(name);
				
				//System.out.println("3");
				
				// execute the statement3
				preparedStmt.execute(); 
				
				//System.out.println("4");
				con.close(); 
				//output = "Inserted successfully"; 
				
				//Create JSON Object to show successful msg.
				String newResearcher = readResearcher();
				output = "{\"status\":\"success\", \"data\": \"" + newResearcher + "\"}";
			} 
			catch (Exception e) 
			{ 
				//Create JSON Object to show Error msg.
				output = "{\"status\":\"error\", \"data\": \"Error while Inserting Researcher.\"}";   
				System.err.println(e.getMessage()); 
				//e.printStackTrace();
				//System.err.println(e.getMessage()); 
			} 
			return output; 
	 } 
	
	
	public String readResearcher() 
	 { 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for reading.";
			} 
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Researcher Code</th>" +
					"<th>Researcher Name</th>" + 
					"<th>Researcher Email</th>" +
					"<th>Contact No</th>" +
					"<th>Research Project Category</th>" +
					"<th>Update</th><th>Remove</th></tr>"; 
	 
			String query = "select * from researcher"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
			
			//System.out.println(rs.);
			
			// iterate through the rows in the result set
			while (rs.next()) 
			{ 
				String reseacherID = Integer.toString(rs.getInt("reseacherID")); 
				String researcherCode = rs.getString("researcherCode"); 
				String researcherName = rs.getString("researcherName"); 
				String Email = rs.getString("Email"); 
				String contactNo = rs.getString("contactNo");
				String projectCategory = rs.getString("projectCategory"); 
				
				
			// Add into the html table
				
				
				output += "<tr><td><input id='hidresearcherIDUpdate' name='hidresearcherIDUpdate' type='hidden' value='" + reseacherID + "'>" + researcherCode + "</td>"; 

				
				
				output += "<td>" + researcherName + "</td>"; 
				output += "<td>" + Email + "</td>"; 
				output += "<td>" + contactNo + "</td>"; 
				output += "<td>" + projectCategory + "</td>"; 
				
				// buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
					  		+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-reseacherID='"+ reseacherID +"'>"+"</td></tr>";

			} 
			con.close(); 
			// Complete the html table
			output += "</table>"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while reading the items.";
			e.printStackTrace();
			
			//String query = "select * from researcher";
			//System.out.println(query);
			//System.err.println(e.getMessage()); 
		} 
		return output; 
	 }

	
	public String updateResearcher(String ID, String code, String name, String email, int phoneNo, String category)
	 { 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for updating."; 
			} 
			
			//System.out.println("1");
			// create a prepared statement
			String query = "UPDATE researcher SET researcherCode=?,researcherName=?,Email=?,contactNo=?,projectCategory=? WHERE reseacherID=?"; 
							PreparedStatement preparedStmt = con.prepareStatement(query); 
							
			//System.out.println("2");
			
			// binding values
			
			preparedStmt.setString(1, code); 
			preparedStmt.setString(2, name); 
			preparedStmt.setString(3, email); 
			preparedStmt.setInt(4, phoneNo); 
			preparedStmt.setString(5, category); 
			preparedStmt.setString(6, ID);
			
			//System.out.println("3");
			// execute the statement
			preparedStmt.execute(); 
			
			//System.out.println("4");
			con.close(); 
			output = "Updated successfully"; 
			
			 //create JSON object to show successful msg
			   String newResearcher = readResearcher();
			   output = "{\"status\":\"success\", \"data\": \"" + newResearcher + "\"}";
		} 
		catch (Exception e) 
		{ 
			output = "{\"status\":\"error\", \"data\": \"Error while Updating Researcher Details.\"}";      
			//System.err.println(e.getMessage());
			e.printStackTrace();
			//System.err.println(e.getMessage()); 
		} 
		return output; 
	 } 
	
	public String deleteResearcher(String researcher_ID) 
	 { 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for deleting.";
			} 
			// create a prepared statement
			String query = "delete from researcher where reseacherID=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(researcher_ID)); 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			//output = "Deleted successfully"; 
			
			//create JSON Object
			  String newResearcher = readResearcher();
			  output = "{\"status\":\"success\", \"data\": \"" + newResearcher + "\"}";
		} 
		catch (Exception e) 
		{ 
			 //Create JSON object 
			  output = "{\"status\":\"error\", \"data\": \"Error while Deleting Researcher.\"}";
			  System.err.println(e.getMessage());  
		} 
		return output; 
	 }
	

	
}

