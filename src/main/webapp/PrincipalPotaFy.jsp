<%@page import="com.afdm.potafymodel.Usuario"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ES">
<head>
	<meta charset="utf-8">
	<title>Página Principal - PotaFy</title>
		<link rel="stylesheet" type="text/css" href="estilosPotafy.css" />
		<link rel="shortcut icon" type="image/png" href="image_favicon-potafy-min.png"/>
	<style>
	
	/*.oculto {
	display: none;
	}
	
	.visible {
	display: block;
	}*/
	
	</style>

</head>
	
<body>
	<%Usuario usuario = (Usuario)session.getAttribute("Usuario"); %>
	
	
	<header class="cabeceraRestoPaginas">
		<h1>POTAFY</h1>
		<h3>Bienvenido, <%=usuario.getNombre() %></h3>
		<h4>Anímate a subir tu primera canción!!</h4>

	</header>
		<%--  <%@ include file="menu.jsp" %> --%>
		
		<nav>
			<ul>
			<li><a href="buscarCanciones.jsp">Buscar canción por título</a>
			<li><a href="MisPlayList.jsp">Mis PlayList</a></li>
			</ul>
		</nav>
		
	<main>
			
	<%String mensaje = (String)request.getAttribute("mensaje"); %>		
	
			<form action="SubirCancion" method="post" enctype="multipart/form-data">
				
				<div>
					<label for="txtTitulo">Título:</label>
					<input type="text" id="txtTitulo" name="titulo"/>
				</div>
				<div>	
					<label for="txtGenero">Género:</label>
					<input type="text" id="txtGenero" name="genero"/>
				</div>
				<div>
					<label for="idPublico">Pública:</label>
					<input type="checkbox" name="publico" id="idPublico"/>
				
				</div>
					
				<div>	
					<label for="ficheroCancion">Selecciona un tema:</label>
					<input type="file" name="ficheroCancion" accept=".mp3,audio/mpeg3"/>
				</div>	
				<div>
					<input type="submit" value="SUBIR CANCIÓN" id="botonSubirCancion"/>
				</div>
				
			<% if(mensaje != null) { %>	
		<div id="mensajeCancionSubida"><%=mensaje %></div>
		<% } %>	
				
			</form>
			
			
	
		
	</main>
	
	<footer>&copy;Made by Paula for PotaFy</footer>
</body>
</html>