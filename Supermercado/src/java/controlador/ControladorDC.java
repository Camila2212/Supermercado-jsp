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
import modelo.DetalleC;

/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorDC", urlPatterns = {"/ControladorDC"})
public class ControladorDC extends HttpServlet {

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
            out.println("<title>Servlet ControladorDC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDC at " + request.getContextPath() + "</h1>");
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
       String id = request.getParameter("fIdDC");
        String cantidadDC = request.getParameter("fCantidad");
        String subTotalDC = request.getParameter("fSubTotal");
        String idProd = request.getParameter("fIdProd");
        String idFa = request.getParameter("fIdF");
        String accion = request.getParameter("fAccion");
        
        int idDC = 0;
        try {
            idDC = Integer.parseInt(id);
            System.out.println("idDC "+ idDC);
        } catch (NumberFormatException nfe) {   
        }
        
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(cantidadDC);
            System.out.println("cantidad "+ cantidad);
        } catch (NumberFormatException nfe) {   
        }
        
        int subTotal = 0;
        try {
            subTotal = Integer.parseInt(subTotalDC);
            System.out.println("subTotal "+ subTotal);
        } catch (NumberFormatException nfe) {   
        }
        
        
        
        
               
        int idF = 0;
        try {
            idF = Integer.parseInt(idFa);
            System.out.println("idF "+ idF);
        } catch (NumberFormatException nfe) {
            
        }     
        
              
        DetalleC unDC = new DetalleC();
        unDC.setIdDC(idDC);
        unDC.setCantidad(cantidad);
        unDC.setSubTotal(subTotal);
        unDC.setIdProd(idProd);
        unDC.setIdF(idF);
        


        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar" -> {
                unDC.insertar();
                mensaje = "Inserto un Detalle Compra";
            }

            case "modificar" -> {
                unDC.modificar();
                mensaje = "Modifico un Detalle Compra";
            }
            case "eliminar" -> {
                unDC.eliminar();
                mensaje = "Elimino un Detalle Compra";
            }

        }
        request.getRequestDispatcher("/WEB-INF/formularioDC.jsp?msj=" + mensaje).forward(request, response);

        
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
