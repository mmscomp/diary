<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
<script type="text/javascript" src="/resources/person.js"></script>
</head>
<body>
	<h1>Add a person</h1>

	<c:url var="addAction" value="/person/add"></c:url>

	<form:form action="${addAction}" commandName="person">
		<table>
			<c:if test="${!empty person.firstName}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="firstName">
						<spring:message text="FirstName" />
					</form:label></td>
				<td><form:input path="FirstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message text="LastName" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty person.firstName}">
						<input type="submit" value="<spring:message text="Edit"/>" />
					</c:if> <c:if test="${empty person.firstName}">
						<input type="submit" value="<spring:message text="Add Person"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Person List</h3>
	<c:if test="${!empty listPerson}">
		<table class="tg">
			<tr>
				<th width="80">Person ID</th>
				<th width="120">Person FirstName</th>
				<th width="120">Person LastName</th>


				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listPerson}" var="person">
				<tr>
					<td>${person.id}</td>
					<td><a href="/diary/${person.id}">${person.firstName}</a></td>
					<td>${person.lastName}</td> 
					<td><a href="<c:url value='/person/edit/${person.id}' />">Edit</a></td>
					<td><a href="<c:url value='/person/remove/${person.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<canvas id="canvas" width= 600 height= 480></canvas>
</body>
</html>