/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LEIDY GIRALDO
 */
public class ConexionMySQL {
    private String driver = "com.mysql.jdbc.Driver";
    private String cadenaConeccion = "jdbc:mysql://127.0.01/hospital";
    private String usuario = "root";
    private String password = "";
    public Connection con;
    
    public ConexionMySQL() {
        
    }
    
    
    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(cadenaConeccion, usuario, password);
            //JOptionPane.showMessageDialog(null, "Se ha podido establecer la coneccion");
            return con;
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "No se ha podido establecer la coneccion"+e.getMessage());
        }
        return null;
    }
    
    
    
}
