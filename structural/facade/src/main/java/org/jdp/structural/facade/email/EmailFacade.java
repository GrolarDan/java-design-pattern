package org.jdp.structural.facade.email;

//Facade provides simple methods for client to use

import org.jdp.structural.facade.Order;
import org.springframework.stereotype.Service;

@Service
public class EmailFacade {
    
    public boolean sendOrderEmailWithoutFacade(Order order) {
        Template template = TemplateFactory.createTemplateFor(Template.TemplateType.Email);
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
