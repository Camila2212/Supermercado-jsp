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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import modelo.FacturaVent;


/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorFV", urlPatterns = {"/ControladorFV"})
public class ControladorFV extends HttpServlet {

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
            out.println("<title>Servlet ControladorFV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFV at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("fIdFV");
        String dto = request.getParameter("fDtoF");
        String fecha = request.getParameter("fFechaF");
        String total = request.getParameter("fTotalF");
        String idA = request.getParameter("fIdAdmin");
        String idCl = request.getParameter("fIdC");
        String accion = request.getParameter("fAccion");
        int idFV=0;
        try {
            idFV = Integer.parseInt(id);
            System.out.println("idFV "+idFV);
        } catch (NumberFormatException nfe) {
            
        }
        int dtoF=0;
        try {
            dtoF = Integer.parseInt(dto);
            System.out.println("dtoF "+dtoF);
        } catch (NumberFormatException nfe) {
            
        }
        
         LocalDate fechaF = LocalDate.now();
        try {
            fechaF = LocalDate.parse(fecha);
            System.out.println("fechaF "+fechaF);
        } catch (DateTimeParseException dtpe) {
        }
                
        
        int totalF=0;
        try {
            totalF = Integer.parseInt(total);
            System.out.println("totalF "+totalF);
        } catch (NumberFormatException nfe) {
        }
        
        int idAdmin=0;
        try {
            idAdmin = Integer.parseInt(idA);
            System.out.println("idAdmin "+idAdmin);
        } catch (NumberFormatException nfe) {
            
        }
        int idC=0;
        try {
            idC = Integer.parseInt(idCl);
            System.out.println("idC"+idC);
        } catch (NumberFormatException nfe) {
            
        }
        
        
 FacturaVent unaFV = new FacturaVent();
        unaFV.setIdFV(idFV);
        unaFV.setDtoF(dtoF);
        unaFV.setFechaF(fechaF);
        unaFV.setTotalF(totalF);
        unaFV.setIdAdmin(idAdmin);
        unaFV.setIdC(idC);


        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar" -> {
                unaFV.insertar();
                mensaje = "Inserto Factura Venta";
            }

            case "modificar" -> {
                unaFV.modificar();
                mensaje = "Modifico Factura Venta";
            }
            case "eliminar" -> {
                unaFV.eliminar();
                mensaje = "Elimino Factura Venta";
            }

        }
        request.getRequestDispatcher("/WEB-INF/formularioFV.jsp?msj=" + mensaje).forward(request, response);

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
