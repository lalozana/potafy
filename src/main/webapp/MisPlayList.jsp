<%@page import="com.afdm.potafymodel.PlayList"%>
<%@page import="java.util.List"%>
<%@page import="com.afdm.potafymodel.Usuario"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Mis PlayList</title>
	<link rel="stylesheet" type="text/css" href="estilosPotafy.css" />
	
	<link rel="shortcut icon" type="image/png" href="image_favicon-potafy-min.png"/>

</head>
<body>
	<%Usuario usuario = (Usuario)session.getAttribute("Usuario"); %>
	
	<header>
		<h1>POTAFY</h1>
		<h3>Bienvenido, <%=usuario.getNombre() %></h3>
		<h4>Pónle un nombre a tu PlayList antes de guardarla</h4>
	</header>
	
	<main>
		<form action="CrearPlayList" method="post" >
			<div>
					<label for="txtnombre">Nombre de la PlayList:</label>
					<input type="text" id="txtnombre" name="nombrePlayList"/>
					
			</div>
			<div>
					<input type="submit" value="Crear PlayList" id="botonSubirCancion"/>
				</div>
		
			
		<% String mensaje = (String)request.getAttribute("mensaje"); %>
		<% if(mensaje != null) {%>
			<div>
				<%=mensaje %>
			</div>
			<% } %>
			
		</form>
		
		<% List<PlayList> lista = (List<PlayList>)session.getAttribute("playLists");%>
		<% if(lista != null && lista.isEmpty()) { %>
			<% for(PlayList pl : lista) { %>
				<div>
					<%=pl.getNombrePlayList() %>
					<input type="button" value="Reproducir"/>
					<input type="button" value="Eliminar"/>
				</div>
			<% } %>
		<% } else { %>
			<div>Todavía no hay ninguna PlayList creada</div>
		<% } %>
		
	</main>

	<footer>&copy;Made by Paula for PotaFy</footer>

</body>
</html>