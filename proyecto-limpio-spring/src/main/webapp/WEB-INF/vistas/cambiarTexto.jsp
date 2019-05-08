<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div id="textoBox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 bg-info">
			<h1>App que cambia tu texto</h1>
			<hr class="bg-secondary">
			<form:form action="resultado-texto" method="GET" modelAttribute="texto">
				<label>Opciones:</label><br>
				<form:select path="opcion" id="opcion" class="form-control">
					<form:option value="1">Mayúscula</form:option>
					<form:option value="2">Minúscula</form:option>
					<form:option value="3">Invertido</form:option>
					<form:option value="4">Cantidad</form:option>
				</form:select><br>
				<label>Ingresa tu texto</label><br>
				<form:textarea path="txt" id="txt" type="text" class="form-control" rows="3" cols="1"/><br>
				<button class="btn btn-lg btn-primary btn-block" type="Submit">Modificar</button><br><br>
			</form:form>
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
