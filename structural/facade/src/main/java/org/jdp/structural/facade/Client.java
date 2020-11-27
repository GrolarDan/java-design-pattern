package org.jdp.structural.facade;

import lombok.extern.slf4j.Slf4j;
import org.jdp.structural.facade.email.Email;
import org.jdp.structural.facade.email.Mailer;
import org.jdp.structural.facade.email.Stationary;
import org.jdp.structural.facade.email.StationaryFactory;
import org.jdp.structural.facade.email.Template;
import org.jdp.structural.facade.email.Template.TemplateType;
import org.jdp.structural.facade.email.TemplateFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Client implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(org.jdp.structural.facade.Client.class, args);
    }

    private static boolean sendOrderEmailWithoutFacade(Order order) {
        Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
        Stationary stationary = StationaryFactory.createStationary();
        Email email = Email.getBuilder()
                .withTemplate(template)
                .withStationary(stationary)
                .forObject(order)
                .build();
        Mailer mailer = Mailer.getMailer();
        return mailer.send(email);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order("101", 99.99);

        boolean result = sendOrderEmailWithoutFacade(order);

        log.info("Order Email {}", (result ? "sent!" : "NOT sent..."));
    }

}

// TODO
// 1) Switch println to log
// 2) Refactor application to be a Spring Boot application
// 3) Implement Facade

// Added git config --local core.autocrlf false
// to disable CRLF check