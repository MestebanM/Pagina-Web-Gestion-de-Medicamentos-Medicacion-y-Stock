/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import Conexion.ConexionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LEIDY GIRALDO
 */
public class InicioFarmaceuticoDecorator extends AutentificacionDecorator{
    
    public InicioFarmaceuticoDecorator(IniciarSesion is) {
        super(is);
        con=new ConexionMySQL();
        conet= con.conectar(); 
    }
    
     @Override
    public boolean iniciarSesion(String usuario, String contrasenia) {
       try {
            // Consulta SQL para buscar un usuario por su nombre en la base de datos
            String sql = "SELECT * FROM farmaceuta WHERE contrasenia = ?;";
            try (PreparedStatement statement = conet.prepareStatement(sql)) {                
                 statement.setString(1, contrasenia);
                 
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String contrasenaAlmacenada = resultSet.getString("contrasenia");

                        // Aquí deberías verificar la contraseña usando un algoritmo de hash como bcrypt
                        // Comparar el hash de la contraseña proporcionada con el hash almacenado en la base de datos
                        if (contrasenia.equals(contrasenaAlmacenada)) {
                            return true; // Las credenciales son válidas
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en un entorno de producción
        }

        return false; // Las credenciales no son válidas
    }
    
    
}
