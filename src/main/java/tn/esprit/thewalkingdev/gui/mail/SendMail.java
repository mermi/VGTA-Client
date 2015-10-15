package tn.esprit.thewalkingdev.gui.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 *
 * @author anas
 */
public class SendMail {
    
    
    
    public static void sendMessage(String subject, String text, String destinataire, String copyDest) { 
    
    	final String username = "anesmazouni@gmail.com";
		final String password = "Stargatesg1";
		
		 String d_email = "anesmazouni@gmail.com",
		         
		            d_host = "smtp.gmail.com",
		            d_port = "465";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		  props.put("mail.smtp.user", d_email);
	        props.put("mail.smtp.host", d_host);
	        props.put("mail.smtp.port", d_port);
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.debug", "true");
	        props.put("mail.smtp.socketFactory.port", d_port);
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");
	       

		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(copyDest));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinataire));
			message.setSubject("VGTA");
			message.setText(subject);
			System.out.println(copyDest);
			System.out.println(destinataire);
			System.out.println(subject);
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    
    
    
    }
}