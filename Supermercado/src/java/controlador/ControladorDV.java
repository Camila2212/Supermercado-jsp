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
import modelo.DetalleV;
/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorDV", urlPatterns = {"/ControladorDV"})
public class ControladorDV extends HttpServlet {

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
            out.println("<title>Servlet ControladorDV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDV at " + request.getContextPath() + "</h1>");
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
    String id = request.getParameter("fIdDV");
        String cantidadDC = request.getParameter("fCantidad");
        String subTotalDC = request.getParameter("fSubTotal");
        String idProd = request.getParameter("fIdProd");
        String idF = request.getParameter("fIdFV");
        String accion = request.getParameter("fAccion");
        
        int idDV = 0;
        try {
            idDV = Integer.parseInt(id);
            System.out.println("idDV "+ idDV);
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
        
        
        
        
               
        int idFV = 0;
        try {
            idFV = Integer.parseInt(idF);
            System.out.println("idFV "+ idFV);
        } catch (NumberFormatException nfe) {
            
        }     
        
              
        DetalleV unDV = new DetalleV();
        unDV.setIdDV(idDV);
        unDV.setCantidad(cantidad);
        unDV.setSubTotal(subTotal);
        unDV.setIdProd(idProd);
        unDV.setIdFV(idFV);
        


        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar" -> {
                unDV.insertar();
                mensaje = "Inserto un Detalle Venta";
            }

            case "modificar" -> {
                unDV.modificar();
                mensaje = "Modifico un Detalle Venta";
            }
            case "eliminar" -> {
                unDV.eliminar();
                mensaje = "Elimino un Detalle Venta";
            }

        }
        request.getRequestDispatcher("/WEB-INF/formularioDV.jsp?msj=" + mensaje).forward(request, response);

        
       
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
