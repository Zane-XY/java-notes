mail
======
[JavaMail](https://java.net/projects/javamail/pages/Home) is:
- not extra-complicated to use
- actively developped
so, no need to use other shitty wrappers.

##### send smtp mail

```java
Session session = Session.getInstance(Config.props, null);
MimeMessage msg = new MimeMessage(session);
try {
    msg.setFrom(new InternetAddress(Config.get("mail.sender")));

    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Config.get("mail.recipient"), false));
    msg.setSubject("subj");
    msg.setText(content, "utf-8", "html");
    msg.setHeader("X-Mailer", "header");
    msg.setSentDate(new Date());
    SMTPTransport transport = (SMTPTransport) session.getTransport("smtp");
    transport.connect();
    transport.sendMessage(msg, msg.getAllRecipients());
    logger.info(transport.getLastServerResponse());
    transport.close();
} catch (MessagingException e) {
    logger.log(Level.SEVERE, e.getMessage());
}
```
