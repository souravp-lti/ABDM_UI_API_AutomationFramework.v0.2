package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


import Base.MainBaseFeature;

	
	public class JavaEmailSender {
		/* 
	    public static void main(String[] agrs) {
	    	String message = "testmessage";
	    	String subject = "testSubject";
	    	String toMail = "sourav.padhi94@gmail.com";
	    	String fromMail = "sourav94padhi@gmail.com";
	    	
	    	//sendMail(message,subject,toMail,fromMail);
	    	sendMailAttach(message,subject,toMail,fromMail);
	    }
	    */

		public static void sendMailAttach(String message,String subject,String toMail,String fromMail) {
	    		
	    	String host = "smtp.gmail.com";
	    	
	    	Properties properties = System.getProperties();
	    	System.out.println("PROPERTIES"+properties);
	    	
	    	properties.put("mail.smtp.host", host);
	    	properties.put("mail.smtp.port", "465");
	    	properties.put("mail.smtp.ssl.enable", "true");
	    	properties.put("mail.smtp.auth", "true");	
	    	
	    	Session session = Session.getInstance(properties, new Authenticator() {
	    		
	    		@Override
	    		protected PasswordAuthentication getPasswordAuthentication() {
	    			return new PasswordAuthentication("sourav94padhi@gmail.com", "hixqppatinhzmyrh");
	    		}
			});
	    	
	    	session.setDebug(true);
	    	
	    	MimeMessage m =new MimeMessage(session);
	    	
	    	try {
	    		
				m.setFrom(fromMail);
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
				m.setSubject(subject);
				
				String path = "C:\\Users\\USER\\eclipse-workspace\\ABDM_Automation_Script.v.43\\SCREENSHOTS\\dashboard_will_be_displayed-Sun-Sep-25-21-59-35-IST-2022_FAILED.png";
				
				MimeMultipart mimeMultipart = new MimeMultipart();
				
				MimeBodyPart textMime = new MimeBodyPart();

				MimeBodyPart fileMime = new MimeBodyPart();
				
				try {
					textMime.setText(message);
					
					File file = new File(path);
					fileMime.attachFile(file);
					
					mimeMultipart.addBodyPart(textMime);
					mimeMultipart.addBodyPart(fileMime);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				m.setContent(mimeMultipart);
				
				Transport.send(m);
				
				System.out.println("Email sent successfully");
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	    }
     }
	

	

	


