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
public class DetalleV {
    private int idDV;
    private int cantidad;
    private int subTotal;
    private String idProd;
    private int idFV;
    private int paginacion = 0;

    public DetalleV() {
    }

    public int getIdDV() {
        return idDV;
    }

    public void setIdDV(int idDV) {
        this.idDV = idDV;
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

    public int getIdFV() {
        return idFV;
    }

    public void setIdFV(int idFV) {
        this.idFV = idFV;
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
        ArrayList listaDV= new ArrayList();
        DetalleV elDV;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idDV";
               
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idDV LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                ResultSet rs = st.executeQuery(listado);
                while (rs.next()) {
                    elDV = new DetalleV();
                    elDV.setIdDV(rs.getInt("idDV"));
                    elDV.setCantidad(rs.getInt("cantidad"));
                    elDV.setSubTotal(rs.getInt("subTotal"));
                    elDV.setIdProd(rs.getString("idProd"));
                    elDV.setIdFV(rs.getInt("idFV"));
                    listaDV.add(elDV);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar Detalle Venta " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaDV;
        }

     public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            
            String qry = "INSERT INTO DetalleV (idDV, cantidad, subTotal, idProd, idFV)"
                    + " VALUES(" + null + ",'" + getCantidad() + "','" + getSubTotal() + "','" + getIdProd() + "','" + getIdFV()+"')";
            st.executeUpdate(qry);
            conexion.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Detalle Venta: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE DetalleV SET cantidad ='" + getCantidad() + "', subTotal ='" + getSubTotal() + "', idProd ='" + getIdProd()
                    + "', idFV ='" + getIdFV() + "'WHERE idDV =" + getIdDV());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Detalle Venta: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        System.out.println("entra al eliminar");
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "DELETE FROM DetalleV WHERE idDV = " + getIdDV();
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar DetalleV: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idDV)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas DetalleV " + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
}
