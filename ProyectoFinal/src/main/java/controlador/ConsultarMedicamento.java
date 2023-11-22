/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Singleton.ConsultarMedicamentoS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Medicamentos;

/**
 *
 * @author LEIDY GIRALDO
 */
@WebServlet(name = "ConsultarMedicamento", urlPatterns = {"/ConsultarMedicamento"})
public class ConsultarMedicamento extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ConsultarMedicamentoS CMS = ConsultarMedicamentoS.getInstance();
        List<Medicamentos> medic = CMS.consultar();

        // Genera la tabla HTML
        response.setContentType("text/html");
        // Escribir el inicio de la tabla y las columnas del encabezado
        PrintWriter out = response.getWriter();
     // Escribir el inicio de la tabla y las columnas del encabezado con estilos
    out.println("<table style='border-collapse: collapse; width: 80%; margin: 0 auto; margin-right: 20px;'>");
    out.println("<thead style='background-color: #6FA5FF; color: white;'>");
    out.println("<tr>");
    out.println("<th style='padding: 15px; text-align: left; font-size: 16px;'>Nombre</th>");
    out.println("<th style='padding: 15px; text-align: left; font-size: 16px;'>Stock</th>");
    out.println("</tr>");
    out.println("</thead>");
    
    // Escribir el cuerpo de la tabla con los datos de los medicamentos y estilos
    out.println("<tbody>");
    for (Medicamentos medicamento : medic) {
        out.println("<tr>");
        out.println("<td style='padding: 10px; font-size: 14px;'>" + medicamento.getNombre() + "</td>");
        out.println("<td style='padding: 10px; font-size: 14px;'>" + medicamento.getStock() + "</td>");
        out.println("</tr>");
    }
    out.println("</tbody>");
    
    // Cerrar la tabla
    out.println("</table>");
    
    // Cerrar el objeto PrintWriter
    out.close();
       
    }

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
