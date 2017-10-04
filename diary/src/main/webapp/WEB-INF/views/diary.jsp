<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
<!--<fmt:formatDate value="${date }" pattern="yyyy/MM/dd"/>-->

<html>
<head>
<title>Diary Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: solid black;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: solid black;
	color: blue;/*#333;*/
	background-color: lightblue;
	
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
	border-color: solid black;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: solid black
}
.container {
    float: left;
    position: relative;
    left: 50%;
}
.fixer-container {
  position: relative;
  left: -50%;
  float: left;
}
.container1 > img {
    position: relative;
    width: 30%;
    height: 30%;
    opacity: 1.00;
    padding-top: -400px;
    padding-right: 0px;
    float:right;
  /*  margin-right:0px;
    margin-left: 0px;
    margin-top: 100px;
    float: left;*/
}
h3#mg {
    color: solid black;
    padding-left: -100px;
    margin-top: 100px;
   /* float: left;*/
}
h3#mg>a:hover {
   color: blue;
}
</style>
</head>
<body>
	<h1>${dia}</h1>

	<c:url var="addAction" value="/diary/add/${person_id}"></c:url>
	

	<form:form action="${addAction}" commandName="diary">
		<div class="container1">
			 <img src="C:\Users\ARIGAP\Desktop\VS\images\me2.jpg"/>
		</div>
		<div class="container">
		<div class="fixer-container">
		<table>
			<c:if test="${!empty diary.title}">
				<tr>
					<td><form:label path="event_id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="event_id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="event_id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="title">
						<spring:message text="Title" />
					</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>
					<!--<fmt:formatDate value="${date }" pattern="yyyy/MM/dd"/>--> <form:label
						path="date" value="yyyy/MM/dd">
						<spring:message text="Date (yyyy/MM/dd)" />
					</form:label>
				</td>
				<td><form:input path="date" /></td>
			</tr>
			<tr>
				<td><form:label path="desc">
						<spring:message text="Desc" />
					</form:label></td>
				<td><form:input path="desc" /></td>
			</tr>
			<tr>
				<td><form:label path="person_id">
						<spring:message text="Person_id" />
					</form:label></td>
				<td><form:input path="person_id" readonly="true" size="8"
						disabled="true" /> <form:hidden path="person_id" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty diary.title}">
						<input type="submit" value="<spring:message text="Edit Diary"/>" />
					</c:if> <c:if test="${empty diary.title}">
						<input type="submit" value="<spring:message text="Add Diary"/>" />
					</c:if></td>
			</tr>
		</table>
		</div>
		</div>
					<a href="/log">Login Page</a>
		
	</form:form>
	<br>
	<section>
		<h3 id="mg">
		<input type="button" value="DiaryList" onClick="document.getElementById('mg').scrollIntoView();">
		</h3>
		
	<c:if test="${!empty listDiary1}">
		<table class="tg">
			<tr>
				<th width="80">Diary ID</th>
				<th width="120">Diary Title</th>
				<th width="120">Diary Date</th>
				<th width="420">Diary Desc</th>
				<th width="80">Diary Person_Id</a></th>

				<th widt h="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listDiary1}" var="diary">
				<tr>
					<td>${diary.event_id}</td>
					<td>${diary.title}</td>
					<td>${diary.date}</td>
					<td>${diary.desc}</td>
					<td>${diary.person_id}</td>
					<td><a
						href="<c:url value='/edit/${diary.person_id}/${diary.event_id}' />">Edit</a></td>
					<td><a
						href="<c:url value='/remove/${ diary.person_id}/${diary.event_id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h3 id="mg">
	  <input type="button" value ="Top" onClick="document.getElementById('mg').scrollIntoView();"/>
	</h3>
	</section>
</body> 
</html>