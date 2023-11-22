/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptador;

import modelo.Medicamentos;

/**
 *
 * @author marin
 */
public class MedicamentoHTML implements MedicamentoHTMLcreator<Medicamentos>{
     private MedicamentoService medicamentoService;

    public MedicamentoHTML() {
        medicamentoService= new MedicamentoService();
    }
    @Override
    public void crearMedicamentoHTML(Medicamentos ob) {
       medicamentoService.crearMedicamento(ob);
    }

   
}
