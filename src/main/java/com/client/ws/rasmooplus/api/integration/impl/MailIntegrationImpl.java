package com.client.ws.rasmooplus.api.integration.impl;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.client.ws.rasmooplus.api.integration.MailIntegration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MailIntegrationImpl implements MailIntegration {

	private JavaMailSender javaMailSender;

	@Override
	public void send(String mailTo, String message, String subject) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setSubject(subject);
		mailMessage.setTo(mailTo);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		
		javaMailSender.send(mailMessage);

	}

}
