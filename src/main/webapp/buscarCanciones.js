/**
 * 
 */
 
 document.getElementById("txtBusqueda").addEventListener("keyup", buscarCanciones);
 /*sustituye a poner en html onkeyup();*/
 
 
 function buscarCanciones() {
	let textoBusqueda = document.getElementById("txtBusqueda").value;
	if (textoBusqueda != "") {
		axios.post(
			"BuscarCancionesPorTitulo", 
			null, 
			{params: {busqueda: textoBusqueda}}
		).then(function(respuesta) {
			imprimirCanciones(respuesta.data);
		}).catch(function(error){
			console.log(error);
		});
	}
}


function imprimirCanciones(lista) {
	let divListaCanciones = document.getElementById("divListaCanciones");
	let html = "";
	
	//console.log(lista);
	
	for (let cancion of lista) {
		html = html + 
		`<div class="imprimirCancionesBusqueda">
			<ul>
				<li>Título: ${cancion.titulo} </li>
				<li>Pista de audio: <audio controls="controls">
					<source src="${"Canciones/"+cancion.urlfichero}" type="audio/mpeg">
					</audio> </li>
				<li>Album: ${cancion.album} </li>
				<li>Duración: ${cancion.duracion} </li>
				<li>Pública: ${cancion.publica} </li>
				
			</ul>
		</div>
		<input type="button" value="Letra Canción" onclick="buscarLetra('${cancion.titulo}');"/>
		<input type="button" value="Borrar Canción" onclick="borrarCancion(${cancion.idCancion}, '${cancion.urlfichero}')" />
	
		`;
	}
	 divListaCanciones.innerHTML = html;
	
}

function buscarLetra(titulo) {
	let url = "http://localhost:8080/CancionesLetrasREST/api/titulo/" + titulo;
	axios.get(url)
		.then(respuesta => {
			imprimirLetra(respuesta.data);
		})
		. catch(error => {
			console.error(error);
		})
}

function imprimirLetra(cancion) {
	let divLetra = document.getElementById("divLetraCancion");
	divLetra.innerHTML = '<pre>'+ cancion.letra +'</pre>';
}



function borrarCancion(idCancion, urlFichero) {
	
	axios.post(
			"BorrarCanciones", 
			null, 
			{params: {cancion: idCancion, fichero:urlFichero}}
		).then(function(respuesta) {
			// se llama de nuevo a buscarCancion para que busque la canción que queremos borrar antes de borrarla
			console.log("Respuesta: "+ respuesta.data)
			buscarCanciones(respuesta.data);
		}).catch(function(error){
			console.log(error);
		});
}