/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptador;

import Conexion.ConexionMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Medicamentos;

/**
 *
 * @author marin
 */
public class MedicamentoService implements MedicamentoService1<Medicamentos> {

    ConexionMySQL con;
    Connection conet;
    Statement ejecutor;
    ResultSet rs;

    public MedicamentoService() {
        con = new ConexionMySQL();
        conet = con.conectar();
    }



    @Override
    public void crearMedicamento(Medicamentos ob) {
         try {
            // Inserción en la base de datos
                PreparedStatement preparedStatement = conet.prepareStatement("INSERT INTO medicamento (id, nombre,stock) VALUES (?,?,?);");
                preparedStatement.setString(1, ob.getId());
                preparedStatement.setString(2, ob.getNombre());
                preparedStatement.setString(3, ob.getStock());               
                preparedStatement.executeUpdate();
            

            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
