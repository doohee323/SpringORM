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
 		<form:form action="saveCenter.do" method="post" commandName="newCenter">
	    	
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">	
					<tr>
						<td width="100" align="right">code</td>
						<td width="150">
						<form:input path="code"/></td>
						<td align="left">
						<form:errors path="code" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
						<td width="100" align="right">name</td>
						<td width="150">
						<form:input path="name"/></td>
						<td align="left">
						<form:errors path="name" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
						<td width="100" align="right">chief</td>
						<td width="150">
						<form:input path="chief"/></td>
						<td align="left">
						<form:errors path="chief" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
						<td width="100" align="right">address</td>
						<td width="150">
						<form:input path="address"/></td>
						<td align="left">
						<form:errors path="address" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
						<td width="100" align="right">phone</td>
						<td width="150">
						<form:input path="phone"/></td>
						<td align="left">
						<form:errors path="phone" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="" value="Save">
						&nbsp;&nbsp;
						<input type="reset" name="" value="Reset">
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
