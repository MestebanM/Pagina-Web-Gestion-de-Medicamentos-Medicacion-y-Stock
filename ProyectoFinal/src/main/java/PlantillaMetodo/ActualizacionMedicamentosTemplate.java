/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantillaMetodo;


import modelo.Medicamentos;

/**
 *
 * @author marin
 */
public abstract class ActualizacionMedicamentosTemplate {
    Medicamentos md;
    String newId;
     String newNombre;
     String newStock;

    public ActualizacionMedicamentosTemplate(String newId, String newNombre, String newStock) {
        this.newId = newId;
        this.newNombre = newNombre;
        this.newStock = newStock;
    }

    
    public final void actualizarMedicamento() {
        Medicamentos medicamento = obtenerMedicamento( newId);
        md= medicamento;
        actualizarInformacion(md);
        guardarEnBaseDeDatos(md);
        notificarActualizacion(md);
    }

    protected abstract Medicamentos obtenerMedicamento(String newId);

    protected abstract void actualizarInformacion(Medicamentos medicamento);

    protected abstract void guardarEnBaseDeDatos(Medicamentos medicamento);

    protected abstract void notificarActualizacion(Medicamentos medicamento);
    
    
}
