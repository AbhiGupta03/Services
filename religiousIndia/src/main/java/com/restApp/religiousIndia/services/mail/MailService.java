package com.restApp.religiousIndia.services.mail;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MailService {
	private static Logger logger = Logger.getLogger(MailService.class);

	@Autowired
	private JavaMailSender mailSender;

	public Boolean sendEmail(String to, String messageBody, String subject, Boolean isHtml) {
		logger.info("Sending mail....");
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setText(messageBody, isHtml);
			helper.setSubject(subject);

			mailSender.send(message);
			logger.info("Mail sent successfully");
			return true;
		} catch (Exception e) {
			logger.error("Eroor:" + e + " in sendEmail");
			return false;
		}
	}

	public String getImpNotes() {
		String impNotes = "<b>Important Notes: </b><br><br>";

		impNotes += "1- Please activate your account by clicking the activation link. <br><br>";

		impNotes += "2- Please fill your user profile.";
		return impNotes;
	}

	public String getMailSignature() {
		String mailSignature = "<br><br>Thanks,<br><br>";

		mailSignature += "Religious India Support team.";
		return mailSignature;
	}
}
