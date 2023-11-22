/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Paciente;

/**
 *
 * @author LEIDY GIRALDO
 */
public class PacienteDao implements DAO<Paciente> {
   
    ConexionMySQL con ;
    Connection conet;  
    Statement ejecutor;
    ResultSet rs;
    
    public PacienteDao() {
        con=new ConexionMySQL();
        conet= con.conectar(); 
    }
    
    @Override
    public void create(Paciente ob) {         
    try {
        PreparedStatement guardar = conet.prepareStatement("INSERT INTO paciente (nombre, apellido, edad, correo,usuario,contrasenia,confircontra,genero ) VALUES (?,?,?,?,?,?,?,?) ");
        guardar.setString(1, ob.getNombre());
        guardar.setString(2, ob.getApellido());
        guardar.setString(3, ob.getEdad());
        guardar.setString(4, ob.getCorreo());
        guardar.setString(5, ob.getUsuario());
        guardar.setString(6, ob.getContrasenia());
        guardar.setString(7, ob.getConfirmarContra());
        guardar.setString(8, ob.getGenero());
        guardar.executeUpdate();
        
       //JOptionPane.showMessageDialog(null, "Los datos han sido agregados ");
    } catch (SQLException e) {
        e.printStackTrace();
    }
        
    }

}
