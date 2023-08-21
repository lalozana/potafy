<%@page import="com.afdm.potafymodel.Usuario"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ES">
<head>
<meta charset="utf-8">
<title>Buscar canción por título</title>
 <link rel="stylesheet" type="text/css" href="estilosPotafy.css" /> 
 <link rel="shortcut icon" type="image/png" href="image_favicon-potafy-min.png"/>
</head>
<body>

	<%Usuario usuario = (Usuario)session.getAttribute("Usuario"); %>
	
	
	<header class="cabeceraRestoPaginas">
		<h1>POTAFY</h1>
		<h3>Bienvenido, <%=usuario.getNombre() %></h3>
		<h4></h4>

	</header>

	<main>
	<div>
		<label for="txtBusqueda" id="label">Escribe el título de una canción en el campo para buscarla:</label>
		<input type="search" id="txtBusqueda" name="busqueda"/>
	</div>
		<div id="divListaCanciones" class="imprimirCancionesBusqueda"></div>
		<div id="divLetraCancion"></div>
		
	</main>
<script type="text/javascript" src="buscarCanciones.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</body>
</html>