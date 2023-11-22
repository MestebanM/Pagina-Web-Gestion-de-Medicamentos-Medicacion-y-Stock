/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import adaptador.MedicamentoAdapter;
import adaptador.MedicamentoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Medicamentos;

/**
 *
 * @author marin
 */
@WebServlet(name = "CrearMedicamento", urlPatterns = {"/CrearMedicamento"})
public class CrearMedicamento extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            Medicamentos md= new Medicamentos();
            md.setId(request.getParameter("id"));
            md.setNombre(request.getParameter("nombre"));
            md.setStock(request.getParameter("stock"));

            MedicamentoAdapter medicamentoAdapter = new MedicamentoAdapter();
            // Agregar mensajes de depuración           
            medicamentoAdapter.crearMedicamento(md);
            // Agregar mensaje de depuración
            response.sendRedirect("Intfarmaceuta.html");

        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
