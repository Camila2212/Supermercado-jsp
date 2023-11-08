/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class DetalleC {
    private int idDC;
    private int cantidad;
    private int subTotal;
    private String idProd;
    private int idF;
    private int paginacion = 0;

    public DetalleC() {
    }

    public int getIdDC() {
        return idDC;
    }

    public void setIdDC(int idDC) {
        this.idDC = idDC;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

     public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }
    

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
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
        ArrayList listaDC= new ArrayList();
        DetalleC elDC;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idDC";
               
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idDC LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                ResultSet rs = st.executeQuery(listado);
                while (rs.next()) {
                    elDC = new DetalleC();
                    elDC.setIdDC(rs.getInt("idDC"));
                    elDC.setCantidad(rs.getInt("cantidad"));
                    elDC.setSubTotal(rs.getInt("subTotal"));
                    elDC.setIdProd(rs.getString("idProd"));
                    elDC.setIdF(rs.getInt("idF"));
                    listaDC.add(elDC);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar Detalle Compra " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaDC;
        }

     public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            
            String qry = "INSERT INTO DetalleC (idDC, cantidad, subTotal, idProd, idF)"
                    + " VALUES(" + null + ",'" + getCantidad() + "','" + getSubTotal() + "','" + getIdProd() + "','" + getIdF()+"')";
            st.executeUpdate(qry);
            conexion.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Detalle Compra: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE DetalleC SET cantidad ='" + getCantidad() + "', subTotal ='" + getSubTotal() + "', idProd ='" + getIdProd()
                    + "', idF ='" + getIdF() + "'WHERE idDC =" + getIdDC());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Detalle Compra: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        System.out.println("entra al eliminar");
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "DELETE FROM DetalleC WHERE idDC = " + getIdDC();
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar DetalleC: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idDC)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas DetalleC " + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }

   
    
}
