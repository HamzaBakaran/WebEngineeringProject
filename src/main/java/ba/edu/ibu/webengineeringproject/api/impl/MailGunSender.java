package ba.edu.ibu.webengineeringproject.api.impl;

import ba.edu.ibu.webengineeringproject.core.api.mailsender.MailSender;
import ba.edu.ibu.webengineeringproject.core.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailGunSender implements MailSender {
    @Override
    public String send(List<User> users, String message) {
        for (User user: users) {
            System.out.println("Message sent to: " + user.getEmail());
        }
        return "Message: " + message + " | Sent via Mailgun.";
    }

}
