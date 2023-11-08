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
public class Proveedor {
    
    private int idProv;
    private String nombre;
    private String nit;
    private String telefono;
    private String correo;
    private int paginacion = 0;

    public Proveedor() {
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        ArrayList listaProv= new ArrayList();
        Proveedor elProv;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idProv";
               
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idProv LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                ResultSet rs = st.executeQuery(listado);
                while (rs.next()) {
                    elProv = new Proveedor();
                    elProv.setIdProv(rs.getInt("idProv"));
                    elProv.setNombre(rs.getString("nombre"));
                    elProv.setNit(rs.getString("nit"));
                    elProv.setTelefono(rs.getString("telefono"));
                    elProv.setCorreo(rs.getString("correo"));
                    listaProv.add(elProv);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar Proveedor " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaProv;
        }
    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            
            String qry = "INSERT INTO Proveedor (idProv, nombre, nit, telefono, correo)"
                    + " VALUES(" + null + ",'" + getNombre() + "','" + getNit() + "','" + getTelefono() + "','" + getCorreo()+"')";
            System.out.println("query "+qry);
            st.executeUpdate(qry);
            conexion.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Proveedor: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        System.out.println("entra el modificar");
        try {
            System.out.println("entra al sout try");
            st.executeUpdate("UPDATE Proveedor SET nombre ='" + getNombre() + "', nit ='" + getNit() + "', telefono ='" + getTelefono()
                    + "', correo ='" + getCorreo() + "'WHERE idProv =" + getIdProv());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Proveedor: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        System.out.println("entra a eliminar");
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "DELETE FROM Proveedor WHERE idProv = " + getIdProv();
            System.out.println("antes de ejecutar el query eliminar");
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Proveedor: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idProv)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas Proveedor " + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
}
