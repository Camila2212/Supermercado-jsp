/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class Administrador {
    
    private int idAdmin;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String direccion;
    private int paginacion = 0;

//    Este es el contructor
    public Administrador() {
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        ArrayList listaAdmin = new ArrayList();
        Administrador elAdmin;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idAdmin";
            System.out.println("esta es query "+listado);
    
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idAdmin LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                System.out.println("entra al try");
                ResultSet rs = st.executeQuery(listado);
                System.out.println("ejecuta el query");
                while (rs.next()) {
                    elAdmin = new Administrador();
                    elAdmin.setIdAdmin(rs.getInt("idAdmin"));
                    elAdmin.setNombre(rs.getString("nombre"));
                    elAdmin.setApellido(rs.getString("apellido"));
                    elAdmin.setCedula(rs.getString("cedula"));
                    elAdmin.setTelefono(rs.getString("telefono"));
                    elAdmin.setCorreo(rs.getString("correo"));
                    elAdmin.setDireccion(rs.getString("direccion"));
                    listaAdmin.add(elAdmin);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar administrador " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaAdmin;
        }

    
    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            
            String qry = "INSERT INTO Administrador (idAdmin, nombre, apellido, cedula, telefono, correo, direccion)"
                    + " VALUES(" + null + ",'" + getNombre() + "','" + getApellido() + "','" + getCedula() + "','" + getTelefono() + "','" + getCorreo() + "','" + getDireccion() +"')";
            System.out.println("query "+qry);
            st.executeUpdate(qry);
            conexion.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Administrador: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        System.out.println("entra el modificar");
        try {
            System.out.println("entra al sout try");
            st.executeUpdate("UPDATE Administrador SET nombre ='" + getNombre() + "', apellido ='" + getApellido() + "', cedula ='" + getCedula()
                    + "', telefono ='" + getTelefono() + "', correo ='" + getCorreo() + "', direccion ='" + getDireccion() + "'WHERE idAdmin =" + getIdAdmin());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Administrador: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        System.out.println("entra a eliminar");
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            String qry = "DELETE FROM Administrador WHERE idAdmin = " + getIdAdmin();
            System.out.println("antes de ejecutar el query eliminar");
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Administrador: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idAdmin)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas Administrador " + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
    }

