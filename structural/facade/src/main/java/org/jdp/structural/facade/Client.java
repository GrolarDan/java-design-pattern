package org.jdp.structural.facade;

import lombok.extern.slf4j.Slf4j;
import org.jdp.structural.facade.email.Email;
import org.jdp.structural.facade.email.Mailer;
import org.jdp.structural.facade.email.Stationary;
import org.jdp.structural.facade.email.StationaryFactory;
import org.jdp.structural.facade.email.Template;
import org.jdp.structural.facade.email.Template.TemplateType;
import org.jdp.structural.facade.email.TemplateFactory;

@Slf4j
public class Client {

    public static void main(String[] args) {
        Order order = new Order("101", 99.99);

        boolean result = sendOrderEmailWithoutFacade(order);

        log.info("Order Email {}", (result ? "sent!" : "NOT sent..."));

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

}

// TODO
// 1) Switch println to log
// 2) Implement Facade

// Added git config --local core.autocrlf false
// to disable CRLF check