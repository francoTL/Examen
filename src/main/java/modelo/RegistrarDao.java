package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.Conexion;

public class RegistrarDao {

public static int registrarMascota(String rut, String tipo, int edad, String nombre) {
		
		Connection con;
		Conexion cn = new Conexion();		
		PreparedStatement ps;		
		int valido =0;
		
		String sql = "INSERT INTO mascota (rutDueño, tipoMascota, edad, nombreMascota) VALUES (?, ?, ?, ?)";
	    try {
	        con = cn.getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setString(1, rut);
	        ps.setString(2, tipo);
	        ps.setInt(3, edad);
	        ps.setString(4, nombre);
	        ps.executeUpdate();
	        valido = 1;     	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return valido;
	}	


public static int registrarDueno(String rutDueño, String nombre, String apellido, String direccion, String correo, int telefono) {
	
	Connection con;
	Conexion cn = new Conexion();		
	PreparedStatement ps;		
	int valido =0;
	String sql = "INSERT INTO dueño (rut, nombre, apellido, direccion, correo, telefono) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, rutDueño);
        ps.setString(2, nombre);
        ps.setString(3, apellido);
        ps.setString(4, direccion);
        ps.setString(5, correo);
        ps.setInt(6, telefono);
        valido = ps.executeUpdate();
 	        
    } catch (Exception e) {
        e.printStackTrace();
    }
	return valido;
}


public static int registrarAgenda(String rut, String nombre, String fecha, String hora) {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps, ps1;
    int valido = 0;
    ResultSet rs;

    String sql1 = "SELECT idMascota FROM mascota WHERE nombreMascota = ?";
    try {
        con = cn.getConnection();
        ps1 = con.prepareStatement(sql1);
        ps1.setString(1, nombre);
        rs = ps1.executeQuery();
        if (rs.next()) {
            int idMascota = rs.getInt("idMascota");

            String sql = "INSERT INTO agenda (idMascota, rutDueño, nombreMascota, hora, fecha) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            ps.setString(2, rut);
            ps.setString(3, nombre);
            ps.setString(4, hora);
            ps.setString(5, fecha);
            ps.executeUpdate();
            valido = 1;
        }
    } catch (Exception e) {
        e.printStackTrace();
        // Realizar el manejo adecuado del error aquí
    }

    return valido;
}



}
