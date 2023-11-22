/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import Conexion.ConexionMySQL;
import java.sql.Connection;

/**
 *
 * @author LEIDY GIRALDO
 */
public abstract class AutentificacionDecorator implements IniciarSesion{
    protected IniciarSesion is;
    ConexionMySQL con ;
    Connection conet; 
    public AutentificacionDecorator(IniciarSesion is) {
        this.is = is;
    }
    
    public boolean iniciarSesion(String usuario, String contrasenia){
        return is.iniciarSesion(usuario, contrasenia);
    }
            
            
    
    
}
