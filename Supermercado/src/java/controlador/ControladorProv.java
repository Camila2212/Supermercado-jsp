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
import modelo.Proveedor;
/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorProv", urlPatterns = {"/ControladorProv"})
public class ControladorProv extends HttpServlet {

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
            out.println("<title>Servlet ControladorProv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProv at " + request.getContextPath() + "</h1>");
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
        
        String id = request.getParameter("fIdProv");
        String nombre = request.getParameter("fNombre");
        String nit = request.getParameter("fNit");
        String telefono = request.getParameter("fTelefono");
        String correo = request.getParameter("fCorreo");
        String accion = request.getParameter("fAccion");
        
        int idProv = 0;
        try {
            idProv = Integer.parseInt(id);
            System.out.println("idProv "+ idProv);
        } catch (NumberFormatException nfe) {
            
        }
          
             
        
              
        Proveedor unProv = new Proveedor();
        unProv.setIdProv(idProv);
        unProv.setNombre(nombre);
        unProv.setNit(nit);
        unProv.setTelefono(telefono);
        unProv.setCorreo(correo);
        


        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar" -> {
                unProv.insertar();
                mensaje = "Inserto un Proveedor";
            }

            case "modificar" -> {
                unProv.modificar();
                mensaje = "Modifico un Producto";
            }
            case "eliminar" -> {
                unProv.eliminar();
                mensaje = "Elimino un Producto";
            }

        }
        request.getRequestDispatcher("/WEB-INF/formularioProv.jsp?msj=" + mensaje).forward(request, response);

        
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
