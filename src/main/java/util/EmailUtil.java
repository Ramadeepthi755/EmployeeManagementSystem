package util;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailUtil {

    private static final String FROM =
            "ramadeepthibadireddy@gmail.com";

    private static final String PASSWORD =
            "ecqnfivnzscxxgyr";

    public static void sendEmail(
            String to,
            String subject,
            String body) {

        Properties props =
                new Properties();

        props.put(
                "mail.smtp.auth",
                "true");

        props.put(
                "mail.smtp.starttls.enable",
                "true");

        props.put(
                "mail.smtp.host",
                "smtp.gmail.com");

        props.put(
                "mail.smtp.port",
                "587");

        Session session =
                Session.getInstance(
                        props,
                        new Authenticator() {

            protected PasswordAuthentication
            getPasswordAuthentication() {

                return new PasswordAuthentication(
                        FROM,
                        PASSWORD);
            }
        });

        try {

            Message message =
                    new MimeMessage(session);

            message.setFrom(
                    new InternetAddress(FROM));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to));

            message.setSubject(subject);

            message.setText(body);

            Transport.send(message);

            System.out.println(
                    "Email Sent Successfully");

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}