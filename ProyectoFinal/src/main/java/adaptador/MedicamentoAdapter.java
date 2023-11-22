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
public class MedicamentoAdapter implements MedicamentoService1<Medicamentos>{
private MedicamentoHTML medicamentoHTMLCreator;

    public MedicamentoAdapter() {
        medicamentoHTMLCreator= new MedicamentoHTML();
    }

    @Override
    public void crearMedicamento(Medicamentos ob) {
        medicamentoHTMLCreator.crearMedicamentoHTML(ob);
    }
    
}
