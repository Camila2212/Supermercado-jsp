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
public class Producto {
    
    private int idProd;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;
    private int paginacion = 0;

    public Producto() {
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        ArrayList listaProd= new ArrayList();
        Producto elProd;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idProd";
               
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idProd LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                ResultSet rs = st.executeQuery(listado);
                System.out.println("ejecuta el query");
                while (rs.next()) {
                    elProd = new Producto();
                    elProd.setIdProd(rs.getInt("idProd"));
                    elProd.setNombre(rs.getString("nombre"));
                    elProd.setDescripcion(rs.getString("descripcion"));
                    elProd.setPrecio(rs.getInt("precio"));
                    elProd.setCantidad(rs.getInt("cantidad"));
                    listaProd.add(elProd);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar Producto " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaProd;
        }
    
    
    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            
            String qry = "INSERT INTO Producto (idProd, nombre, descripcion, precio, cantidad)"
                    + " VALUES(" + null + ",'" + getNombre() + "','" + getDescripcion() + "','" + getPrecio() + "','" + getCantidad()+"')";
            System.out.println("query "+qry);
            st.executeUpdate(qry);
            conexion.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Producto: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        System.out.println("entra el modificar");
        try {
            System.out.println("entra al sout try");
            st.executeUpdate("UPDATE Producto SET nombre ='" + getNombre() + "', descripcion ='" + getDescripcion() + "', precio ='" + getPrecio()
                    + "', cantidad ='" + getCantidad() + "'WHERE idProd =" + getIdProd());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Producto: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        System.out.println("entra a eliminar");
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "DELETE FROM Producto WHERE idProd = " + getIdProd();
            System.out.println("antes de ejecutar el query eliminar");
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Producto: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idProd)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas Producto " + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
}
