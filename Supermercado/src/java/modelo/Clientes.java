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
public class Clientes {
    
    private int idC;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String direccion;
    private String clave;

    private int paginacion = 0;

    public Clientes() {
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
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
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
        ArrayList listaCliente = new ArrayList();
        Clientes elCliente;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idC";
            
    
            if (pagina > 0) {
                int paginacionMax = pagina * this.paginacion;
                int paginacionMin = paginacionMax - this.paginacion;
                listado = "SELECT * FROM " + this.getClass().getSimpleName() + "ORDER BY idC LIMIT " + paginacionMin + "," + paginacionMax;
            }
            try {
                ResultSet rs = st.executeQuery(listado);
                while (rs.next()) {
                    elCliente = new Clientes();
                    elCliente.setIdC(rs.getInt("idC"));
                    elCliente.setNombre(rs.getString("nombre"));
                    elCliente.setApellido(rs.getString("apellido"));
                    elCliente.setCedula(rs.getString("cedula"));
                    elCliente.setTelefono(rs.getString("telefono"));
                    elCliente.setCorreo(rs.getString("correo"));
                    elCliente.setDireccion(rs.getString("direccion"));
                    elCliente.setClave(rs.getString("clave"));
                    listaCliente.add(elCliente);

                }
            } catch (SQLException ex) {
                System.err.println("Error al listar Clientes " + ex.getLocalizedMessage());
               
                System.out.println("error " + ex.getMessage());
                System.out.println("error " + ex.getSQLState());
                System.out.println("error " + ex.toString());
                System.out.println("error " + ex.getErrorCode());
            }
            conexion.desconectar();
            return listaCliente;
        }

      
    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            
            String qry = "INSERT INTO Clientes (idC, nombre, apellido, cedula, telefono, correo, direccion, clave)"
                    + " VALUES(" + null + ",'" + getNombre() + "','" + getApellido() + "','" + getCedula() + "','" + getTelefono() + "','" + getCorreo() + "','" + getDireccion() + "','" + getClave() +"')";
            st.executeUpdate(qry);
            conexion.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Cliente: " + ex.getLocalizedMessage());
        }
        
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {

            st.executeUpdate("UPDATE Clientes SET nombre ='" + getNombre() + "', apellido ='" + getApellido() + "', cedula ='" + getCedula()
                    + "', telefono ='" + getTelefono() + "', correo ='" + getCorreo() + "', direccion ='" + getDireccion() + "', clave ='" + getClave() + "'WHERE idC =" + getIdC());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Cliente: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            System.out.println("entra al try eliminar");
            String qry = "DELETE FROM Clientes WHERE idC = " + getIdC();
            int filas = st.executeUpdate(qry);
            System.out.println(qry);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Cliente: " + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public boolean iniciarSesion() {
    Conexion conexion = new Conexion();
        System.out.println("se entro al iniciar sesion");
        Statement st = conexion.conectar();
        Clientes elCliente;
        String listado = "SELECT * FROM Clientes WHERE correo ='" + getCorreo() + "' and clave ='" + getClave() +"'";
        System.out.println("ijtoa"+st);
          System.out.println(listado);
          try {
               ResultSet rs = st.executeQuery(listado);
                while (rs.next()) {
                    elCliente = new Clientes();
                    elCliente.setIdC(rs.getInt("idC"));
                    elCliente.setNombre(rs.getString("nombre"));
                    elCliente.setApellido(rs.getString("apellido"));
                    elCliente.setCedula(rs.getString("cedula"));
                    elCliente.setTelefono(rs.getString("telefono"));
                    elCliente.setCorreo(rs.getString("correo"));
                    elCliente.setDireccion(rs.getString("direccion"));
                    elCliente.setClave(rs.getString("clave"));
                    return true;
                }
          } catch (SQLException ex) {
                  System.out.println("Error al iniciar sesion:"+ ex.getLocalizedMessage());
                  }
          conexion.desconectar();
          return false;
          
      }
   
    
    
    
    
    
    
      public int cantidadPaginas() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idC)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas Clientes " + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
      
}