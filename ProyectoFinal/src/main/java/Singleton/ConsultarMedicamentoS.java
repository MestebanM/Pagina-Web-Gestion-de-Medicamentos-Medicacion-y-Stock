/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import Conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Medicamentos;
/**
 *
 * @author LEIDY GIRALDO
 */
public class ConsultarMedicamentoS {

    private static ConsultarMedicamentoS CM;
    ConexionMySQL con;
    Connection conet;
    Statement ejecutor;
    ResultSet rs;

    private ConsultarMedicamentoS() {
        con = new ConexionMySQL();
        conet = con.conectar();
    }

    public static ConsultarMedicamentoS getInstance() {
        if (CM == null) {
            CM = new ConsultarMedicamentoS();
        }
        return CM;
    }

    public List<Medicamentos> consultar() {
        String consulta = "SELECT * FROM medicamentos";
         List<Medicamentos> items = new ArrayList<>();
        try (PreparedStatement statement = conet.prepareStatement(consulta)) {
                
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String nombreMedicamento = resultSet.getString("nombre_medicamento");
                    String stock = resultSet.getString("stock_medicamento");                    
                    Medicamentos medi= new Medicamentos(nombreMedicamento, stock);
                    items.add(medi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

}
