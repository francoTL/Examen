package controlador;

import java.io.IOException;
//import java.sql.Date;
//import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.RegistrarDao;

/**
 * Servlet implementation class ServletMascota
 */
public class ServletMascota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMascota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rutDueño, tipoMascota, nombreMascota, msg="";
		String fecha;
		String hora;
		int edad;		
		//---datos mascota----		
		rutDueño = request.getParameter("rutDueño2");
		tipoMascota = request.getParameter("tipoMascota");	
		edad = Integer.parseInt(request.getParameter("edad"));
		nombreMascota = request.getParameter("nombreMascota");
		fecha = request.getParameter("fecha");
		hora = request.getParameter("hora");
			try {
				if(RegistrarDao.registrarMascota(rutDueño, tipoMascota, edad, nombreMascota)>0 
						&& RegistrarDao.registrarAgenda(rutDueño, nombreMascota, fecha, hora)>0) {
					msg = "Mascota y cita registrada con éxito";
					msg = msg.toUpperCase();		
					RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");		
					request.setAttribute("mensaje", msg);	
					despachador.forward(request, response);
				}else {
					msg = "Error al registrar mascota";
					msg = msg.toUpperCase();		
					RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");		
					request.setAttribute("mensaje", msg);	
					despachador.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			
			}		
				
		}

}
