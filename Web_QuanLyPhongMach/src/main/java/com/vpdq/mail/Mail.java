/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author vinhp
 */
public class Mail {

    public static void SendEmail(String contentbody, String toemail) throws MessagingException, UnsupportedEncodingException {
        //Email của bạn
        final String fromEmail = "1951012090phu@ou.edu.vn";
        // Mật khẩu Email của bạn
        final String emailPassword = "que191005";
        // Email người nhận
        final String toEmail = toemail;
        //Tiêu Đề
        final String subject = "Thư Xác Nhận Lịch Khám P&Q CLINCI";
        //Phần nội dung
        final String body = contentbody;
        //Kết nối mail
        Properties propt = new Properties();
        //SMTP Host
        propt.put("mail.smtp.host", "smtp.gmail.com");
        //TLS Port
        propt.put("mail.smtp.port", "587");
        //enable authentication
        propt.put("mail.smtp.auth", "true");
        //enable starttls
        propt.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, emailPassword);
            }
        };
        Session session = Session.getDefaultInstance(propt, auth);
        try {
            MimeMessage mmsg = new MimeMessage(session);
            //Message headers
            mmsg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            mmsg.addHeader("format", "flowed");
            mmsg.addHeader("Content-Transfer-Encoding", "8bit");
            mmsg.setFrom(new InternetAddress(fromEmail, "P&Q CLINCI"));
            mmsg.setReplyTo(InternetAddress.parse(fromEmail, false));
            //Tiêu đề - Nội dung - Ngày gửi
            mmsg.setSubject(subject, "UTF-8");
            mmsg.setText(body, "UTF-8");
            mmsg.setSentDate(new Date());
            mmsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            //Gửi
            Transport.send(mmsg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
