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
import modelo.Producto;

/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorProd", urlPatterns = {"/ControladorProd"})
public class ControladorProd extends HttpServlet {

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
            out.println("<title>Servlet ControladorProd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProd at " + request.getContextPath() + "</h1>");
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
       String id = request.getParameter("fIdProd");
        String nombre = request.getParameter("fNombre");
        String descripcion = request.getParameter("fDescripcion");
        String precioP = request.getParameter("fPrecio");
        String cantidadP = request.getParameter("fCantidad");
        String accion = request.getParameter("fAccion");
        
        int idProd = 0;
        try {
            idProd = Integer.parseInt(id);
            System.out.println("idProd "+ idProd);
        } catch (NumberFormatException nfe) {
            
        }
        
        int precio = 0;
        try {
            precio = Integer.parseInt(precioP);
            System.out.println("precio "+ precio);
        } catch (NumberFormatException nfe) {
            
        }
        
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(cantidadP);
            System.out.println("cantidad "+ cantidad);
        } catch (NumberFormatException nfe) {
            
        }     
        
              
 Producto unProd = new Producto();
        unProd.setIdProd(idProd);
        unProd.setNombre(nombre);
        unProd.setDescripcion(descripcion);
        unProd.setPrecio(precio);
        unProd.setCantidad(cantidad);
        


        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar" -> {
                System.out.println("entra el insertar");
                unProd.insertar();
                System.out.println("insertar Producto");
                mensaje = "Inserto un Producto";
            }

            case "modificar" -> {
                System.out.println("entra al modificar");
                unProd.modificar();
                mensaje = "Modifico un Producto";
            }
            case "eliminar" -> {
                System.out.println("eliminando Administrador");
                unProd.eliminar();
                mensaje = "Elimino un Producto";
            }

        }
        request.getRequestDispatcher("/WEB-INF/formularioProd.jsp?msj=" + mensaje).forward(request, response);

        
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
