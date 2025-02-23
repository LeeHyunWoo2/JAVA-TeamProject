<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, javax.mail.*, javax.mail.internet.*" %>
<%
    String to = "spn8@spondonit.com";
    String from = request.getParameter("email");
    String name = request.getParameter("name");
    String subject = request.getParameter("subject");
    String number = request.getParameter("number");
    String cmessage = request.getParameter("message");

    // SMTP 서버 정보
    String host = "smtp.example.com"; // 실제 SMTP 서버 주소로 변경
    final String username = "your-email@example.com"; // SMTP 인증 사용자 이름
    final String password = "your-email-password"; // SMTP 인증 비밀번호

    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "587"); // TLS 포트

    Session mailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {
        // 이메일 메시지 생성
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("You have a message from your Bitmap Photography.");

        String logo = "img/logo.png";
        String link = "#";

        String content = "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>Express Mail</title></head><body>";
        content += "<table style='width: 100%;'>";
        content += "<thead style='text-align: center;'><tr><td style='border:none;' colspan='2'>";
        content += "<a href='" + link + "'><img src='" + logo + "' alt=''></a><br><br>";
        content += "</td></tr></thead><tbody><tr>";
        content += "<td style='border:none;'><strong>Name:</strong> " + name + "</td>";
        content += "<td style='border:none;'><strong>Email:</strong> " + from + "</td>";
        content += "</tr>";
        content += "<tr><td style='border:none;'><strong>Subject:</strong> " + subject + "</td></tr>";
        content += "<tr><td></td></tr>";
        content += "<tr><td colspan='2' style='border:none;'>" + cmessage + "</td></tr>";
        content += "</tbody></table>";
        content += "</body></html>";

        message.setContent(content, "text/html; charset=ISO-8859-1");

        // 이메일 전송
        Transport.send(message);
        out.println("Mail successfully sent");
    } catch (MessagingException mex) {
        mex.printStackTrace();
        out.println("Error: unable to send mail");
    }
%>