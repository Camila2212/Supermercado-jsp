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
import modelo.Administrador;
/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorAdmin", urlPatterns = {"/ControladorAdmin"})
public class ControladorAdmin extends HttpServlet {

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
            out.println("<title>Servlet ControladorAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAdmin at " + request.getContextPath() + "</h1>");
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
        System.out.println("entra al dopost");
        String id = request.getParameter("fIdAdmin");
        String nombre = request.getParameter("fNombre");
        String apellido = request.getParameter("fApellido");
        String cedula = request.getParameter("fCedula");
        String telefono = request.getParameter("fTelefono");
        String correo = request.getParameter("fCorreo");
        String direccion = request.getParameter("fDireccion");
        String accion = request.getParameter("fAccion");
        
        int idAdmin=0;
        try {
            idAdmin = Integer.parseInt(id);
            System.out.println("idAdmin "+idAdmin);
        } catch (NumberFormatException nfe) {
            
        }
        
        
 Administrador unAdmin = new Administrador();
        unAdmin.setIdAdmin(idAdmin);
        unAdmin.setNombre(nombre);
        unAdmin.setApellido(apellido);
        unAdmin.setCedula(cedula);
        unAdmin.setTelefono(telefono);
        unAdmin.setCorreo(correo);
        unAdmin.setDireccion(direccion);


        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar" -> {
                System.out.println("entra el insertar");
                unAdmin.insertar();
                System.out.println("insertar Administrador");
                mensaje = "Inserto Administrador";
            }

            case "modificar" -> {
                System.out.println("entra al modificar");
                unAdmin.modificar();
                mensaje = "Modifico Administrador";
            }
            case "eliminar" -> {
                System.out.println("eliminando Administrador");
                unAdmin.eliminar();
                mensaje = "Elimino Administrador";
            }

        }
        request.getRequestDispatcher("/WEB-INF/formularioAdmin.jsp?msj=" + mensaje).forward(request, response);

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
