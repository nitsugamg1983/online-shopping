<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

Language : <a href="?lang=en">English</a>|<a href="?lang=es">Spanish</a>
<spring:message code="attendee.name"/>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		
		<!-- Navigation -->
		<%@include file="../shared/navbar.jsp"%>
		
		<div class="content">
			<!-- Page Content -->
			<!-- loading home page -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp" %>
			</c:if>
			<!-- loading only when the user clicks about -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp" %>
			</c:if>
			<!-- loading only when the user clicks contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp" %>
			</c:if>
			
			<!-- loading only when the user clicks All products or Products category -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp" %>
			</c:if>
			
			<!-- loading only when the user clicks product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp" %>
			</c:if>
			
			<!-- loading only when the user clicks manage product -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp" %>
			</c:if>
			
		</div>
	
		
		<!-- Footer -->
		<%@include file="../shared/footer.jsp" %> 
		
	
	

		
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.min.js"></script>
	
		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
			
		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
			
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- bootbox Script -->
		<script src="${js}/bootbox.min.js"></script>
		
		<!-- myself js -->
		<script src="${js}/myapp.js"></script>
	</div>

</body>

</html>
