/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author LEIDY GIRALDO
 */
public class InicioBase implements IniciarSesion{
    

    @Override
    public boolean iniciarSesion( String usuario, String contrasenia) {
        if (validarEntrada( usuario, contrasenia)){
            return true;
        } else {
            System.out.println("Entrada no válida. Verifica tus datos.");
        }
        return false;
    }
    
        private boolean validarEntrada( String usuario, String contrasenia) {
        // Implementar lógica de validación de entrada si es necesario
        return    usuario!= null && contrasenia!= null ;
    }
}


