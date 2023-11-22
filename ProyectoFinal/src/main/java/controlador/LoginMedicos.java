/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import decorator.IniciarSesion;
import decorator.InicioBase;
import decorator.InicioMedicoDecorator;
import decorator.InicioPacienteDecorator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LEIDY GIRALDO
 */
@WebServlet(name = "LoginFuncionario", urlPatterns = {"/LoginFuncionario"})
public class LoginMedicos extends HttpServlet {



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
        
        ResultSet rs = null;
        String nombreUsuario = request.getParameter("Usuario");
        String password = request.getParameter("password");
        IniciarSesion inicioBase = new InicioBase();
        IniciarSesion inicioP= new InicioMedicoDecorator(inicioBase);
            if (inicioP.iniciarSesion(nombreUsuario, password)) {
                response.sendRedirect("IntMedico.jsp");
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('Inicio de sesión fallido. Verifica tus credenciales.');"
                        + "window.location.href='ISMedico.jsp';</script>");
                response.sendRedirect("ISMedico.jsp");
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
