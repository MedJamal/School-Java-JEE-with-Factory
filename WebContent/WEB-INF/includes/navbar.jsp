<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="beans.User"%>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">School Manager</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${ pageContext.request.contextPath }/students">Students</a>
      </li>

    </ul>
    <c:choose>
	    <c:when test='${sessionScope.user == null}'>
		    <div class="form-inline my-2 my-lg-0">
		
		        <a class="nav-link" href="${ pageContext.request.contextPath }/signin" tabindex="-1" aria-disabled="true">Login</a>
		
		
		        <a class="nav-link" href="${ pageContext.request.contextPath }/signup" tabindex="-1" aria-disabled="true">Sign up</a>
		
		    </div>
	    </c:when>
	    
	    <c:otherwise>
	    	${sessionScope.user.getName()}
	    	<a class="nav-link" href="${ pageContext.request.contextPath }/signout" tabindex="-1" aria-disabled="true">Sign out</a>
	  	</c:otherwise>  
    </c:choose>

    

  </div>
</nav>