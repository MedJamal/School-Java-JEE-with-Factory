<%@ include file="../includes/header.jsp"%>

	<div class="container">

		<h1>Sign up</h1>
		
		<form action="signup" method="post">
		
		  <div class="form-group">
		    <label for="name">Name</label>
		    <input type="text" class="form-control" name="name" placeholder="Enter your name">
		  </div>
		  
  		  <div class="form-group">
		    <label for="email">Email</label>
		    <input type="email" class="form-control" name="email" placeholder="Enter your email">
		  </div>
		  
  		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" name="password" placeholder="Enter your password">
		  </div>

  		  <div class="form-group">
		    <label for="password">Password confirmation</label>
		    <input type="password" class="form-control" name="password_confirmation" placeholder="Repeate password">
		  </div>

		  <button type="submit" class="btn btn-primary">Sign up</button>
		  
		</form>

	</div>

<%@ include file="../includes/footer.jsp"%>