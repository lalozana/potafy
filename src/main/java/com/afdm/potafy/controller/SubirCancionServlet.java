package com.afdm.potafy.controller;

import java.io.File;
import java.io.IOException;

import com.afdm.potafymodel.Cancion;
import com.afdm.potafymodel.Usuario;
import com.afdm.potafymodel.exception.ConexionException;
import com.afdm.potafymodel.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class SubirCancionServlet
 */
public class SubirCancionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*System.out.println(request.getServletContext().getRealPath(""));*/
		
		// donde está la aplicación
		String rutaAplicacion = request.getServletContext().getRealPath("");
		String rutaCanciones = rutaAplicacion + "Canciones";
		File carpetaCanciones = new File(rutaCanciones);
		if (carpetaCanciones.exists() == false) {
			carpetaCanciones.mkdir();
		}
		Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
		String rutaUsuario = rutaCanciones + java.io.File.separator + usuario.getIdUsuario() + java.io.File.separator;
		/*System.out.println(rutaUsuario);*/
		File carpetaUsuario = new File(rutaUsuario);
		if (carpetaUsuario.exists() == false) {
			carpetaUsuario.mkdir();
		}
		
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String txtPublica = request.getParameter("publico");
		/*boolean publica = txtPublica != null;*/
		boolean publica;
		if (txtPublica != null) {
			publica = true;
		} else {
			publica = false;
		}
		// **** SUBIR DATOS DEL FICHERO***
		Part fichero = request.getPart("ficheroCancion");	
		String nombreFichero = extraerNombreFichero(fichero);
		
		String rutaFichero = rutaUsuario + nombreFichero;
		fichero.write(rutaFichero);
		
		// **** INSERTAR EN LA BASE DE DATOS***
		String urlGuardar = usuario.getIdUsuario() + "/" + nombreFichero;
		Cancion cancion = new Cancion(titulo, null, genero, urlGuardar, publica, null, usuario);
		Fachada fachada = new Fachada();
		try {
			fachada.subirCancion(cancion);
			request.setAttribute("mensaje", "Canción " + titulo + " subida correctamente!");
			request.getRequestDispatcher("PrincipalPotaFy.jsp").forward(request, response);
		} catch (ConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private String extraerNombreFichero(Part part) {
    	String nombreFichero = "";
        String contenido = part.getHeader("content-disposition");
        System.out.println("cabecera del contenido= "+ contenido);
        String[] tokens = contenido.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                nombreFichero = token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return nombreFichero;
    }
	
	
	
	
	
	/*	for (Part fragmento : request.getParts()) {
			System.out.println("Nombre " + fragmento.getName());
			System.out.println("Tipo: "+ fragmento.getContentType());
			if (fragmento.getContentType() != null && fragmento.getContentType().equals("audio/mpeg")) {
				fragmento.write(rutaUsuario + File.separatorChar + nombreFichero);
			}*/
			  
		
	}


