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
import modelo.FacturaComp;

/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorFC", urlPatterns = {"/ControladorFC"})
public class ControladorFC extends HttpServlet {

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
            out.println("<title>Servlet ControladorFC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFC at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("fIdF");
        String dto = request.getParameter("fDtoF");
        String descripcion = request.getParameter("fDescripcion");
        String fecha = request.getParameter("fFechaF");
        String total = request.getParameter("fTotalF");
        String idAdmin = request.getParameter("fIdAdmin");
        String idProv = request.getParameter("fIdProv");
        String accion = request.getParameter("fAccion");
        System.out.println("p++++++++++++++++++++++++------"+request.getParameter("fIdProv"));
        int idF=0;
        try {
            idF = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
            
        }
        int dtoF=0;
        try {
            dtoF = Integer.parseInt(dto);
        } catch (NumberFormatException nfe) {
            
        }
        
         LocalDate fechaF = LocalDate.now();
        try {
            fechaF = LocalDate.parse(fecha);
        } catch (DateTimeParseException dtpe) {
        }
                
        
        int totalF=0;
        try {
            totalF = Integer.parseInt(total);
        } catch (NumberFormatException nfe) {
        }
        
        
        
        
 FacturaComp unaFC = new FacturaComp();
        unaFC.setIdF(idF);
        unaFC.setDtoF(dtoF);
        unaFC.setDescripcion(descripcion);
        unaFC.setFechaF(fechaF);
        unaFC.setTotalF(totalF);
        unaFC.setIdAdmin(idAdmin);
        unaFC.setIdProv(idProv);


        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar" -> {
                unaFC.insertar();
                mensaje = "Inserto Factura Compra";
            }

            case "modificar" -> {
                unaFC.modificar();
                mensaje = "Modifico Factura Compra";
            }
            case "eliminar" -> {
                unaFC.eliminar();
                mensaje = "Elimino Factura Compra";
            }

        }
        request.getRequestDispatcher("/WEB-INF/formularioFC.jsp?msj=" + mensaje).forward(request, response);

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
