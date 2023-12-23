package ba.edu.ibu.webengineeringproject.core.repository;

import ba.edu.ibu.webengineeringproject.core.model.User;
import ba.edu.ibu.webengineeringproject.rest.dto.OrderCustomDTO;
import ba.edu.ibu.webengineeringproject.rest.dto.UserRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void shouldReturnAllUsers(){
        List<User> users =userRepository.findAll();
        Assertions.assertNotNull(users);

    }
}