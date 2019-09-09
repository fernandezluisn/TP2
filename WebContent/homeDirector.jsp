<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 		
		<title>Confederación argentina de Básquetbol</title>
		<link href="CSS/estilo.css" type="text/css" rel="stylesheet"  >
		
		
</head>
	<body background="imagenes/sergio hernandez.jpg">
	<header>
	<img src="imagenes/escudo.jpg" width="100">
		<h1 style="color:black; background-color:white">Confederación Argentina de Básquetbol</h1>
	</header>
	
		<center><h2 style="color:red; background-color:black;">Bienvenido Director Tecnico</h2></center>
		<br><br>
		<div>
		<form method="post" action="DirectorTecnico">
		
		<h3 style="color:black; background-color:lightblue">Puede ingresar puntajes </h3>
		
		<br>
			<h3 style="color:black; background-color:white">Ingrese nombre del jugador</h3>
			<input type="text" id="textoNomJug" name="textoNomJug">
			<h3 style="color:black; background-color:lightblue">Ingrese apellido del jugador</h3>
			<input type="text" id="textoApeJug" name="textoApeJug">
			<h3 style="color:black; background-color:white">Ingrese puntaje del jugador</h3>
			<input type="text" id="textoApeJug" name="textoPunJug">
			<br>
			<br>
			
		<input type="submit" value="Ingresar calificaciones" id="botonCalificaciones">
		</form>
		</div>	
		<br>
		
			<a style="color:blue; background-color:white" href='index.html'>Regresar a la página de entrada.</a>
		
			
				
	
		
		
</body>
</html>