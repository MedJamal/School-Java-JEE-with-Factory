<%@ include file="../includes/header.jsp"%>

	<div class="container">

		<h1>Sign in</h1>
		
		<form action="signin" method="post">
		
		  <div class="form-group">
		    <label for="email">Email</label>
		    <input type="email" class="form-control" name="email" placeholder="Enter your email">
		  </div>
		  
  		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" name="password" placeholder="Enter your password">
		  </div>

		  <button type="submit" class="btn btn-primary">Sign in</button>
		  
		</form>

	</div>

<%@ include file="../includes/footer.jsp"%>