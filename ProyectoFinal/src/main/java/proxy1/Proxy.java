/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy1;



/**
 *
 * @author marin
 */
public class Proxy implements Medicamento{
    Eliminar eliminar;
    
    
    @Override
    public void eliminar(String id) {        
            eliminar= new Eliminar();
            eliminar.eliminar(id);       
    }
    
  
    
}
