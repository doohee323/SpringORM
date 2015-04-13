<%@include file="common/include/taglib.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/centers.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit Center Form</h3></td>
	</tr>
  <tr valign="top" align="center">
    <td align="center">
 		<form:form action="updateCenter.do" method="post" commandName="editCenter">
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">					
					<tr>
						<td width="100" align="right">Id</td>
						<td width="150">
						<form:input path="id" readonly="true"/></td>
						<td align="left">
						<form:errors path="id" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">code</td>
						<td><form:input path="code"/></td>
						<td align="left"><form:errors path="code" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">name</td>
						<td><form:input path="name"/></td>
						<td align="left"><form:errors path="name" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">chief</td>
						<td><form:input path="chief"/></td>
						<td align="left"><form:errors path="chief" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">address</td>
						<td><form:input path="address"/></td>
						<td align="left"><form:errors path="address" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">phone</td>
						<td><form:input path="phone"/></td>
						<td align="left"><form:errors path="phone" cssStyle="color:red"></form:errors>  </td>
					</tr>

					<tr valign="bottom">
						<td colspan="3" align="center">
						<input type="button"  value="Delete" onclick="javascript:deleteCenter('deleteCenter.do?id=${editCenter.id}');">
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllCenters.do');">
						</td>
					</tr>
					
				</table>				
		</form:form>
    </td>    
  </tr>
</table>


</body>
</html>
