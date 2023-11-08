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

/**
 *
 * @author camil
 */
@WebServlet(name = "ControladorMenu", urlPatterns = {"/ControladorMenu"})
public class ControladorMenu extends HttpServlet {

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
        String opcion = request.getParameter("opcion");
       
        switch (opcion) {
             case "Home":
                request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
                 break;
            case "Administrador":
                request.getRequestDispatcher("/WEB-INF/formularioAdmin.jsp").forward(request, response);
                break;
            case "Producto":
                request.getRequestDispatcher("/WEB-INF/formularioProd.jsp").forward(request, response);
                break;
            case "Cliente":
                request.getRequestDispatcher("/WEB-INF/formularioClientes.jsp").forward(request, response);
                break;
            case "Proveedor":
                request.getRequestDispatcher("/WEB-INF/formularioProv.jsp").forward(request, response);

            case "FC":
                request.getRequestDispatcher("/WEB-INF/formularioFC.jsp").forward(request, response);

            case "DC":
                request.getRequestDispatcher("/WEB-INF/formularioDC.jsp").forward(request, response);
            
            case "FV":
                request.getRequestDispatcher("/WEB-INF/formularioFV.jsp").forward(request, response);
            case "DV":
                request.getRequestDispatcher("/WEB-INF/formularioDV.jsp").forward(request, response);
            case "CC":
                request.getRequestDispatcher("/WEB-INF/crearCuenta.jsp").forward(request, response);
            case "IS":
                request.getRequestDispatcher("index.html").forward(request, response);

//            case "Auditoria":
//                request.getRequestDispatcher("/WEB-INF/formularioAdmin"+opcion+".jsp").forward(request, response);
            default:
//                
                request.getRequestDispatcher("/index.html").forward(request, response);
                System.out.println("no hay opcion");
                break;
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
        processRequest(request, response);
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
