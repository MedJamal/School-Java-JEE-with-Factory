<%@page import="java.util.ArrayList"%>
<%@page import="beans.Student"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

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
		    <label for="address">Adresse</label>
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
		      <th scope="col">Adresse</th>
		      <th scope="col">Level</th>
		      <th scope="col">Registration date</th>
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
				    </tr>
		      </c:forEach>
		  </tbody>
		</table>

	</div>



</body>
</html>