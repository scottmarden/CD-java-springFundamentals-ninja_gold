<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ninja Gold</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<div class="header">
		<h2>Your Gold: <span class="border" ><c:out value="${gold}" /></span></h2>
	</div>
	
	<div id="choices">
		<div class="location">
			<form action="find_gold" method="post">
			<input type="hidden" name="location" value="farm">
				<h3>Farm</h3>
				<h4>(earns 10-20 gold)</h4>
				<button type="submit">Find Gold!</button>			
			</form>
		</div>
		<div class="location">
			<form action="find_gold" method="post">
			<input type="hidden" name="location" value="cave">
				<h3>Cave</h3>
				<h4>(earns 5-10 gold)</h4>
				<button type="submit">Find Gold!</button>			
			</form>
		</div>
		<div class="location">
			<form action="find_gold" method="post">
			<input type="hidden" name="location" value="house">
				<h3>House</h3>
				<h4>(earns 2-5 gold)</h4>
				<button type="submit">Find Gold!</button>			
			</form>
		</div>
		<div class="location">
			<form action="find_gold" method="post">
			<input type="hidden" name="location" value="casino">
				<h3>Casino</h3>
				<h4>(earns/takes 0-50 gold)</h4>
				<button type="submit">Find Gold!</button>			
			</form>
		</div>
	</div>
	<div id="activities">
		<h3>Activities: </h3>
		<div id="activity_log">
			<ul>
				<c:forEach var="action" items="${activities}">	
					<li><c:out value="${action}" /></li>
				</c:forEach>	
			</ul>
		</div>
	</div>
</body>
</html>