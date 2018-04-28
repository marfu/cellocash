package com.cellocash.security.serviceImpl;


import com.cellocash.security.service.IUtilService;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;




@Stateless
@Local(IUtilService.class)
public class UtilServiceImpl implements IUtilService, Serializable {

    /**
     *
     */
    public static final long serialVersionUID = 1L;

    public static final Logger logger = Logger
            .getLogger(UtilServiceImpl.class);

    

    @SuppressWarnings("static-access")
    @Override
    public boolean sendMailCBMag(String codeArticle, String pvtCode) throws Exception {
        InitialContext ctx = new InitialContext();
        Session mailSession = (Session) ctx.lookup("java:/Mail");
        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("CODE BARRE CREER EN MAGASIN");
        message.setRecipients(RecipientType.TO, new javax.mail.internet.InternetAddress().parse("zakhdar@prosuma.ci", false));

        StringBuffer body = new StringBuffer();
        body.append("Merci d' affecter les code-barres ci dessous à l' article suivant : \n");

       
        //body.append("Article : " + codeArticle + " , " + a.getDesignation() + " \n");
      


        message.setText(body.toString());
        message.saveChanges();

        Transport transport = mailSession.getTransport("smtp");
        try {
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
        } finally {
            transport.close();

        }

        return true;

    }

   
}
