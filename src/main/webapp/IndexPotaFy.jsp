<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ES">
<head>
<meta charset="utf-8">
<title>Index - PotaFy</title>
	<link rel="stylesheet" type="text/css" href="estilosPotafy.css" />
	
	<link rel="shortcut icon" type="image/png" href="image_favicon-potafy-min.png"/>
	<style>
	.error {
		color: red;
		font-style: oblique;
	}
	
	body {
		background-image: url(guitar-ged87b9d68_1280.jpg)
	}
	

	</style>
</head>
<body>

	<header class="cabeceraInicioSesion">
		<h1>PotaFy</h1>
		<h2>Inicio Sesión</h2>
	</header>

	<main>
	<% String error = (String)request.getAttribute("error");%>
		<form action="iniciarSesion" method="post">
			<div>
				<label for="txtNombre">Nombre de Usuario:</label> 
				<input type="text" id="txtNombre" placeholder="Admin" name="NombreUsuario"/>
			</div>
			
			<div>
				<label for="txtContraseña">Contraseña:</label> 
				<input type="password" id="txtContraseña" name="Clave" required="required"/>
		</div>
		<div id="boton">
			<input type="submit" value="INICIAR SESIÓN" id="botonEnviar" />
		</div>
	
		<% if(error != null) { %>
			<div class="error">
				<%=error %>
			</div>
			<% } %>
	
		
		<div>
		¿Eres nuevo? Regístrate <a href="registro.html">haciendo click aquí</a>
		</div>
		
		
		<div class="error" id="error"></div>
		</form>
	</main>

	<footer>&copy;Made by Paula for PotaFy</footer>


</body>
</html>