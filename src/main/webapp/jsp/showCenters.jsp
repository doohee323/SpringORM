<%@include file="common/include/taglib.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message> </title>
<script type="text/javascript" src="js/centers.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	<form action="searchCenters.do" method="post">		
			<table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
			<tr>
				<td>Enter Center Name</td> 
				<td><input type="text" name="name"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					&nbsp;&nbsp;<input type="button" value="New Center" onclick="javascript:go('saveCenter.do');"/>
			</td></tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
		<tr bgcolor="lightblue">
			<th>id</th>
			<th>code</th>			
			<th>name</th>			
			<th>chief</th>			
			<th>address</th>			
			<th>phone</th>			
		</tr>
		<c:if test="${empty SEARCH_CENTERS_RESULTS_KEY}">
		<tr>
			<td colspan="7">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_CENTERS_RESULTS_KEY}">
			<c:forEach var="center" items="${SEARCH_CENTERS_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${center.id}"></c:out></td>
				<td><c:out value="${center.code}"></c:out></td>
				<td><c:out value="${center.name}"></c:out></td>
				<td><c:out value="${center.chief}"></c:out></td>
				<td><c:out value="${center.address}"></c:out></td>
				<td><c:out value="${center.phone}"></c:out></td>
				<td>
					&nbsp;<a href="updateCenter.do?id=${center.id}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteCenter('deleteCenter.do?id=${center.id}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>