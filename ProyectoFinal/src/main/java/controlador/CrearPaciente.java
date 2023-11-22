/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.PacienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Paciente;

/**
 *
 * @author LEIDY GIRALDO
 */
@WebServlet(name = "CrearPaciente", urlPatterns = {"/CrearPaciente"})
public class CrearPaciente extends HttpServlet {

    

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
        if (request.getParameter("submit-btn") != null) {
            Paciente pac= new Paciente();
            pac.setNombre(request.getParameter("nombre"));
            pac.setApellido( request.getParameter("apellido"));
            pac.setCorreo( request.getParameter("correo"));
            pac.setEdad(request.getParameter("edad"));
            pac.setUsuario(request.getParameter("usuario"));
            pac.setContrasenia(request.getParameter("password"));
            pac.setConfirmarContra( request.getParameter("confirmar-password"));
            pac.setGenero( request.getParameter("genero"));
            PacienteDao daop = new PacienteDao();       
            daop.create(pac);
            response.sendRedirect("Inicio.html");
        }else{
            System.out.println("NO ENTRAAA");
        }
            
        
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
