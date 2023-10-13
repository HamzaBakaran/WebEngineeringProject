package ba.edu.ibu.webengineeringproject.core.api.mailsender;

import ba.edu.ibu.webengineeringproject.core.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MailSender {
    public String send(List<User> users, String message);
}
