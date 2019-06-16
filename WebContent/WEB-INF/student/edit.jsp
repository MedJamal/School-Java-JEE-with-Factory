<%@ include file="../includes/header.jsp"%>



	<div class="container">

		<h1>Edit student</h1>
		
		<form action="edit-student" method="post">
		
		  <input type="hidden" name="id" value="${ student.getId() }">
		  <div class="form-group">
		    <label for="first_name">First name</label>
		    <input type="text" class="form-control" name="firt_name" placeholder="Enter first name" value="${ student.getFirstName() }">
		  </div>
		  
  		  <div class="form-group">
		    <label for="last_name">Last name</label>
		    <input type="text" class="form-control" name="last_name" placeholder="Enter last name" value="${ student.getLastName() }">
		  </div>
		  
  		  <div class="form-group">
		    <label for="address">Address</label>
		    <input type="text" class="form-control" name="address" placeholder="Enter address" value="${ student.getAddress() }">
		  </div>

  		  <div class="form-group">
		    <label for="level">Level</label>
		    <select id="level" class="form-control" name="level">
			  <option>TRI101</option>
			  <option>TRI102</option>
			  <option>TRI201</option>
			  <option>TRI202</option>
			  <option>TDI101</option>
			  <option>TDI102</option>
			  <option>TDI201</option>
			  <option>TDI202</option>
			</select>
		  </div>

		  <button type="submit" class="btn btn-primary">Save</button>
		  
		</form>
		
	</div>


		<script type="text/javascript">
		
			let level = document.getElementById("level");
			
			for (let i = 0; i < level.options.length; i++){
				
				if (level.options[i].value === "${ student.getLevel() }"){
					console.log(level.options[i].value);
					level.options.selectedIndex = i;
				}
				
			}
		
		</script>


<%@ include file="../includes/footer.jsp"%>