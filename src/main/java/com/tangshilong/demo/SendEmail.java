package com.tangshilong.demo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Properties;
import java.util.Random;

public class SendEmail {
	private static final String HOST = "smtp.126.com";
	private static final String TO_TEST = "834848102@qq.com";
	private static final String FROM = "acm2011tsl@126.com";
	private static final String USER = "acm2011tsl@126.com";
	private static final String PASSWORD = "m201212231314";// 授权码

	private static void sendMail(String to) throws UnsupportedEncodingException {
		try {
			String pwd = getRandomString();// 生成6位随机字符串
			String html = "<div class='wrapper' style='width: 550px;margin: auto;'>"
					+ "<div style='height: 20px;background-color: #FFE48D;'></div>"
					+ "<div style='border-right: solid 1px #FFE48D;border-left: solid 1px #FFE48D;height: 200px;border-bottom: solid 1px #FFE48D;height: 200px;'>"
					+ "<div style='text-align: center;font-size: 18px;'>" + "尊敬的用户您好，您已通过邮箱修改用户登录密码，新密码为：" + "</div>"
					+ "<div style='text-align: center; font-size: 40px; color: #FF0000;padding-top: 30px;padding-bottom: 30px;'>"
					+ pwd + "</div>" + "<div style='text-align: center;font-size: 20px;'>如非本人操作请联系及时本公司管理人员</div>"
					+ "</div>" + "</div>";
			System.out.println(pwd);
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", HOST);
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				// 身份认证
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USER, PASSWORD);
				}
			});
			// 建立邮件对象
			MimeMessage message = new MimeMessage(session);
			// 设置邮件的发件人、收件人、主题
			// 附带发件人名字 message.setFrom(new InternetAddress("from_mail@qq.com",
			// "optional-personal"));
			message.setFrom(new InternetAddress(FROM, "维拓智能科技(深圳)有限公司"));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("维拓智能科技(深圳)有限公司");
//			message.setText(html);
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(html, "text/html;charset=UTF-8");
			MimeMultipart mmp1 = new MimeMultipart();
			mmp1.addBodyPart(textPart);
			message.setContent(mmp1);
			message.saveChanges();

			// //文本部分
			// MimeBodyPart textPart = new MimeBodyPart();
			// textPart.setContent("图<img src='cid:myimg'/>文加附件邮件测试",
			// "text/html;charset=UTF-8");
			// //内嵌图片部分
			// MimeBodyPart imagePart = new MimeBodyPart();
			// imagePart.setDataHandler(new DataHandler(new
			// FileDataSource("imagePath")));//图片路径
			// imagePart.setContentID("myimg");
			// //图文整合，关联关系
			// MimeMultipart mmp1 = new MimeMultipart();
			// mmp1.addBodyPart(textPart);
			// mmp1.addBodyPart(imagePart);
			// mmp1.setSubType("related");
			// MimeBodyPart textImagePart = new MimeBodyPart();
			// textImagePart.setContent(mmp1);
			// //附件部分
			// MimeBodyPart attachmentPart = new MimeBodyPart();
			// DataHandler dh = new DataHandler(new
			// FileDataSource("filePath"));//文件路径
			// String fileName = dh.getName();
			// attachmentPart.setDataHandler(dh);
			// attachmentPart.setFileName(fileName);
			// //图文和附件整合，复杂关系
			// MimeMultipart mmp2 = new MimeMultipart();
			// mmp2.addBodyPart(textImagePart);
			// mmp2.addBodyPart(attachmentPart);
			// mmp2.setSubType("mixed");
			// //将以上内容添加到邮件的内容中并确认
			// message.setContent(mmp2);
			// message.saveChanges();
			// //发送邮件
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	private static String getRandomString() { // length表示生成字符串的长度
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		sendMail(TO_TEST);
	}
}