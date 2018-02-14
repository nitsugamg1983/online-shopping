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



<!-- Bootstrap Core CSS -->
<link href="${css}/dragula.css" rel="stylesheet">


</head>

<body>


<div class="container">
  <h1>Drag & Drop</h1>
  <p>Trying out <code>dragula.js</code>. Source <a href="https://github.com/bevacqua/dragula">here</a>.</p>
  <div class="left">
    <div id="drag-elements">
      
      
      

		<div>		
			
						<img src="${contextRoot}/resources/images/PRD74AC8F1A-1EEA-4DA.jpg" height="30" width="30" class="dataTableImg"/>
					
		</div>	
			
		<div>	
			
						<img src="${contextRoot}/resources/images/PRD74AC8F1A-1EEA-4DA.jpg" height="30" width="30" class="dataTableImg"/>
					
		</div>
		<div>	
			
						<img src="${contextRoot}/resources/images/PRD74AC8F1A-1EEA-4DA.jpg" height="30" width="30" class="dataTableImg"/>
					
		</div>
      
    </div>

    <div id="drop-target">
    </div>
  </div>
  <div class="right">
    <div id="display">Display</div>
  </div>
</div>

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/dragula.js"></script>
	<script src="${js}/funciones.js"></script>


</body>

</html>
