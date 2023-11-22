/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import Conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LEIDY GIRALDO
 */
public class GeneradorOrden {
    private List<Observador> observadores = new ArrayList<>();
    ConexionMySQL con;
    Connection conet;
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
        con = new ConexionMySQL();
        conet = con.conectar();
    }

    public void generarOrden(String nombre, String stock, String numero) {
         String sql = "INSERT INTO orden (nombre, stock, numero) VALUES (?, ?, ?)";
        
        try (PreparedStatement statement = conet.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, stock);
            statement.setString(3, numero);

            // Ejecutar la inserción
            statement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        // Manejar la excepción apropiadamente en tu aplicación
    }

        // Notificar a los observadores
        notificarObservadores("Se generó una nueva orden: " + nombre +" y un stock de: "+ stock);
    }

    private void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.notificar(mensaje);
        }
    }
}
