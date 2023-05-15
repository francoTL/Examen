<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clinica</title>
</head>
<body>
	<h1>Registro de mascota</h1>
	<h3>Ingresar datos del dueño</h3>	
	<form action="ServletDueno" method="post">
		<table style="border: 1px solid black; border-spacing: 10px;">
			 <tr>	    
				<td><label for="rutDueño1">Rut: </label></td>
				<td><input type="text" name="rutDueño1" id="rutDueño1" required /></td>
			</tr>
			 <tr>		
				<td><label for="nombre">Nombre: </label></td>
				<td><input type="text" name="nombre" id="nombre" required /></td>
			</tr>
			 <tr>				
				<td><label for="apellido">Apellido: </label></td>
				<td><input type="text" name="apellido" id="apellido" required /></td>
			</tr>
			 <tr>			
				<td><label for="direccion">Dirección: </label></td>
				<td><input type="text" name="direccion" id="direccion" required /></td>
			</tr>
			 <tr>		
				<td><label for="correo">Correo: </label></td>
				<td><input type="email" name="correo" id="correo" required /></td>
			</tr>
			 <tr>		
				<td><label for="telefono">Teléfono: </label></td>
				<td><input type="number" name="telefono" id="telefono" required /></td>	
			</tr>
			 <tr>		
				<td><br><input type="submit" value="Guardar" id="guardaDueñorbtn"/></td>
			</tr>
		</table>
	</form>
	
	<br><br>
	
	<h3>Ingresar datos de la mascota y citación</h3>
	<form action="ServletMascota" method="post">
		<table style="border: 1px solid black; border-spacing: 10px;">
			 <tr>
			    <td><label for="rutDueño2">Rut: </label></td>
				<td><input type="text" name="rutDueño2" id="rutDueño2" required/></td>
			</tr>
			 <tr>
	 			<td><label for="tipoMascota">Tipo: </label></td>
				<td><input type="text" name="tipoMascota" id="tipoMascota" required/></td>
			</tr>
			  <tr>
				<td><label for="edad">Edad: </label></td>
				<td><input type="number" name="edad" id="edad" required/></td>
			</tr>
			  <tr>
				<td><label for="nombreMascota">Nombre: </label></td>
				<td><input type="text" name="nombreMascota" id="nombreMascota" required/></td>
			</tr>
			<tr>
			    <td><label for="fecha">Fecha de cita: </label></td>
			    <td><input type="date" name="fecha" id="fecha" required/></td>
			  </tr>
			  <tr>
			    <td><label for="hora">Hora de cita: </label></td>
			    <td><input type="time" name="hora" id="hora" required/></td>
			  </tr>
			  <tr>
			  <tr>		
				<td><br><input type="submit" value="Guardar" id="guardarMascotabtn"/></td>
			</tr>
		</table>
	</form>
	
	<br>
<!--  	
	 	<h3>Ingresar fecha y hora de citación</h3>	
		<form action="ServletAgenda" method="post">
			<table style="border: 1px solid black; border-spacing: 10px;">
			  <tr>
			    <td><label for="fecha">Fecha: </label></td>
			    <td><input type="date" name="fecha" id="fecha" required/></td>
			  </tr>
			  <tr>
			    <td><label for="hora">Hora: </label></td>
			    <td><input type="time" name="hora" id="hora" required/></td>
			  </tr>
			  <tr>
			    <td><br><input type="submit" value="Guardar" id="guardarMascotabtn"/></td>
			  </tr>
			</table>
		</form>
-->	
</body>
</html>