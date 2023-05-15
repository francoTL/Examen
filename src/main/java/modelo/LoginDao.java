package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.Conexion;
public class LoginDao {
	
	public static int validar(String user, String pass) {
		
		Connection con;
		Conexion cn = new Conexion();		
		PreparedStatement ps;
		ResultSet rs;
		String us = "";
		int valido =0;
		String sql = "select * from clinica.usuario where nombreUsuario = ? and password = ?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = rs.getString("id");
			}
			if(us.length()>0){
				valido=1;			
			}else {
				valido=0;
			}		
		}catch(Exception e) {
			
		}		
		return valido;
	}	
	
	
}
