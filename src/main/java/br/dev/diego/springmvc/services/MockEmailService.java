package br.dev.diego.springmvc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg){
        LOG.info("Simulando envio de e-mail");
        LOG.info(msg.toString());
        LOG.info("Email enviado.");
    }

    @Override
    public void sendHtmlEmail(MimeMessage msg){
        LOG.info("Simulando envio de e-mail HTML");
        LOG.info(msg.toString());
        LOG.info("Email enviado.");
    }
}
