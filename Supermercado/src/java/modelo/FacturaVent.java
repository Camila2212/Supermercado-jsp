/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class FacturaVent {
        private int idFV;
    private int dtoF;
    private LocalDate fechaF;
    private int totalF;
    private int idAdmin;
    private int idC;
    private int paginacion = 0; 

    public FacturaVent() {
    }

    public int getIdFV() {
        return idFV;
    }

    public void setIdFV(int idFV) {
        this.idFV = idFV;
    }

    public int getDtoF() {
        return dtoF;
    }

    public void setDtoF(int dtoF) {
        this.dtoF = dtoF;
    }

    public LocalDate getFechaF() {
        return fechaF;
    }

    public void setFechaF(LocalDate fechaF) {
        this.fechaF = fechaF;
    }

    public int getTotalF() {
        return totalF;
    }

    public void setTotalF(int totalF) {
        this.totalF = totalF;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(int paginacion) {
        this.paginacion = paginacion;
    }

    public ArrayList listar(int pagina){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaFV = new ArrayList();
        FacturaVent laFV;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idFV";
    
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idFV LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                ResultSet rs = st.executeQuery(listado);
                while (rs.next()) {
                    laFV = new FacturaVent();
                    laFV.setIdFV(rs.getInt("idFV"));
                    laFV.setDtoF(rs.getInt("dtoF"));
                    laFV.setFechaF(rs.getDate("fechaF").toLocalDate());
                    laFV.setTotalF(rs.getInt("totalF"));
                    laFV.setIdAdmin(rs.getInt("idAdmin"));
                    laFV.setIdC(rs.getInt("idC"));
                    listaFV.add(laFV);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar Factura Compra " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaFV;
        }
    
    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "INSERT INTO FacturaVent (idFV, dtoF, fechaF, totalF, idAdmin, idC)"
                    + " VALUES(" + null + ",'" + getDtoF() + "','" + fechaF + "','" + getTotalF() + "','" + getIdAdmin() + "','" + getIdC() +"')";
            st.executeUpdate(qry);
            conexion.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Factura Venta: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE FacturaVent SET dtoF ='" + getDtoF() + "', fechaF ='" + getFechaF()
                    + "', totalF ='" + getTotalF() + "', idAdmin ='" + getIdAdmin() + "', idC ='" + getIdC() + "'WHERE idFV =" + getIdFV());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Factura Venta: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "DELETE FROM FacturaVent WHERE idFV = " + getIdFV();
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Factura Venta: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idFV)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas Factura Venta" + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }

}
