package com.Mail;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "preparing to send message...." );
        
        String message = "Hello this is message for security purpose";
        String subject = "for checking the mail conformation that is woking perfectly...";
        String to = "to_this_@gmail.com";
        String from = "from_this@gmail.com";
        
        //sendEmail(message,subject,to,from);
        sendAttached(message,subject,to,from);
        
    }

    //this is responsible send message with attachment.....
    private static void sendAttached(String message, String subject, String to, String from) {
		
    	// varaible for gmail
    			String host="smtp.gmail.com";
    			
    			//get the 
    			Properties properties = System.getProperties();
    			System.out.println("properties : "+properties);
    			
    			//setting import ingformation to property object
    			
    			//host set
    			properties.put("mail.smtp.host", host);
    			properties.put("mail.smtp.port", "465");
    			properties.put("mail.smtp.ssl.enable", "true");
    			properties.put("mail.smtp.auth", "true");
    			
    			//step 1 : to get the seession object
    			
    			Session session = Session.getInstance(properties, new Authenticator() {

    				@Override
    				protected PasswordAuthentication getPasswordAuthentication() {

    					return new PasswordAuthentication("from_this@gmail.com","password of this email adress/or try app password");
    					
    				}
    				
    			});
    			
    			session.setDebug(true);
    			
    			//step 2 : compose the message...
    			
    			MimeMessage m = new MimeMessage(session);
    			
    			try {
    				//from eamil id
    				m.setFrom(from);
    				
    				//adding recipient to message
    				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    				
    				//adding subject to message
    				m.setSubject(subject);
    				
    				
    				//attachment.......
    				//file path....
    				String path="path of your file which u want to attached..";
    				
    				MimeMultipart mimeMultipart = new MimeMultipart();
    				
    				//text and file
    				
    				MimeBodyPart textMime = new MimeBodyPart();
    				
    				MimeBodyPart fileMime = new MimeBodyPart();
    				
    				try {
						textMime.setText(message);
 
						File file = new File(path);
						fileMime.attachFile(file);
						
						
						mimeMultipart.addBodyPart(textMime);
						mimeMultipart.addBodyPart(fileMime);
						
						
    					
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
    				
    				//attaching.....
    				m.setContent(mimeMultipart);
    				    				
    				//adding text to message
    				//m.setText(message);
    				
    				//send
    				//step 3: send the message using transport class;
    				
    			
    				Transport.send(m);
    				
    				
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
   
    			
    			System.out.println("send successs.............");

    	
    	
    	
    	
		
	}


	//thsi method is responsible for send eamli...
	private static void sendEmail(String message, String subject, String to, String from) {
		
		// varaible for gmail
		String host="smtp.gmail.com";
		
		//get the 
		Properties properties = System.getProperties();
		System.out.println("properties : "+properties);
		
		//setting import ingformation to property object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step 1 : to get the seession object
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("mf7468928@gmail.com","vjex tiao wkio qrgi");
				
			}
			
		});
		
		session.setDebug(true);
		
		//step 2 : compose the message...
		
		MimeMessage m = new MimeMessage(session);
		
		try {
			//from eamil id
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//send
			//step 3: send the message using transport class;
			
			Transport.send(m);
			System.out.println("send successs.............");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
	
		
		
	}
    
}
