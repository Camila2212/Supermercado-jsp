/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Clientes;

/**
 *
 *
 * @author camil
 */
@WebServlet(name = "ControladorCliente", urlPatterns = {"/ControladorCliente"})
public class ControladorCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("fIdC");
        String nombre = request.getParameter("fNombre");
        String apellido = request.getParameter("fApellido");
        String cedula = request.getParameter("fCedula");
        String telefono = request.getParameter("fTelefono");
        String correo = request.getParameter("fCorreo");
        String direccion = request.getParameter("fDireccion");
        String clave = request.getParameter("fClave");
        String accion = request.getParameter("fAccion");

            System.out.println("asdasf f" + accion);
        
        int idC = 0;
        try {
            idC = Integer.parseInt(id);
            System.out.println("idC " + idC);
        } catch (NumberFormatException nfe) {

        }

        Clientes unCliente = new Clientes();
        unCliente.setIdC(idC);
        unCliente.setNombre(nombre);
        unCliente.setApellido(apellido);
        unCliente.setCedula(cedula);
        unCliente.setTelefono(telefono);
        unCliente.setCorreo(correo);
        unCliente.setDireccion(direccion);
        unCliente.setClave(clave);

        String mensaje = "";

        switch (accion.toLowerCase()) {

            case "insertar" -> {
                unCliente.insertar();
                System.out.println("insertar Cliente");
                mensaje = "Inserto Cliente";

            }
            case "crearcuenta" -> {
                unCliente.insertar();
                System.out.println("Se creo Cuenta");
                mensaje = "Inserto Cliente";
                request.getRequestDispatcher("/WEB-INF/formularioClientes.jsp?msj=" + mensaje).forward(request, response);
            }

            case "modificar" -> {
                unCliente.modificar();
                mensaje = "Modifico Cliente";
            }
            case "eliminar" -> {
                unCliente.eliminar();
                mensaje = "Elimino Cliente";
            }
            case "iniciarsesion" -> {
                boolean ini = unCliente.iniciarSesion();
                System.out.println("se inicio sesion" + ini);
                mensaje = "Iniciar sesion";
                if (ini) {
                    HttpSession session = request.getSession(true);

                    request.getRequestDispatcher("/WEB-INF/formularioClientes.jsp?msj=" + mensaje).forward(request, response);
                } else {
                    mensaje = "Error al iniciar sesion";
                    request.getRequestDispatcher("index.html?msj=" + mensaje).forward(request, response);
                }

            }
            case "cerrarsesion" -> {
               HttpSession session = request.getSession(false); // Obtén la sesión actual sin crear una nueva si no existe
                System.out.println("se esta cerrando sesion estas completamente seguro");
              if (session != null) {
              // Invalida la sesión
              session.invalidate();
              }

    // Redirige al usuario a una página de inicio de sesión o a donde desees
    response.sendRedirect("index.html"); 
}

            
        }
//       request.getRequestDispatcher("/WEB-INF/formularioClientes.jsp?msj=" + mensaje).forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
