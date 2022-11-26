//
//import javax.mail.Transport;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.Date;
//import java.util.Properties;
//
//
//public class SendEmail {
//
//    public static String myEmailAccount = "3232085039@qq.com";
//    public static String myEmailPassword = "cwuwfmohzmvddbfa";
//    public static String myEmailSMTPHost = "smtp.qq.com";
//
//    // public static String receiveMailAccount = "qianjun.huang@mail.utoronto.ca";
//
//    /**
//     * Get a 6-bits random int value
//     * @return a 6-bits random int value
//     */
//    public int getRandomCode(){
//        return (int)(Math.random()*90000) + 100000;
//    }
//
//
//    /**
//     * Send an email with "subject" and "content" to receiveMailAccount
//     * @param receiveMailAccount  The address email we send to
//     * @param subject  "Varifying" or "Forget password"
//     * @param content   The random 6-digit int value
//     * @throws Exception
//     */
//    public void sendEmail(String receiveMailAccount, String subject, String content) throws Exception {
//        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
//        Properties props = new Properties();                    // 参数配置
//        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
//        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
//        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
//
//        //开启 SSL 安全连接
//
//        final String smtpPort = "465";
//        props.setProperty("mail.smtp.port", smtpPort);
//        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");
//        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
//
//
//        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
//        Session session = Session.getInstance(props);
//        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
//
//        // 3. 创建一封邮件
//        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, subject, content);
//
//        // 4. 根据 Session 获取邮件传输对象
//        Transport transport = session.getTransport();
//
//        // 5. 使用 邮箱账号 和 密码 连接邮件服务器
//        transport.connect(myEmailAccount, myEmailPassword);
//
//        // 6. 发送邮件
//        transport.sendMessage(message, message.getAllRecipients());
//
//        // 7. 关闭连接
//        transport.close();
//    }
//
//    /**
//     * 创建一封只包含文本的简单邮件
//     *
//     * @param session      和服务器交互的会话
//     * @param sendMail     发件人邮箱
//     * @param receiveMail   收件人邮箱
//     * @param subject      "Varifying" or "Forget password"
//     * @param content      The random 6-digit int value
//     * @return
//     * @throws Exception
//     */
//    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String subject, String content) throws Exception {
//        // 1. Create an empty email
//        MimeMessage message = new MimeMessage(session);
//
//        // 2. From
//        message.setFrom(new InternetAddress(sendMail, "QAForum", "UTF-8"));
//
//        // 3. To
//        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));
//
//        // 4. Subject
//        message.setSubject(subject, "UTF-8");
//
//        // 5. Content
//        message.setContent(content, "text/html;charset=UTF-8");
//
//        // 6.time
//        message.setSentDate(new Date());
//
//        // 7. save
//        message.saveChanges();
//
//        return message;
//    }
//
//}