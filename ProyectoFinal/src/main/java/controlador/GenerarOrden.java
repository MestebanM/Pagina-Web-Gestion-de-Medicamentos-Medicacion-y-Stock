/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import observer.CorreoObservador;
import observer.GeneradorOrden;

/**
 *
 * @author LEIDY GIRALDO
 */
@WebServlet(name = "GenerarOrden", urlPatterns = {"/GenerarOrden"})
public class GenerarOrden extends HttpServlet {


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
       String nombre= request.getParameter("nombre");
       String stock = request.getParameter("stock");
       String numero = request.getParameter("numero");
       
        GeneradorOrden generadorOrden = new GeneradorOrden();
        CorreoObservador correoObservador = new CorreoObservador(numero);

        generadorOrden.agregarObservador(correoObservador);
       
        generadorOrden.generarOrden(nombre, stock, numero);
        
        response.sendRedirect("IntMedico_2.html");
       
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
