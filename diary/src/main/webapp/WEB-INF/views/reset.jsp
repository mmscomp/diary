<html>
<head>
<title>Yahoo!!</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>

</head>
<body>
	<!--  <h1>My First JSP!!!</h1>-->
	<!--  <h3>My user name is ${name} and passwd is </h3>-->

	<nav class="navbar navbar-default">

		<!--        <a href="/" class="navbar-brand">Brand</a>

        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/todo.do">Todos</a></li>
            <li><a href="http://www.yahoo.com">Yahoo</a></li>
        </ul>
-->
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/log">Sign In</a></li>
		</ul>

	</nav>
	<div class="container">
		<h1>Signing Up</h1>
		<p>
			<font color=red>${errorMessage }</font>
		</p>
		<form action="/log/register" method=POST>
		Enter your ID: <input name=id type=text /><br><br>
		New User name: <input name=userName type=text /><br><br>
		New Password : <input name=passwd type=password><br><br>		
		First Name   : <input name=firstName type=text /><br><br>
		Last Name    : <input name=lastName type=text /><br><br> 
		    <br><br><input type=submit value="Reset" />
				
		</form>
	</div>

	<footer class="footer">
		<div>footer content</div>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
