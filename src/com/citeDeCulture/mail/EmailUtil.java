package com.citeDeCulture.mail;


import com.citeDeCulture.utils.AlertMaker;
import com.sun.mail.util.MailSSLSocketFactory;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Villan
 */
public class EmailUtil {

    private final static Logger LOGGER = LogManager.getLogger(EmailUtil.class.getName());

    public static void sendTestMail (String receiver, String sub, String Text) {

        Runnable emailSendTask = () -> {
            LOGGER.log(Level.INFO, "Initiating email sending task. Sending to {}");
            try {
                String host ="smtp.gmail.com" ;
            String user = "culturecite2@gmail.com";
            String pass = "D123456789d*";
            String to = receiver;
            String from = "culturecite2@gmail.com";
            String subject = sub;
            String messageText = Text;
            boolean sessionDebug = false;
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();

        }
            catch(Exception ex)
        {
            ex.printStackTrace();
    }
        };
        Thread mailSender = new Thread(emailSendTask, "EMAIL-SENDER");
        mailSender.start();
    }
}
