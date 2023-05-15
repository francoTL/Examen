package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.RegistrarDao;

/**
 * Servlet implementation class ServletDueno
 */
public class ServletDueno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDueno() {
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
		String rutDueño, nombre, apellido, direccion, correo, msg="";;
		int telefono;
		//----datos dueño--
		rutDueño = request.getParameter("rutDueño1");
		nombre = request.getParameter("nombre");
		apellido = request.getParameter("apellido");
		direccion = request.getParameter("direccion");
		correo = request.getParameter("correo");
		telefono = Integer.parseInt(request.getParameter("telefono"));
		
		try {
			if(RegistrarDao.registrarDueno(rutDueño, nombre, apellido, direccion, correo, telefono)>0) {
				msg = "Dueño registrado con éxito";
				msg = msg.toUpperCase();		
				RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");		
				request.setAttribute("mensaje", msg);	
				despachador.forward(request, response);
			}else {
				msg = "Error al registrar dueño";
				msg = msg.toUpperCase();		
				RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");		
				request.setAttribute("mensaje", msg);	
				despachador.forward(request, response);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
				
	}

}
