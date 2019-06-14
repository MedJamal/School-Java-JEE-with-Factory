<%@ include file="includes/header.jsp"%>


	<div class="container">

		<h1>Add new student</h1>
		
		<form action="students" method="post">
		
		  <div class="form-group">
		    <label for="first_name">First name</label>
		    <input type="text" class="form-control" name="firt_name" placeholder="Enter first name">
		  </div>
		  
  		  <div class="form-group">
		    <label for="last_name">Last name</label>
		    <input type="text" class="form-control" name="last_name" placeholder="Enter last name">
		  </div>
		  
  		  <div class="form-group">
		    <label for="address">Address</label>
		    <input type="text" class="form-control" name="address" placeholder="Enter address">
		  </div>

  		  <div class="form-group">
		    <label for="level">Level</label>
		    <select class="form-control" name="level">
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
		
		<br />
		
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">First name</th>
		      <th scope="col">Last name</th>
		      <th scope="col">Address</th>
		      <th scope="col">Level</th>
		      <th scope="col">Registration date</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
			  <c:forEach items="${students}" var="student">
				    <tr>
				      <th scope="row">${student.getId()}</th>
				      <td>${student.getFirstName()}</td>
				      <td>${student.getLastName()}</td>
				      <td>${student.getAddress()}</td>
				      <td>${student.getLevel()}</td>
				      <td>${student.getCreatedAt()}</td>
				      <td>
				      	<a class="btn btn-sm btn-danger" href="#">Delete</a>
				      </td>
				    </tr>
		      </c:forEach>
		  </tbody>
		</table>

	</div>



<%@ include file="includes/footer.jsp"%>