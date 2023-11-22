/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantillaMetodo;

import Conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Medicamentos;

/**
 *
 * @author marin
 */
public class ActualizacionMedicamentos extends ActualizacionMedicamentosTemplate{

    ConexionMySQL con ;
    Connection conet;  
    Statement ejecutor;
    ResultSet rs;
    
    
    
    public ActualizacionMedicamentos(String newId, String newNombre, String newStock) {
        super(newId, newNombre, newStock);
        con=new ConexionMySQL();
        conet= con.conectar(); 
        
    }

    @Override
    protected Medicamentos obtenerMedicamento(String newId) {
        // Consulta para obtener el medicamento por ID      
        Medicamentos medicamento = null;
            String consulta = "SELECT * FROM medicamento WHERE id = ?";
           try (PreparedStatement statement = conet.prepareStatement(consulta)) {                
                 statement.setString(1, newId);

            // Ejecutar la consulta
           try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                         medicamento = new Medicamentos();
                         medicamento.setId(resultSet.getString("id"));
                         medicamento.setNombre(resultSet.getString("nombre"));
                         medicamento.setStock(resultSet.getString("stock"));
                    }
                }

            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
     return medicamento;
    }

    @Override
    protected void actualizarInformacion(Medicamentos medicamento) {
         medicamento.setId(super.newId);
       medicamento.setNombre(super.newNombre);
        medicamento.setStock(super.newStock);
    }

    @Override
    protected void guardarEnBaseDeDatos(Medicamentos medicamento) {
        String consulta = "UPDATE medicamento SET nombre = ?, stock = ? WHERE id = ?";
         try (PreparedStatement statement = conet.prepareStatement(consulta)) {
             statement.setString(1, medicamento.getNombre());
             statement.setString(2, medicamento.getStock());
             statement.setString(3, medicamento.getId());

            // Ejecutar la consulta de actualización
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    @Override
    protected void notificarActualizacion(Medicamentos medicamento) {
        System.out.println("El medicamento con ID " + medicamento.getId() + " ha sido actualizado.");
    }
}
    

