/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy1;


import Conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LEIDY GIRALDO
 */
public class Eliminar implements Medicamento {

    ConexionMySQL con;
    Connection conet;
    Statement ejecutor;
    ResultSet rs;

    public Eliminar() {
        con = new ConexionMySQL();
        conet = con.conectar();

    }

    @Override
    public void eliminar(String id) {
        // Consulta SQL para buscar un usuario por su nombre en la base de datos
        String sql = "DELETE FROM medicamento WHERE id = ?";
        try (PreparedStatement statement = conet.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en un entorno de producción
        }
    }

}
