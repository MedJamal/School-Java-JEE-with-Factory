<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br />

<c:choose>
	<c:when test='${sessionScope.alertSuccess != null}'>
		<div class="alert alert-success" role="alert">
			${sessionScope.alertSuccess}
		</div>
		<% session.removeAttribute("alertSuccess"); %>
	</c:when>
</c:choose>

<c:choose>
	<c:when test='${sessionScope.alertWarning != null}'>
		<div class="alert alert-success" role="alert">
			${sessionScope.alertWarning}
		</div>
		<% session.removeAttribute("alertWarning"); %>
	</c:when>
</c:choose>

<c:choose>
	<c:when test='${sessionScope.alertDanger != null}'>
		<div class="alert alert-success" role="alert">
			${sessionScope.alertDanger}
		</div>
		<% session.removeAttribute("alertDanger"); %>
	</c:when>
</c:choose>


