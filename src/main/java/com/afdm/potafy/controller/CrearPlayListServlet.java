package com.afdm.potafy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.afdm.potafymodel.PlayList;
import com.afdm.potafymodel.Usuario;
import com.afdm.potafymodel.exception.ConexionException;
import com.afdm.potafymodel.exception.PlayListRepetidaException;
import com.afdm.potafymodel.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrearPlayListServlet
 */
public class CrearPlayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombrePlayList = request.getParameter("nombrePlayList");
		Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
		Fachada fachada = new Fachada();
		try {
			PlayList playlist = fachada.crearPlayList(nombrePlayList, usuario);
			List<PlayList> lista = (List<PlayList>)request.getSession().getAttribute("playLists");
			// si en la sesión del usuario aún no hay ninguna PlayList(== null) se crea una nueva
			if (lista == null) {
				lista = new ArrayList<PlayList>();
			}
			// se añade la nueva PlayList a la lista
			lista.add(playlist);
			// Se actualiza la lista que estaba guardada en la sesión, en la memoria caché
			
			request.getSession().setAttribute("playLists", lista);
			
			request.getRequestDispatcher("MisPlayList.jsp").forward(request, response);
		} catch (ConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlayListRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
request.getSession().setAttribute("mensaje", e.getMessage());
			
			request.getRequestDispatcher("MisPlayList.jsp").forward(request, response);
		}
	}

}
