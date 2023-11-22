/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;


import javax.mail.MessagingException;
import javax.mail.Transport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message.RecipientType;

/**
 *
 * @author LEIDY GIRALDO
 */
public class CorreoObservador implements Observador {
    private String correoDestino;

    public CorreoObservador(String correoDestino) {
        this.correoDestino=correoDestino;
    }

    
    @Override
    public void notificar(String mensaje) {       
        String usuario = "sofiprincesa1@gmail.com";
        String contrasenia = "xqou gmqx clun naht";       
        Properties mpropiedades= new Properties();
        Session sesion;
        MimeMessage micorreo;
        Transport mTransport;
        
        
        mpropiedades.put("mail.smtp.host", "smtp.gmail.com");
        mpropiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mpropiedades.setProperty("mail.smtp.starttls.enable", "true");
        mpropiedades.setProperty("mail.smtp.port", "587");
        mpropiedades.setProperty("mail.smtp.user", usuario);
        mpropiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mpropiedades.setProperty("mail.smtp.auth", "true");
       
        sesion= Session.getDefaultInstance(mpropiedades);
        micorreo= new MimeMessage(sesion);
        
        try{
            micorreo.setFrom(new InternetAddress(usuario));
            micorreo.setRecipient(RecipientType.TO, new InternetAddress(correoDestino));
            micorreo.setText(mensaje,"ISO-8859-1","html");
                      
        } catch (MessagingException ex) {
            Logger.getLogger(CorreoObservador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            mTransport= sesion.getTransport("smtp");
            mTransport.connect(usuario,contrasenia);
            mTransport.sendMessage(micorreo,micorreo.getRecipients(RecipientType.TO));
            mTransport.close();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(CorreoObservador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CorreoObservador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
        
        
    
    
 }
    
    

