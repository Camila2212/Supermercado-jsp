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
public class FacturaComp {
    private int idF;
    private int dtoF;
    private String descripcion;
    private LocalDate fechaF;
    private int totalF;
    private String idAdmin;
    private String idProv;
    private int paginacion = 0;

    public FacturaComp() {
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public int getDtoF() {
        return dtoF;
    }

    public void setDtoF(int dtoF) {
        this.dtoF = dtoF;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
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
        ArrayList listaFC = new ArrayList();
        FacturaComp laFC;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idF";
           
    
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idF LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                
                ResultSet rs = st.executeQuery(listado);
             
                while (rs.next()) {
                    laFC = new FacturaComp();
                    laFC.setIdF(rs.getInt("idF"));
                    laFC.setDtoF(rs.getInt("dtoF"));
                    laFC.setDescripcion(rs.getString("descripcion"));
                    laFC.setFechaF(rs.getDate("fechaF").toLocalDate());
                    laFC.setTotalF(rs.getInt("totalF"));
                    laFC.setIdAdmin(rs.getString("idAdmin"));
                    laFC.setIdProv(rs.getString("idProv"));
                    listaFC.add(laFC);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar Factura Compra " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaFC;
        }
    
    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            System.out.println("entra al insertar");
            String qry = "INSERT INTO FacturaComp (idF, dtoF, descripcion, fechaF, totalF, idAdmin, idProv)"
                    + " VALUES(" + null + ",'" + getDtoF() + "','" + getDescripcion() + "','" + fechaF + "','" + getTotalF() + "','" + getIdAdmin() + "','" + getIdProv() +"')";
            st.executeUpdate(qry);
            conexion.desconectar();
            System.out.println("mi prov"+idProv);
        } catch (SQLException ex) {
            System.err.println("Error al insertar Factura Compra: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE FacturaComp SET dtoF ='" + getDtoF() + "', descripcion ='" + getDescripcion() + "', fechaF ='" + getFechaF()
                    + "', totalF ='" + getTotalF() + "', idAdmin ='" + getIdAdmin() + "', idProv ='" + getIdProv() + "'WHERE idF =" + getIdF());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Factura Compra: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "DELETE FROM FacturaComp WHERE idF = " + getIdF();
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Factura Compra: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idF)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas Factura Compra " + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }

    
}
