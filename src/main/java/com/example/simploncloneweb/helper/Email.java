package com.example.simploncloneweb.helper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    public static void sendEmail(String recipient, String name, String description) {
        System.out.println("");
        System.out.println(" Preparing send email...");
        System.out.println("");
        // Properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        String adminEmail = "lahmamimohammedamine@gmail.com";
        String adminPassword = "************";

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(adminEmail, adminPassword);
            }
        });
        Message message = prepareMessage(session, adminEmail, recipient, name, description);
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect("lahmamimohammedamine@gmail.com", "************");
            // Send message
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Sent message successfully....");
            transport.close();
        } catch (Exception ex) {
            System.out.println(" Email doesn't sent !!!");
            System.out.println(ex.getMessage());
        }

    }

    public static Message prepareMessage(Session session, String adminEmail, String recipient, String name, String description) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(adminEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            // Set Subject: header field
            message.setSubject("New brief");
            // Send the actual HTML message, as big as you like
            message.setContent(
                    "<div style=\"background-color: #dc2626;\">\n" +
                            "    <h1 style=\"text-align: center;color: white;padding-top: 10px;padding-bottom: 10px;\">"+name+"</h1>\n" +
                            "    <hr style=\"margin:auto; width:30%;background-color:white;border: 1px solid white;margin-bottom: 10px;\">\n" +
                            "    <p style=\"margin:auto;color: white;width: 80%;padding-bottom: 20px;\">\n"+ description +"\n" +
                            "        <br>\n" +
                            "        <br>\n" +
                            "        <a style=\"color: white; text-decoration: none;padding: 4px;text-size: 8px;border: 2; border-style: solid; border-radius: 6px;\" href=\"http://localhost:8080/login\">Simplon</a>\n" +
                            "    </p>\n" +
                            "</div>",
                    "text/html"
            );
//            message.setSubject(name);
//            message.setText(description);
            return message;
        } catch (Exception ex) {
            System.out.println(" error message");
        }
        return null;
    }
}